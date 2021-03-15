package com.myspring.lmm.reply.controller;

import java.util.Enumeration;
import java.util.HashMap;
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

import com.myspring.lmm.admin.member.vo.ManagerVO;
import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.reply.service.ReplyService;
import com.myspring.lmm.reply.vo.ReplyVO;


@Controller("replyController")
@RequestMapping("/reply")
public class ReplyControllerImpl implements ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private ManagerVO managerVO;
	
	// 댓글 작성
	@RequestMapping(value = "/write", method = { RequestMethod.POST, RequestMethod.GET})
	public ModelAndView posttWirte(@RequestParam("reContents") String reContents,@RequestParam("qnaNo") int qnaNo,HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String viewName = "redirect:/qna/viewArticle.do?articleNO="+qnaNo;
		ModelAndView mav = new ModelAndView(viewName);
		HttpSession session=request.getSession();	
		session=request.getSession();
		
		ManagerVO managerVO= (ManagerVO)session.getAttribute("managerInfo");
		
		
		System.out.println("시도전================================================ " );
		
		try {
			String manId=managerVO.getManId();
			
			System.out.println("test:"+reContents);
			System.out.println("test2:"+qnaNo);
			System.out.println("test3:"+manId);
			Map<String,Object> replyMap = new HashMap<String, Object>();
			
			replyMap.put("reContents",reContents);
			replyMap.put("qnaNo",qnaNo);
			replyMap.put("reWriter",manId);
			
			replyService.addNewArticle(replyMap);
			System.out.println("시도 ===============================================" +replyMap);
			
		} 
//		catch (NullPointerException e) {
//			// TODO: handle exception			
//			mav.addObject("message", "관리자 계정으로 로그인해주세요.");		
//			mav.setViewName(viewName); 
//		}
//		
		 catch (Exception e) {
			 String message = "알수도 있는 오류가 발생했습니다.";
			 
				System.out.println("에러=============================================== " );
				mav.setViewName(viewName);
				mav.addObject("message", message);		
				 			
			}
		
		return mav;
			
	
	}
		
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}	

}
