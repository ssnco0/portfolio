package com.myspring.lmm.admin.mileage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


public interface ADMileageController {
	public ModelAndView Mileage(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView SelectMilById(String cusid,int select,HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	public ModelAndView SelectAllStoreMileage(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView StoMileageById(String search,int select, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}
