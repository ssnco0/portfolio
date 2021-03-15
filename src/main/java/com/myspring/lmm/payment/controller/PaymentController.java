package com.myspring.lmm.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.payment.vo.PaySaveVO;
import com.myspring.lmm.payment.vo.PaymentVO;

public interface PaymentController {

	public ModelAndView listPayments(@ModelAttribute("info") HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	ModelAndView refundProcess(@RequestParam("payNum") int payNum, @RequestParam("cupId") int cupId, @RequestParam("cusId") String cusId,
								@RequestParam("payUseMil") int payUseMil,@RequestParam("milStack") int milStack,
			  HttpServletRequest request, 
			  HttpServletResponse response) throws Exception;

	public ModelAndView payment(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView selectCusid(String SelectCusIdChild, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	ModelAndView SavePayment(PaySaveVO paysave, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}