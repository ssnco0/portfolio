package com.myspring.lmm.cupon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.lmm.cupon.vo.CuponVO;
import com.myspring.lmm.member.vo.MemberVO;

public interface CuponController {

	public ModelAndView addCupon(@ModelAttribute("cuponVO") CuponVO cuponVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView removeCupon(@RequestParam("cupId") int cupId, HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView modCupon(@RequestParam("cupId") int cupId, HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView addCupon2(@ModelAttribute("info") CuponVO cuponVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listCupons2(CuponVO cuponVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
//	ModelAndView listCupons2(String stoId, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listCupons(String stoId, HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView stoCuponList(String stoId, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView cusCuponList(String cusId, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//Å×½º¤Ñ
	public ModelAndView listCupons4( HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}