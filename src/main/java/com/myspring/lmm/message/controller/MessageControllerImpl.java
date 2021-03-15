package com.myspring.lmm.message.controller;

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

import com.myspring.lmm.admin.member.vo.ManagerVO;
import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.message.service.MessageService;
import com.myspring.lmm.message.vo.MessageVO;
import com.myspring.lmm.message.vo.StoMessageVO;
import com.myspring.lmm.store.vo.StoreVO;


@Controller("messageController")
//@RequestMapping("/message")
//@EnableAspectJAutoProxy
public class MessageControllerImpl   implements MessageController {
	private static final Logger logger = LoggerFactory.getLogger(MessageControllerImpl.class);
	@Autowired
	private MessageService messageService;
	@Autowired
	private MessageVO messageVO ;
	@Autowired
	private MemberVO memberVO;
	@Autowired
	private StoreVO storeVO;
	
	
	//쪽지 리스트 - 사용자
	@Override
	@RequestMapping(value="/message/listMessage.do" ,method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listMessage(@ModelAttribute("cusid") String cusid, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	    String viewName = (String)request.getAttribute("viewName");
	    ModelAndView mav = new ModelAndView(viewName);
	    
	    HttpSession session=request.getSession();
	    	memberVO=(MemberVO)session.getAttribute("memberInfo");
	    	String cusId=memberVO.getCusId();

		List<MessageVO> messageList = messageService.messageList(cusId);

		mav.addObject("messageList", messageList);
		return mav;
	}
	
	//쪽지 리스트 - 가맹점
	@Override
	@RequestMapping(value="/message/stolistMessage.do" ,method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView stolistMessage(@ModelAttribute("stoid") String stoid, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	    String viewName = (String)request.getAttribute("viewName");
	    ModelAndView mav = new ModelAndView(viewName);
	    
	    HttpSession session=request.getSession();
	    	storeVO=(StoreVO)session.getAttribute("storeInfo");
	    	String stoId=storeVO.getStoId();

		List<StoMessageVO> stomessageList = messageService.stomessageList(stoId);

		mav.addObject("stomessageList", stomessageList);
		return mav;
	}
	
	/*
	 * //쪽지 리스트 - 관리자
	 * 
	 * @Override
	 * 
	 * @RequestMapping(value="/message/managerMessage.do" ,method =
	 * {RequestMethod.GET, RequestMethod.POST}) public ModelAndView managerMessage(
	 * HttpServletRequest request, HttpServletResponse response) throws Exception {
	 * 
	 * String viewName = (String)request.getAttribute("viewName"); ModelAndView mav
	 * = new ModelAndView(viewName);
	 * 
	 * HttpSession session=request.getSession();
	 * storeVO=(ManagerVO)session.getAttribute("managerInfo"); String
	 * stoId=storeVO.getStoId();
	 * 
	 * List<StoMessageVO> stomessageList = messageService.stomessageList(stoId);
	 * 
	 * mav.addObject("stomessageList", stomessageList); return mav; }
	 */
	
	
	
	@Override
	@RequestMapping(value="/message/transMessage.do" ,method = RequestMethod.POST)
	public ModelAndView transMessage(@ModelAttribute("message") MessageVO message,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int result = 0;
		result = messageService.transMessage(message);
		ModelAndView mav = new ModelAndView("redirect:/message/stolistMessage.do");
		return mav;
	}
		
	@Override
	@RequestMapping(value="/message/removeMessage.do" ,method = RequestMethod.GET)
	public ModelAndView removeMessage(@RequestParam("umNum") int umNum, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		messageService.removeMessage(umNum);
		ModelAndView mav = new ModelAndView("redirect:/message/listMessage.do");
		return mav;
	}
	
	
	
	@RequestMapping(value = "/message/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
//		String viewName = getViewName(request);
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
