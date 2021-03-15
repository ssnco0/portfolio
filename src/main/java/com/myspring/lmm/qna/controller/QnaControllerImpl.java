package com.myspring.lmm.qna.controller;


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

import com.myspring.lmm.qna.service.QnaService;
import com.myspring.lmm.qna.vo.QnaVO;

import com.myspring.lmm.reply.service.ReplyService;
import com.myspring.lmm.reply.vo.ReplyVO;
import com.myspring.lmm.admin.member.vo.ManagerVO;
import com.myspring.lmm.member.vo.MemberVO;


@Controller("qnaController")
public class QnaControllerImpl implements QnaController{

	@Autowired
	private QnaService boardService;
	
	@Autowired
	private QnaVO articleVO;
	
	@Autowired
	private ReplyVO replyVO;
	
	@Autowired
	private ManagerVO managerVO;
	
	@Autowired
	private ReplyService replyService;

	
	
	
	@Override
	@RequestMapping(value= "/qna/listArticles.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List articlesList = boardService.listArticles();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList);
		return mav;
		
	}
	
	 //한 개 이미지 글쓰기
	@Override
	@RequestMapping(value="/qna/addNewArticle.do" ,method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, 
	HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		Map<String,Object> articleMap = new HashMap<String, Object>();
		Enumeration enu= multipartRequest.getParameterNames();
		while(enu.hasMoreElements()){
			String name =(String)enu.nextElement();
			
			String value = multipartRequest.getParameter(name);
			System.out.println("=========== : " + name + "+" + value);			
			articleMap.put(name,value);
			System.out.println(articleMap);
		}
		
		
		HttpSession session = multipartRequest.getSession();		
		MemberVO memberVO = (MemberVO) session.getAttribute("memberInfo");
		
		String id = memberVO.getCusId();
		
		articleMap.put("qnaWriter", id);		
		mav.addObject("articleMap", articleMap);
		String message;
		ResponseEntity resEnt=null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		try {
			int articleNO = boardService.addNewArticle(articleMap);
			
	
			message = "<script>";
			message += " alert('새글을 추가했습니다.');";
			message += " location.href='"+ multipartRequest.getContextPath()+"/qna/listArticles.do'; ";
			message +=" </script>";
		    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		
		}catch(Exception e) {
			
			
			message = " <script>";
			message +=" alert('오류가 발생했습니다. 다시 시도해 주세요');');";
			message +=" location.href='"+ multipartRequest.getContextPath()+"/qna/articleForm.do'; ";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	
	//한개의 이미지 보여주기
	@RequestMapping(value="/qna/viewArticle.do" , method = { RequestMethod.POST, RequestMethod.GET})
		public ModelAndView viewArticle(@RequestParam("articleNO") int qnaNo, 
				HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("memberInfo");		
		ManagerVO managerVO= (ManagerVO)session.getAttribute("managerInfo");
		
		mav.addObject("id",memberVO);		
		
		String viewName = (String)request.getAttribute("viewName");
		articleVO = boardService.viewArticle(qnaNo);	
		
		mav.setViewName(viewName);
		mav.addObject("article", articleVO);				
		
		//댓글조회
		mav.addObject("managerInfo",managerVO);
		
		List replysList = replyService.listArticles(qnaNo);	
		
		
		mav.addObject("reply", replysList);	
		
		
		return mav;
	//
		
		
		
	
	
	
	}
	

	
  //한 개 이미지 수정 기능
  @RequestMapping(value="/qna/modArticle.do" ,method = {RequestMethod.GET,RequestMethod.POST})
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
	   message += " alert('글을 수정했습니다.');";
	   message += " location.href='"+multipartRequest.getContextPath()+"/qna/viewArticle.do?articleNO="+articleNO+"';";
	   message +=" </script>";
       resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
   
    }catch(Exception e) {
      
      message = "<script>";
	  message += " alert('오류가 발생했습니다.다시 수정해주세요');";
	  message += " location.href='"+multipartRequest.getContextPath()+"/qna/viewArticle.do?articleNO="+articleNO+"';";
	  message +=" </script>";
      resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
    }
    return resEnt;
  }
  
  @Override
  @RequestMapping(value="/qna/removeArticle.do" ,method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity  removeArticle(@RequestParam("articleNO") int qnaNo,
                              HttpServletRequest request, HttpServletResponse response) throws Exception{
	response.setContentType("text/html; charset=UTF-8");
	String message;
	ResponseEntity resEnt=null;
	HttpHeaders responseHeaders = new HttpHeaders();
	responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	try {
		boardService.removeArticle(qnaNo);
		
		message = "<script>";
		message += " alert('글을 삭제했습니다.');";
		message += " location.href='"+request.getContextPath()+"/qna/listArticles.do';";
		message +=" </script>";
	    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	       
	}catch(Exception e) {
		message = "<script>";
		message += " alert('작업중 오류가 발생했습니다.다시 시도해 주세요.');";
		message += " location.href='"+request.getContextPath()+"/qna/listArticles.do';";
		message +=" </script>";
	    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	    System.out.println("QNANo : =============="+ qnaNo);
	    e.printStackTrace();
	}
	return resEnt;
  }  
  

	@RequestMapping(value = "/qna/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("memberInfo");
		String id = memberVO.getCusId();
		mav.addObject("cusId", id);
		mav.setViewName(viewName);
		return mav;
	}

	
	
}
