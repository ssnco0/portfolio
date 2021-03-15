package com.myspring.lmm.cupon.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.lmm.cupon.service.CuponService;
import com.myspring.lmm.cupon.vo.CuponVO;
import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.store.vo.StoreVO;





@Controller("cuponController")
//@EnableAspectJAutoProxy
public class CuponControllerImpl   implements CuponController {
	private static final Logger logger = LoggerFactory.getLogger(CuponControllerImpl.class);
	@Autowired
	private CuponService cuponService;
	@Autowired
	private CuponVO cuponVO ;
	@Autowired
	private MemberVO memberVO ;
	@Autowired
	private StoreVO storeVO ;
		
	//쿠폰 리스트 조회-가맹점
	@Override
	@RequestMapping(value="/cupon/listCupons.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listCupons(@ModelAttribute("stoId") String stoId, HttpServletRequest request, HttpServletResponse response) throws Exception {

	    	String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		
		HttpSession session=request.getSession();
		session=request.getSession();
		
		storeVO=(StoreVO)session.getAttribute("storeInfo");
		String stoid=storeVO.getStoId();	
		List<CuponVO> cuponsList = cuponService.listCupons(stoid);
		
	
		mav.addObject("cuponsList", cuponsList);
		return mav;
	}
	//쿠폰 리스트 조회-사용자
	@Override
	@RequestMapping(value="/cupon/cusCuponList.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView cusCuponList(@ModelAttribute("cusId") String cusId, HttpServletRequest request, HttpServletResponse response) throws Exception {

	    	String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		
		HttpSession session=request.getSession();
		session=request.getSession();
		
		memberVO=(MemberVO)session.getAttribute("memberInfo");
		String cusid=memberVO.getCusId();	
		List<CuponVO> cuscuponList = cuponService.cuscuponList(cusid);
	
		mav.addObject("cuscuponList", cuscuponList);
		return mav;
		
	}
	
	//쿠폰선택
	@RequestMapping(value = "/cupon/SelectCus.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String SelectCus(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		return viewName;
	}
	
	//테스트용 - 사용자 리스트
	@Override
	@RequestMapping(value="/cupon/listCupons4.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listCupons4(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
			
		List<MemberVO> cuponsList4 = cuponService.listCupons4();
		
	
		
		mav.addObject("cuponsList4", cuponsList4);
		return mav;
	}
	
	
	
	
	
	
	@Override
	@RequestMapping(value="/cupon/listCupons2.do" ,method = RequestMethod.GET)
	public ModelAndView listCupons2(@ModelAttribute("cuponVO") CuponVO cuponVO, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		

		List cuponsList2 = cuponService.listCupons2(cuponVO);
		mav.addObject("cuponsList2", cuponsList2);
		return mav;
	}


	/* 2021-03-07 */
	@Override
	@RequestMapping(value="/cupon/addCupon.do" ,method = RequestMethod.POST)
	public ModelAndView addCupon(@ModelAttribute("cuponVO") CuponVO cuponVO,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session=request.getSession();
		session=request.getSession();
		storeVO=(StoreVO)session.getAttribute("storeInfo");
		String stoId=storeVO.getStoId();
		System.out.println("stoId:"+stoId);
		
		cuponVO.setStoId(stoId);
		
		int result = 0;
		result = cuponService.addCupon(cuponVO);
		ModelAndView mav = new ModelAndView("redirect:/cupon/listCupons.do");
		return mav;
		
	}
	
	
	@RequestMapping(value = "/cupon/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {

		String viewName = (String)request.getAttribute("viewName");
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
