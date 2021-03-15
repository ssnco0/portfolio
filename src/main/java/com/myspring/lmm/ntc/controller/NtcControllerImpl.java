package com.myspring.lmm.ntc.controller;


import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.lmm.ntc.service.NtcService;
import com.myspring.lmm.ntc.vo.NtcVO;
import com.myspring.lmm.admin.member.vo.ManagerVO;

@Controller("ntcController")
public class NtcControllerImpl implements NtcController{
	
	@Autowired
	private NtcService boardService;
	@Autowired
	private NtcVO articleVO;
	
	@Override
	@RequestMapping(value= "/ntc/listArticles.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List articlesList = boardService.listArticles();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList);
		return mav;
		
	}
	
	 //�� �� �̹��� �۾���
		@Override
		@RequestMapping(value="/ntc/addNewArticle.do" ,method = {RequestMethod.GET,RequestMethod.POST})
		@ResponseBody
		public ResponseEntity addNewArticle( MultipartHttpServletRequest multipartRequest, 
		HttpServletResponse response) throws Exception {
			multipartRequest.setCharacterEncoding("utf-8");
			ModelAndView mav = new ModelAndView();
			Map<String,Object> articleMap = new HashMap<String, Object>();
			Enumeration enu= multipartRequest.getParameterNames();
			while(enu.hasMoreElements()){
				String name =(String)enu.nextElement();
				
				String value = multipartRequest.getParameter(name);
				System.out.println(name + value);			
				articleMap.put(name,value);
				System.out.println(articleMap);
			}
			
			
			HttpSession session = multipartRequest.getSession();		
			ManagerVO managerInfo = (ManagerVO) session.getAttribute("managerInfo");
			String id = managerInfo.getManId();
			
			articleMap.put("ntcitWriter", id);		
			mav.addObject("articleMap", articleMap);
			String message;
			ResponseEntity resEnt=null;
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "text/html; charset=utf-8");
			
			try {
				int articleNO = boardService.addNewArticle(articleMap);
				
		
				message = "<script>";
				message += " alert('������ �߰��߽��ϴ�.');";
				message += " location.href='"+ multipartRequest.getContextPath()+"/ntc/listArticles.do'; ";
				message +=" </script>";
			    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			
			}catch(Exception e) {			
				
				message = " <script>";
				message +=" alert('������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');');";
				message +=" location.href='"+ multipartRequest.getContextPath()+"/ntc/articleForm.do'; ";
				message +=" </script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
				e.printStackTrace();
			}
			return resEnt;
		}
	
	
	//�Ѱ��� �̹��� �����ֱ�
	@RequestMapping(value="/ntc/viewArticle.do" ,method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView viewArticle(@RequestParam("articleNO") int ntcNo,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		ManagerVO managerVO = (ManagerVO) session.getAttribute("managerInfo");
		
		mav.addObject("id",managerVO);			
		
		String viewName = (String)request.getAttribute("viewName");
		articleVO=boardService.viewArticle(ntcNo);		
		
		mav.setViewName(viewName);
		mav.addObject("article", articleVO);
		return mav;
	}	

	
	
	  //�� �� �̹��� ���� ���
	  @RequestMapping(value="/ntc/modArticle.do" ,method = {RequestMethod.GET,RequestMethod.POST})
	  @ResponseBody
	  public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest,  
	    HttpServletResponse response) throws Exception{
	    multipartRequest.setCharacterEncoding("utf-8");
		Map<String,Object> articleMap = new HashMap<String, Object>();
		Enumeration enu=multipartRequest.getParameterNames();
		while(enu.hasMoreElements()){
			String name = (String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name,value);
			System.out.println("=========================="+articleMap);
		}
			
		String articleNO=(String)articleMap.get("articleNO");
		String message;
		
		
		ResponseEntity resEnt=null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	    try {
	       boardService.modArticle(articleMap);
	      
	       	
	       message = "<script>";
		   message += " alert('���� �����߽��ϴ�.');";
		   message += " location.href='"+multipartRequest.getContextPath()+"/ntc/viewArticle.do?articleNO="+articleNO+"';";
		   message +=" </script>";
	       resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	   
	    }catch(Exception e) {
	      
	      message = "<script>";
		  message += " alert('������ �߻��߽��ϴ�.�ٽ� �������ּ���');";
		  message += " location.href='"+multipartRequest.getContextPath()+"/ntc/viewArticle.do?articleNO="+articleNO+"';";
		  message +=" </script>";
	      resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	    }
	    return resEnt;
	  }
	  
  
  @Override
  @RequestMapping(value="/ntc/removeArticle.do" ,method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity  removeArticle(@RequestParam("articleNO") int ntcNo,
                              HttpServletRequest request, HttpServletResponse response) throws Exception{
	response.setContentType("text/html; charset=UTF-8");
	String message;
	ResponseEntity resEnt=null;
	HttpHeaders responseHeaders = new HttpHeaders();
	responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	try {
		boardService.removeArticle(ntcNo);
		
		message = "<script>";
		message += " alert('���� �����߽��ϴ�.');";
		message += " location.href='"+request.getContextPath()+"/ntc/listArticles.do';";
		message +=" </script>";
	    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	       
	}catch(Exception e) {
		message = "<script>";
		message += " alert('�۾��� ������ �߻��߽��ϴ�.�ٽ� �õ��� �ּ���.');";
		message += " location.href='"+request.getContextPath()+"/ntc/listArticles.do';";
		message +=" </script>";
	    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	    e.printStackTrace();
	}
	return resEnt;
  }  
  
/*
  //���� �̹��� �� �߰��ϱ�
  @Override
  @RequestMapping(value="/ntc/addNewArticle.do" ,method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity  addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
	multipartRequest.setCharacterEncoding("utf-8");
	String imageFileName=null;
	
	Map articleMap = new HashMap();
	Enumeration enu=multipartRequest.getParameterNames();
	while(enu.hasMoreElements()){
		String name=(String)enu.nextElement();
		String value=multipartRequest.getParameter(name);
		articleMap.put(name,value);
	}
	
	//�α��� �� ���ǿ� ����� ȸ�� �������� �۾��� ���̵� ���ͼ� Map�� �����մϴ�.
	HttpSession session = multipartRequest.getSession();
	MemberVO memberVO = (MemberVO) session.getAttribute("member");
	String id = memberVO.getId();
	articleMap.put("id",id);
	
	
	List<String> fileList =upload(multipartRequest);
	List<ImageVO> imageFileList = new ArrayList<ImageVO>();
	if(fileList!= null && fileList.size()!=0) {
		for(String fileName : fileList) {
			ImageVO imageVO = new ImageVO();
			imageVO.setImageFileName(fileName);
			imageFileList.add(imageVO);
		}
		articleMap.put("imageFileList", imageFileList);
	}
	String message;
	ResponseEntity resEnt=null;
	HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	try {
		int articleNO = boardService.addNewArticle(articleMap);
		if(imageFileList!=null && imageFileList.size()!=0) {
			for(ImageVO  imageVO:imageFileList) {
				imageFileName = imageVO.getImageFileName();
				File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
				File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
				//destDir.mkdirs();
				FileUtils.moveFileToDirectory(srcFile, destDir,true);
			}
		}
		    
		message = "<script>";
		message += " alert('������ �߰��߽��ϴ�.');";
		message += " location.href='"+multipartRequest.getContextPath()+"/ntc/listArticles.do'; ";
		message +=" </script>";
	    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	    
		 
	}catch(Exception e) {
		if(imageFileList!=null && imageFileList.size()!=0) {
		  for(ImageVO  imageVO:imageFileList) {
		  	imageFileName = imageVO.getImageFileName();
			File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
		 	srcFile.delete();
		  }
		}

		
		message = " <script>";
		message +=" alert('������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');');";
		message +=" location.href='"+multipartRequest.getContextPath()+"/ntc/articleForm.do'; ";
		message +=" </script>";
		resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		e.printStackTrace();
	}
	return resEnt;
  }
	
*/

	

	@RequestMapping(value = "/ntc/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		ManagerVO managerVO = (ManagerVO) session.getAttribute("managerInfo");
		String id = managerVO.getManId();
		mav.addObject("manId", id);
		mav.setViewName(viewName);
		return mav;
	}

	

}
