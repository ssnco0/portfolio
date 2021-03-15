package com.myspring.lmm.admin.mileage.controller;

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

import com.myspring.lmm.admin.mileage.service.ADMileageService;
import com.myspring.lmm.admin.mileage.vo.ADMileageVO;



@Controller("ADMileageController")
@RequestMapping("/admin")
public class ADMileageControllerImpl implements ADMileageController {
	
	@Autowired
	private ADMileageService mileageService;
	@Autowired
	private ADMileageVO mileageVo;

	@Override
	@RequestMapping(value = "/mileage/Mileage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView Mileage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println("viewname: " + viewName);
		List mileageList = mileageService.selectAllMileage();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("mileageList", mileageList);
		return mav;
	}
	
	//마일리지 적립 정보 아이디로 조회하기
	@Override
	@RequestMapping(value = "/mileage/SelectMilById.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView SelectMilById(@ModelAttribute("cusid") String cusid,@RequestParam("select") int select, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List mileageList = mileageService.SelectMilById(cusid,select);
		String viewname = null;
		if(select == 0) {
			viewname = "/admin/mileage/Mileage";
		}
		else {
			viewname = "/admin/mileage/UseMileage";
		}
		ModelAndView mav = new ModelAndView(viewname);
		mav.addObject("mileageList", mileageList);
		return mav;
	
	}
	
	//가맹점 마일리지 전체 조회
		@Override
		@RequestMapping(value = "/mileage/StoreMileage.do", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView SelectAllStoreMileage(HttpServletRequest request, HttpServletResponse response) throws Exception {
			List StoremileageList = mileageService.SelectAllStoreMileage();
			String viewname = getViewName(request);
			ModelAndView mav = new ModelAndView(viewname);
			mav.addObject("StoremileageList", StoremileageList);
			return mav;
		
		}
		
		//가맹점 마일리지 전체,가맹점이름,지역번호/select값 0,1,2
		@Override
		@RequestMapping(value = "/mileage/StoMileageById.do", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView StoMileageById(@ModelAttribute("search") String search,@RequestParam("select") int select,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("search con:"+search);
			response.setContentType("text/html; charset=UTF-8");
			List StoremileageList = mileageService.StoMileageById(search,select);
			String viewname = "/admin/mileage/StoreMileage";
			ModelAndView mav = new ModelAndView(viewname);
			mav.addObject("StoremileageList", StoremileageList);
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
