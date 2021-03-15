package com.myspring.lmm.admin.cupon.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.lmm.admin.cupon.service.ADCuponService;
import com.myspring.lmm.admin.cupon.vo.ADCuponVO;
import com.myspring.lmm.admin.mileage.service.ADMileageService;
import com.myspring.lmm.admin.mileage.vo.ADMileageVO;



@Controller("ADcuponController")
@RequestMapping("/admin")
public class ADCuponControllerImpl implements ADCuponController {
	
	@Autowired
	private ADCuponService cuponService;
	@Autowired
	private ADCuponVO cuponVo;

	// 비승인 쿠폰 전체 조회
	@Override
	@RequestMapping(value = "/cupon/SelectNoAppCupon.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView SelectNoAppCupon(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println("viewname: " + viewName);
		List cuponList = cuponService.SelectNoAppCupon();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("cuponList", cuponList);
		return mav;
	}	
	
	// 비승인 쿠폰 승인으로 변경 0 -> 1
		@Override
		@RequestMapping(value = "/cupon/CuponApp.do",  method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView StoreCuponApp(@RequestParam("cupid") String cupid, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("utf-8");
			cuponService.StoreCuponApp(cupid);
			ModelAndView mav = new ModelAndView("redirect:/admin/cupon/SelectNoAppCupon.do");
			return mav;
		}
		
		// 전체 select = 0 , 비승인 select = 1 , 승인 select = 2 쿠폰 번호로 조회
		@Override
		@RequestMapping(value = "/cupon/SearchCuponByCupQRNo.do", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView SearchCuponByCupQRNo(@ModelAttribute("search") String search, @RequestParam("select") int select,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			String viewName = "/admin/cupon/SelectNoAppCupon";
			System.out.println("viewname: " + viewName);
			System.out.println("search:" + search);
			System.out.println("select:" + select);
			List cuponList = cuponService.SearchCuponByCupQRNo(search, select);
			ModelAndView mav = new ModelAndView(viewName);
			mav.addObject("cuponList", cuponList);
			return mav;
		}	
		
		// 승인 받은 쿠폰중 사용,비사용 조회 비사용 select = 0  사용 select = 1
		@Override
		@RequestMapping(value = "/cupon/SearchUseCupon.do", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView SearchUseCupon(@RequestParam(value="search", required =false, defaultValue="0") String search, @RequestParam(value="select", required =false, defaultValue="0") int select,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			String viewName = "/admin/cupon/SearchUseCupon";
			System.out.println("viewname: " + viewName);
			System.out.println("search:" + search);
			System.out.println("select:" + select);
			List cuponList = cuponService.SearchUseCupon(search, select);
			ModelAndView mav = new ModelAndView(viewName);
			mav.addObject("cuponList", cuponList);
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
