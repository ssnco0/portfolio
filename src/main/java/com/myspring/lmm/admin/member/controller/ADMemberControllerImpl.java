package com.myspring.lmm.admin.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.lmm.admin.member.service.ADMemberService;
import com.myspring.lmm.admin.member.vo.ADMemberVO;
import com.myspring.lmm.admin.member.vo.ManagerVO;

@Controller("ADMemberController")
@RequestMapping("/admin")
//@EnableAspectJAutoProxy
public class ADMemberControllerImpl implements ADMemberController {
	private static final Logger logger = LoggerFactory.getLogger(ADMemberControllerImpl.class);
	@Autowired
	private ADMemberService memberService;
	@Autowired
	private ADMemberVO memberVO;
	@Autowired
	private ManagerVO managerVO;
	
	// 사용자 전체 조회
	@Override
	@RequestMapping(value = "/member/listMembers.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println("viewname: " + viewName);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;

	}

	// 사용자 아이디 검색
	@Override
	@RequestMapping(value = "/member/CusUserMembers.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView CusUserMembers(@ModelAttribute("cusid") String cusid, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println("viewname: " + viewName);
		System.out.println("select cusid:" + cusid);
		List membersList = memberService.CusMembers(cusid);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;

	}

	// 사용자 계정 삭제하기
	@Override
	@RequestMapping(value = "/member/removeCusUserById.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView removeCusUserById(@RequestParam("cusid") String cusid, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("cusid:"+cusid);
		memberService.removeCusUserById(cusid);
		ModelAndView mav = new ModelAndView("redirect:/admin/member/listMembers.do");
		return mav;
	}

	// 가맹점 전체 조회
	@Override
	@RequestMapping(value = "/member/StorelistMembers.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView StorelistMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println("viewname: " + viewName);
		List membersList = memberService.StorelistMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;

	}

	// 가맹점 아이디 검색
	@Override
	@RequestMapping(value = "/member/StoreMembers.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView StoreMembers(@ModelAttribute("stoid") String stoid, @RequestParam("select") int select,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println("viewname: " + viewName);
		System.out.println("stoid:" + stoid);
		System.out.println("select:" + select);
		List membersList = memberService.StoreMembers(stoid, select);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}

	// 가맹점 가입 승인하기
	@Override
	@RequestMapping(value = "/member/approve.do", method = RequestMethod.GET)
	public ModelAndView approve(@RequestParam("stoid") String stoid, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		memberService.approve(stoid);
		ModelAndView mav = new ModelAndView("redirect:/admin/member/StorelistMembers.do");
		return mav;
	}

	// 가맹점 계정 삭제하기
	@Override
	@RequestMapping(value = "/member/removeMember.do", method = RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("stoid") String stoid, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(stoid);
		ModelAndView mav = new ModelAndView("redirect:/admin/member/StorelistMembers.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/addMember.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") ADMemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/admin/member/listMembers.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/UserMileage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView addMember(@ModelAttribute("cusid") String cusid, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println("viewname: " + viewName);
		System.out.println("cusid: " + cusid);
		List membersList = memberService.SelectUserMileage(cusid);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}

	//로그인
	@Override
	@RequestMapping(value="/login.do" ,method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView login(@ModelAttribute("managerVO") ManagerVO managerVO,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ModelAndView mav = new ModelAndView();
		managerVO = memberService.login(managerVO);
		
		String AH = managerVO.getManAuthority();
		  String ok = "1";
		  String no = "0";
		if(managerVO!= null && managerVO.getManId()!=null  ) {
		    
			HttpSession session=request.getSession();
			session=request.getSession();
			session.setAttribute("isLogOn", true);
			session.setAttribute("managerInfo",managerVO);
				if(AH.equals(ok)) {
					mav.setViewName("redirect:/admin");
					
				}else if(AH.equals(no)) {
					mav.setViewName("redirect:/main.do");
				}
			
		}else{
			String message="아이디나  비밀번호가 틀립니다. 다시 로그인해주세요";
			mav.addObject("message", message);
			mav.setViewName("redirect:/main.do");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession();
		session.setAttribute("isLogOn", false);
		session.removeAttribute("managerInfo");
		session.invalidate();
		mav.setViewName("redirect:/main.do");
		
		return mav;
	}

	@RequestMapping(value = "/member/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(@RequestParam(value = "result", required = false) String result,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String viewName = getViewName(request);
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName(viewName);
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
