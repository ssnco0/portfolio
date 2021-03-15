package com.myspring.lmm.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.mypage.service.MyPageService;




@Controller("myPageController")
@RequestMapping(value="/mypage")
public class MyPageControllerImpl implements MyPageController{
	@Autowired
	private MyPageService myPageService;
	
	@Autowired
	private MemberVO memberVO;

	//����������
	@Override
	@RequestMapping(value="/myDetailInfo.do" ,method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView myDetailInfo( HttpServletRequest request, HttpServletResponse response)  throws Exception  {
		
		HttpSession session=request.getSession();
		session=request.getSession();
		session.setAttribute("side_menu", "cususer"); //���������� ���̵� �޴��� �����Ѵ�.
		
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		memberVO=(MemberVO)session.getAttribute("memberInfo");
		String cusId=memberVO.getCusId();
		return mav;
	}

	
	// ���� ��
	@RequestMapping(value = "/modCusInfo", method = RequestMethod.GET)
	public String modifyCusInfo() throws Exception {
	    return "/mypage/modifyCusInfo";
	}

	// ���� ���
	@RequestMapping(value = "/modifyCusInfo", method = RequestMethod.POST)
	public String memberUpdate(MemberVO memberVO, HttpSession session) throws Exception {

	    myPageService.memberUpdate(memberVO);
		session.invalidate();
		return "redirect:/main.do";
	}
	
	
}