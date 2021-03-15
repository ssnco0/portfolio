package com.myspring.lmm.message.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.lmm.message.vo.MessageVO;

public interface MessageController {
	public ModelAndView transMessage(@ModelAttribute("info") MessageVO messageVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeMessage(@RequestParam("umNum") int cupId, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listMessage(String cusid, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView stolistMessage(String stoid, HttpServletRequest request, HttpServletResponse response) throws Exception;

}