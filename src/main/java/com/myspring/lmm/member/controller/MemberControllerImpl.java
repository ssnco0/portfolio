package com.myspring.lmm.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.ModelAndView;

import com.myspring.lmm.member.service.MemberService;
import com.myspring.lmm.member.vo.MemberVO;






@Controller("memberController")
@RequestMapping("/member")

public class MemberControllerImpl   implements MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO ;
	
	//로그인
	@Override
	@RequestMapping(value="/login.do" ,method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, String> loginMap,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
	    
		ModelAndView mav = new ModelAndView();
		 memberVO=memberService.login(loginMap);
		if(memberVO!= null && memberVO.getCusId()!=null){
			HttpSession session=request.getSession();
			session=request.getSession();
			session.setAttribute("isLogOn", true);
			session.setAttribute("memberInfo",memberVO);
			mav.setViewName("redirect:/main.do");
			
		
		    
		}else{
			String message="아이디나  비밀번호가 틀립니다. 다시 로그인해주세요";
			mav.addObject("message", message);
			mav.setViewName("/member/loginForm");
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
		session.removeAttribute("memberInfo");
		session.invalidate();
		mav.setViewName("redirect:/main.do");
		
		return mav;
	}
	
	//회원등록
	@Override
	@RequestMapping(value="/addMember.do" ,method = RequestMethod.POST)
	public ResponseEntity addMember(@ModelAttribute("memberVO") MemberVO memberVO,
			                HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		try {
		    memberService.addMember(memberVO);
		    message  = "<script>";
		    message +=" alert('회원 가입이 완료되었습니다.로그인창으로 이동합니다.');";
		    message += " location.href='"+request.getContextPath()+"/member/loginForm.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/member/memberForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
	
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
	//폼 -로그인/회원가입
	@RequestMapping(value = { "/loginForm.do", "/memberForm.do" }, method =  RequestMethod.GET)
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
		String result = memberService.overlapped(id);
		resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
	//휴대폰 검사
	@Override
	@RequestMapping(value="/overlappedPh.do" ,method = RequestMethod.POST)
	public ResponseEntity overlappedPh(@RequestParam("phone") String phone,HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
		String result = memberService.overlappedPh(phone);
		resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
	//이메일 검사
	@Override
	@RequestMapping(value="/overlappedEm.do" ,method = RequestMethod.POST)
	public ResponseEntity overlappedEm(@RequestParam("email") String email,HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
		String result = memberService.overlappedPh(email);
		resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
	// 아이디 찾기 폼
	@RequestMapping(value = "/findidform.do")
	public String findidform() throws Exception {
		return "/member/findidform";
	}
	// 아이디 찾기
	@RequestMapping(value = "/findid.do", method = RequestMethod.POST)
	public String findid(HttpServletResponse response, @RequestParam("email") String email, Model md) throws Exception{
		md.addAttribute("cusId", memberService.findid(response, email));
		return "/member/findid";
	}

	// 비밀번호 찾기 폼
	@RequestMapping(value = "/findpwfom.do")
	public String findpwform() throws Exception {
			return "/member/findpwform";
	}
	
		
	// 비밀번호 찾기
	@RequestMapping(value = "/findpw.do", method = RequestMethod.POST)
	public void findpw(@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws Exception{
	    memberService.findpw(response, memberVO);
	}
		
	// 회원 인증
//	@RequestMapping(value = "/member/approval_member.do", method = RequestMethod.POST)
//	public void approval_member(@ModelAttribute MemberVO vo, HttpServletResponse response) throws Exception{
//	    memberService.approval_member(vo, response);
//	}
	
	
	

}
