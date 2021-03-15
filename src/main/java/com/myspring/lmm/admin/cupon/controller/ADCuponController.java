package com.myspring.lmm.admin.cupon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


public interface ADCuponController {

	public ModelAndView SelectNoAppCupon(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView StoreCuponApp(String cupid, HttpServletRequest request, HttpServletResponse response) throws Exception;

 	public ModelAndView SearchCuponByCupQRNo(String search, int select, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public ModelAndView SearchUseCupon(String search, int select, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}
