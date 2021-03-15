package com.myspring.lmm.admin.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.lmm.admin.member.vo.ADMemberVO;
import com.myspring.lmm.admin.member.vo.ManagerVO;

public interface ADMemberController {
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addMember(@ModelAttribute("info") ADMemberVO memberVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView StoreMembers(@ModelAttribute("stoid") String stoid,@RequestParam("select") int select,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addMember(@ModelAttribute("cusid") String cusid,
            HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView StorelistMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView CusUserMembers(String stoid, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
	public ModelAndView approve(String stoid, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeCusUserById(String cusid, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
//	public ModelAndView login(Map<String, String> loginMap, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView login(ManagerVO managerVO, HttpServletRequest request, HttpServletResponse response) throws Exception;

}