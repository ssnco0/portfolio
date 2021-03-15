package com.myspring.lmm.mileage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;




public interface MileageController {
	
//	public ModelAndView listMileages(HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView SelectMilById(String cusid,int select,HttpServletRequest request, HttpServletResponse response)
//		throws Exception;
	ModelAndView useMileages(String cusid, HttpServletRequest request, HttpServletResponse response) throws Exception;
	ModelAndView stackMileages(String cusid, HttpServletRequest request, HttpServletResponse response) throws Exception;
}