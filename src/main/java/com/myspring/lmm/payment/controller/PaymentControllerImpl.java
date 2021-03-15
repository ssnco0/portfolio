package com.myspring.lmm.payment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.payment.service.PaymentService;
import com.myspring.lmm.payment.vo.PaySaveVO;
import com.myspring.lmm.payment.vo.PaymentVO;
import com.myspring.lmm.store.vo.StoreVO;

@Controller("paymentController")
//@EnableAspectJAutoProxy
public class PaymentControllerImpl   implements PaymentController {
	@Autowired
	private PaymentService paymentService;
	@Autowired
	PaymentVO paymentVO;
	StoreVO storeVO;
	MemberVO memberVO;
	PaySaveVO paysaveVO;
	

	/*
	 * payment 결제 정보 저장 mileage 테이블 적립 정보 저장(사용한 경우) cususer 테이블 총마일리지 컬럼 변경 쿠폰 테이블
	 * 사용 처리(사용한 경우)
	 */
	@Override
	@RequestMapping(value="/payment/PaymentProcess.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView SavePayment(@ModelAttribute("paysaveVO") PaySaveVO paysaveVO,HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
	
		int savePayment = paymentService.addPayment(paysaveVO);
		int saveMileage = paymentService.saveMileage(paysaveVO);
		int saveTotMil = paymentService.saveTotMil(paysaveVO);
		
		if(paysaveVO.getCupId() != 0) {
			int cuponTypeChange = paymentService.cuponTypeChange(paysaveVO);
		}
		
		String viewName = "redirect:/payment/payment.do";
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}
	
	
	@Override
	@RequestMapping(value="/payment/listPayments.do" ,method = RequestMethod.GET)
	public ModelAndView listPayments(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		
		HttpSession session=request.getSession();	
		storeVO=(StoreVO)session.getAttribute("storeInfo");
		String stoId=storeVO.getStoId();
		
		List paymentsList = paymentService.listPayments(stoId);
		ModelAndView mav = new ModelAndView(viewName);
		
		System.out.println("viewname:"+viewName);
		mav.addObject("paymentsList", paymentsList);
		return mav;
	}
	@Override
	@RequestMapping(value="/payment/payment.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView payment(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		System.out.println(viewName);
		
		HttpSession session=request.getSession();	
		storeVO=(StoreVO)session.getAttribute("storeInfo");
		String stoId=storeVO.getStoId();
		int payNum = paymentService.selectLastPayNum();

		response.setContentType("text/html;charset=UTF-8");
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("stoId",stoId);
		mav.addObject("payNum",payNum);
		System.out.println("lastpaynum"+payNum);
		return mav;
	}
	
	@RequestMapping(value = "/payment/SelectCusPhone.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String SelectCusPhone(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		return viewName;
	}
	
	@Override
	@RequestMapping(value="payment/selectCusid.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView selectCusid(@RequestParam("SelectCusIdChild") String SelectCusIdChild, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = "/payment/SelectCusPhone";
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession();	
		storeVO=(StoreVO)session.getAttribute("storeInfo");
		String stoId=storeVO.getStoId();
		System.out.println("session stoid:" + stoId);

		ModelAndView mav = new ModelAndView(viewName);
		memberVO = paymentService.selectCusid(SelectCusIdChild);
		List cuponList = paymentService.SelectcupNumByCusId(SelectCusIdChild);
		mav.addObject("member", memberVO);
		mav.addObject("cuponList",cuponList);
		mav.addObject("stoId",stoId);
		return mav;
	}

	@Override
	@RequestMapping(value="/payment/refundProcess.do" ,method = RequestMethod.GET)
	public ModelAndView refundProcess(@RequestParam("payNum") int payNum, @RequestParam("cupId") int cupId,
										@RequestParam("cusId") String cusId, 
										@RequestParam("payUseMil") int payUseMil,
										@RequestParam("milStack") int milStack,
									  HttpServletRequest request, 
									  HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("payNum:"+payNum);
		System.out.println("cupId:"+cupId);
		System.out.println("cusId:"+cusId);
		System.out.println("payUseMil:"+payUseMil);
		System.out.println("milStack:"+milStack);

		paymentVO.setCusId(cusId);
		paymentVO.setPayUseMil(payUseMil);
		paymentVO.setMilStack(milStack);
		
		System.out.println("con cusId:"+paymentVO.getCusId());
		System.out.println("con milStack:"+paymentVO.getMilStack());
		System.out.println("con payUseMil:"+paymentVO.getPayUseMil());
		
		paymentService.refundCusTotMil(paymentVO);
		paymentService.removePayment(payNum);
		paymentService.removeMileage(payNum);
		if(cupId != 0) {
			paymentService.refundCuponTypeChange(cupId);
		}


		ModelAndView mav = new ModelAndView("redirect:/payment/listPayments.do");
		return mav;
	}
	
	



	@RequestMapping(value = "/payment/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
							  @RequestParam(value= "action", required=false) String action,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		HttpSession session = request.getSession();
		session.setAttribute("action", action);  
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
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
