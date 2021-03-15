package com.myspring.lmm.mystopage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.mystopage.service.MyStoreService;
import com.myspring.lmm.store.vo.StoreVO;




@Controller("myStoreController")
@RequestMapping(value="/mypage")
public class MyStoreControllerImpl implements MyStoreController{
	@Autowired
	private MyStoreService myStoreService;
	
	@Autowired
	private StoreVO storeVO;
	
	//마이페이지
	@Override
	@RequestMapping(value="/myStorePage.do" ,method = RequestMethod.GET)
	public ModelAndView myStorePage( HttpServletRequest request, HttpServletResponse response)  throws Exception  {
		
		HttpSession session=request.getSession();
		session=request.getSession();
		session.setAttribute("side_menu", "store"); //마이페이지 사이드 메뉴로 설정한다.
		
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		storeVO=(StoreVO)session.getAttribute("storeInfo");
		String stoId=storeVO.getStoId();
		return mav;
	}
	// 수정 폼
	@RequestMapping(value = "/modStoInfo", method = RequestMethod.GET)
	public String modifyCusInfo() throws Exception {
		return "/mypage/modifyStoInfo";
	}

	// 수정 기능
	@RequestMapping(value = "/modifyStoInfo", method = RequestMethod.POST)
	public String storeUpdate(StoreVO storeVO, HttpSession session) throws Exception {

	    	myStoreService.storeUpdate(storeVO);
		session.invalidate();
		return "redirect:/main.do";
	}
	

}