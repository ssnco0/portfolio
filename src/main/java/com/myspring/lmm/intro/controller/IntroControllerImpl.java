package com.myspring.lmm.intro.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.lmm.intro.service.IntroService;
import com.myspring.lmm.intro.vo.IntroVO;
import com.myspring.lmm.store.vo.StoreVO;

@Controller("introController")
public class IntroControllerImpl implements IntroController{
	private static final String ARTICLE_IMAGE_REPO = "C:\\intro\\article_image";
	@Autowired
	private IntroService boardService;
	@Autowired
	private IntroVO articleVO;
	
	@Override
	@RequestMapping(value= "/intro/listArticles.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List articlesList = boardService.listArticles();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList);
		return mav;
		
	}
	
	 //�� �� �̹��� �۾���
	@Override
	@RequestMapping(value="/intro/addNewArticle.do" ,method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, 
	HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		Map<String,Object> articleMap = new HashMap<String, Object>();
		Enumeration enu=multipartRequest.getParameterNames();
		while(enu.hasMoreElements()){
			String name=(String)enu.nextElement();
			
			String value = multipartRequest.getParameter(name);
			System.out.println("=========== : " + name + "+" + value);					
			articleMap.put(name,value);
			System.out.println(articleMap);
		}
		
		
		String sBImageFileName= upload(multipartRequest);
		HttpSession session = multipartRequest.getSession();
		StoreVO storeVO = (StoreVO) session.getAttribute("storeInfo");
		String id = storeVO.getStoId();
	
		articleMap.put("stoId", id);
		articleMap.put("sBImageFileName", sBImageFileName);
		mav.addObject("articleMap", articleMap);
		String message;
		ResponseEntity resEnt=null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		try {
			int articleNO = boardService.addNewArticle(articleMap);
			
			if(sBImageFileName!=null && sBImageFileName.length()!=0) {
				File srcFile = new 
				File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+sBImageFileName);
				File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
				FileUtils.moveFileToDirectory(srcFile, destDir,true);
			}
	
			message = "<script>";
			message += " alert('������ �߰��߽��ϴ�.');";
			message += " location.href='"+multipartRequest.getContextPath()+"/intro/listArticles.do'; ";
			message +=" </script>";
		    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+sBImageFileName);
			srcFile.delete();
			
			message = " <script>";
			message +=" alert('������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');');";
			message +=" location.href='"+multipartRequest.getContextPath()+"/intro/articleForm.do'; ";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	
	//�Ѱ��� �̹��� �����ֱ�
	@RequestMapping(value="/intro/viewArticle.do" ,method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView viewArticle(@RequestParam("articleNO") int siNo,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		StoreVO storeVO = (StoreVO) session.getAttribute("storeInfo");
		
		mav.addObject("id",storeVO);		
		
		String viewName = (String)request.getAttribute("viewName");
		articleVO = boardService.viewArticle(siNo);
		
		mav.setViewName(viewName);
		mav.addObject("article", articleVO);
		return mav;
	}
	
	
  //�� �� �̹��� ���� ���
  @RequestMapping(value="/intro/modArticle.do" ,method = {RequestMethod.GET,RequestMethod.POST})
  @ResponseBody
  public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest,  
    HttpServletResponse response) throws Exception{
    multipartRequest.setCharacterEncoding("utf-8");
	Map<String,Object> articleMap = new HashMap<String, Object>();
	Enumeration enu=multipartRequest.getParameterNames();
	while(enu.hasMoreElements()){
		String name=(String)enu.nextElement();
		String value=multipartRequest.getParameter(name);
		articleMap.put(name,value);
		System.out.println("=========================="+articleMap);
	}
	
	
	String sBImageFileName= upload(multipartRequest);
	HttpSession session = multipartRequest.getSession();
	

	articleMap.put("sBImageFileName", sBImageFileName);
	
	String articleNO=(String)articleMap.get("articleNO");
	String message;
	
	ResponseEntity resEnt=null;
	HttpHeaders responseHeaders = new HttpHeaders();
	responseHeaders.add("Content-Type", "text/html; charset=utf-8");
    try {
       boardService.modArticle(articleMap);
       if(sBImageFileName!=null && sBImageFileName.length()!=0) {
         File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+sBImageFileName);
         File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
         FileUtils.moveFileToDirectory(srcFile, destDir, true);
         
         String originalFileName = (String)articleMap.get("originalFileName");
         File oldFile = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO+"\\"+originalFileName);
         oldFile.delete();
       }	
       message = "<script>";
	   message += " alert('���� �����߽��ϴ�.');";
	   message += " location.href='"+multipartRequest.getContextPath()+"/intro/viewArticle.do?articleNO="+articleNO+"';";
	   message +=" </script>";
       resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
    }catch(Exception e) {
      File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+sBImageFileName);
      srcFile.delete();
      System.out.println("���� �� �� :=================" + articleMap);
      message = "<script>";
	  message += " alert('������ �߻��߽��ϴ�.�ٽ� �������ּ���');";
	  message += " location.href='"+multipartRequest.getContextPath()+"/intro/viewArticle.do?articleNO="+articleNO+"';";
	  message +=" </script>";
      resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
    }
    return resEnt;
  }
  
  @Override
  @RequestMapping(value="/intro/removeArticle.do" ,method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity  removeArticle(@RequestParam("articleNO") int siNo,
                              HttpServletRequest request, HttpServletResponse response) throws Exception{
	response.setContentType("text/html; charset=UTF-8");
	String message;
	ResponseEntity resEnt=null;
	HttpHeaders responseHeaders = new HttpHeaders();
	responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	try {
		boardService.removeArticle(siNo);
		File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+siNo);
		FileUtils.deleteDirectory(destDir);
		
		message = "<script>";
		message += " alert('���� �����߽��ϴ�.');";
		message += " location.href='"+request.getContextPath()+"/intro/listArticles.do';";
		message +=" </script>";
	    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	       
	}catch(Exception e) {
		message = "<script>";
		message += " alert('�۾��� ������ �߻��߽��ϴ�.�ٽ� �õ��� �ּ���.');";
		message += " location.href='"+request.getContextPath()+"/intro/listArticles.do';";
		message +=" </script>";
	    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	    e.printStackTrace();
	}
	return resEnt;
  }  
  

	

	@RequestMapping(value = "/intro/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		StoreVO storeVO = (StoreVO) session.getAttribute("storeInfo");
		String id = storeVO.getStoId();
		mav.addObject("stoId", id);
		mav.setViewName(viewName);
		return mav;
	}

	//�Ѱ� �̹��� ���ε��ϱ�
	private String upload(MultipartHttpServletRequest multipartRequest) throws Exception{
		String sBImageFileName= null;
		Iterator<String> fileNames = multipartRequest.getFileNames();
		
		while(fileNames.hasNext()){
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			sBImageFileName=mFile.getOriginalFilename();
			File file = new File(ARTICLE_IMAGE_REPO +"\\"+ fileName);
			if(mFile.getSize()!=0){ //File Null Check
				if(! file.exists()){ //��λ� ������ �������� ���� ���
					if(file.getParentFile().mkdirs()){ //��ο� �ش��ϴ� ���丮���� ����
							file.createNewFile(); //���� ���� ����
					}
				}
				mFile.transferTo(new File(ARTICLE_IMAGE_REPO +"\\"+"temp"+ "\\"+sBImageFileName)); //�ӽ÷� ����� multipartFile�� ���� ���Ϸ� ����
			}
		}
		return sBImageFileName;
	}
	
	
}
