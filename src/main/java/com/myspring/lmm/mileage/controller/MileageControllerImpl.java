package com.myspring.lmm.mileage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.mileage.service.MileageService;
import com.myspring.lmm.mileage.vo.MileageVO;
import com.myspring.lmm.payment.vo.PaymentVO;




@Controller("mileageController")
@RequestMapping("/mileage")
public class MileageControllerImpl   implements MileageController {
	@Autowired
	private MileageService mileageService;
	@Autowired
	MileageVO mileageVO;
	@Autowired
	MemberVO memberVO;
	@Autowired
	PaymentVO paymentVO;
	
	@Override
	@RequestMapping(value = "/stackMileages.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView stackMileages(@ModelAttribute("cusid") String cusid, HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
	
	    	HttpSession session=request.getSession();
	    	memberVO=(MemberVO)session.getAttribute("memberInfo");
	    	String cusId=memberVO.getCusId();
	    	List stackMil = mileageService.stackMileages(cusId);
		
		mav.addObject("stackMil", stackMil);
		return mav;
	}

	
	@Override
	@RequestMapping(value = "/useMileages.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView useMileages(@ModelAttribute("cusid") String cusid,HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
	
	    	HttpSession session=request.getSession();
	    	memberVO=(MemberVO)session.getAttribute("memberInfo");
	       	String cusId=memberVO.getCusId();
	    	List useMil = mileageService.useMileages(cusId);
	    	

		mav.addObject("useMil", useMil);
		return mav;
	}


	
//	@Override
//	@RequestMapping(value = "/listMileages.do", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView listMileages(@ModelAttribute("cusid") String cusid, HttpServletRequest request, HttpServletResponse response) throws Exception {
//	    	String viewName = getViewName(request);
//		ModelAndView mav = new ModelAndView(viewName);
//	
//	    	HttpSession session=request.getSession();
//	    	memberVO=(MemberVO)session.getAttribute("memberInfo");
//	    	String cusId=memberVO.getCusId();
//	    	List milList = mileageService.listMileages(cusId);
//		
//		mav.addObject("milList", milList);
//		return mav;
//	}

	

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
