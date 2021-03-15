package com.myspring.lmm.store.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.lmm.admin.member.vo.ManagerVO;
import com.myspring.lmm.store.service.StoreService;
import com.myspring.lmm.store.vo.StoreVO;





@Controller("storeController")
@RequestMapping(value="/store")
public class StoreControllerImpl   implements StoreController {
	private static final Logger logger = LoggerFactory.getLogger(StoreControllerImpl.class);
	private static final String STORE_CARD_IMAGE = "C:\\store\\storeCard";
	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreVO storeVO ;
	
	//로그인
	@Override
	@RequestMapping(value="/login.do" ,method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView login(@ModelAttribute("storeVO") StoreVO storeVO,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
	    
		ModelAndView mav = new ModelAndView();
		storeVO=storeService.login(storeVO);
		
		String SA = storeVO.getStoSignApp();
		  String ok = "1";
		  String no = "0";
		System.out.println("==============================="+SA);

		if(storeVO!= null && storeVO.getStoId()!=null && SA.equals(ok)){
		    HttpSession session=request.getSession();
		    session=request.getSession();
		    session.setAttribute("storeInfo",storeVO);
		    session.setAttribute("isLogOn", true);
		    
		    mav.setViewName("redirect:/main.do");
		    
		}else if(storeVO!= null && storeVO.getStoId()!=null && SA.equals(no)){
		    String message=" 다시 로그인해주세요";
			mav.addObject("message", message);
			mav.setViewName("redirect:/main.do");
			
		}else {
		    String message="아이디나  비밀번호가 틀립니다. 다시 로그인해주세요";
			mav.addObject("message", message);
			mav.setViewName("redirect:/store/loginForm");
		}
		return mav;
	}
	
	//로그아웃
	@Override
	@RequestMapping(value="/logout.do" ,method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession();
		session.setAttribute("isLogOn", false);
		session.removeAttribute("storeInfo");
		session.invalidate();
		mav.setViewName("redirect:/main.do");
		return mav;
	}
	//회원등록
	@Override
	@RequestMapping(value="/addStore.do" ,method = RequestMethod.POST)
	public ResponseEntity addStore(@ModelAttribute("storeVO") StoreVO storeVO,
			                HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		
		String store1 = storeVO.getStoSignApp();
		System.out.println(store1);
		
		try {
			storeService.addStore(storeVO);
		    message  = "<script>";
		    message += " alert('회원 가입을 마쳤습니다.로그인창으로 이동합니다.');";
		    message += " location.href='"+request.getContextPath()+"/member/loginForm.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
		    message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/store/storeForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
	
	//폼 -로그인/회원가입
	@RequestMapping(value = { "/loginForm.do", "/storeForm.do" }, method =  RequestMethod.GET)
	public ModelAndView form(@RequestParam(value="result", required=false) String result,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}
	
	//ID검사
	@Override
	@RequestMapping(value="/overlapped.do" ,method = RequestMethod.POST)
	public ResponseEntity overlapped(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
		String result = storeService.overlapped(id);
		resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
	
	//휴대폰 검사
	@Override
	@RequestMapping(value="/overlappedPh.do" ,method = RequestMethod.POST)
	public ResponseEntity overlappedPh(@RequestParam("phone") String phone,HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
		String result = storeService.overlappedPh(phone);
		resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
	//이메일 검사
		@Override
		@RequestMapping(value="/overlappedEm.do" ,method = RequestMethod.POST)
		public ResponseEntity overlappedEm(@RequestParam("email") String email,HttpServletRequest request, HttpServletResponse response) throws Exception{
			ResponseEntity resEntity = null;
			String result = storeService.overlappedPh(email);
			resEntity =new ResponseEntity(result, HttpStatus.OK);
			return resEntity;
		}
	// 아이디 찾기 폼
	@RequestMapping(value = "/findidform.do")
	public String findidform() throws Exception {
		return "/store/findidform";
	}
	// 아이디 찾기
	@RequestMapping(value = "/findid.do", method = RequestMethod.POST)
	public String findid(HttpServletResponse response, @RequestParam("email") String email, Model md) throws Exception{
		md.addAttribute("stoId", storeService.findid(response, email));
		return "/strore/findid";
	}
	// 비밀번호 찾기 폼
	@RequestMapping(value = "/findpwfom.do")
	public String findpwform() throws Exception {
		return "/store/findpwform";
	}
		
			
	// 비밀번호 찾기
	@RequestMapping(value = "/findpw.do", method = RequestMethod.POST)
	public void findpw(@ModelAttribute StoreVO storeVO, HttpServletResponse response) throws Exception{
	    	storeService.findpw(response, storeVO);
	}
	
	 //한 개 이미지 글쓰기
	@Override
	@RequestMapping(value="/upload.do" ,method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addScImg(MultipartHttpServletRequest multipartRequest,HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String,Object> scMap = new HashMap<String, Object>();
		Enumeration enu=multipartRequest.getParameterNames();
		while(enu.hasMoreElements()){
			String name=(String)enu.nextElement();
			String value=multipartRequest.getParameter(name);
			scMap.put(name,value);
		}
		
		String scImageFileName= upload(multipartRequest);
		HttpSession session = multipartRequest.getSession();
		StoreVO storeVO = (StoreVO) session.getAttribute("store");
		String stoId = storeVO.getStoId();
		scMap.put("scNo", 0);
		scMap.put("stoId", stoId);
		scMap.put("scImageFileName", scImageFileName);
		
		String message;
		ResponseEntity resEnt=null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int scNo = storeService.addScImg(scMap);
			if(scImageFileName!=null && scImageFileName.length()!=0) {
				File srcFile = new 
				File(STORE_CARD_IMAGE+"\\"+"temp"+"\\"+scImageFileName);
				File destDir = new File(STORE_CARD_IMAGE+"\\"+scNo);
				FileUtils.moveFileToDirectory(srcFile, destDir,true);
			}
	
	
		}catch(Exception e) {
			File srcFile = new File(STORE_CARD_IMAGE+"\\"+"temp"+"\\"+scImageFileName);
			srcFile.delete();

			e.printStackTrace();
		}
		return resEnt;
	}
	private String upload(MultipartHttpServletRequest multipartRequest) throws Exception{
		String scImageFileName= null;
		Iterator<String> fileNames = multipartRequest.getFileNames();
		
		while(fileNames.hasNext()){
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			scImageFileName=mFile.getOriginalFilename();
			File file = new File(STORE_CARD_IMAGE +"\\"+ fileName);
			if(mFile.getSize()!=0){ //File Null Check
				if(! file.exists()){ //경로상에 파일이 존재하지 않을 경우
					if(file.getParentFile().mkdirs()){ //경로에 해당하는 디렉토리들을 생성
							file.createNewFile(); //이후 파일 생성
					}
				}
				mFile.transferTo(new File(STORE_CARD_IMAGE +"\\"+"temp"+ "\\"+scImageFileName)); //임시로 저장된 multipartFile을 실제 파일로 전송
			}
		}
		return scImageFileName;
	}
	


	
}
