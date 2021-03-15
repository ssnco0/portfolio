package com.myspring.lmm.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.lmm.member.vo.MemberVO;


public interface MemberController {
	
	 public ModelAndView login(@RequestParam Map<String, String> loginMap, HttpServletRequest request, HttpServletResponse response) throws Exception;
	 public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;	
	    public ResponseEntity addMember(@ModelAttribute("memberVO") MemberVO memberVO,
	            HttpServletRequest request, HttpServletResponse response) throws Exception;
	    public ModelAndView form(@RequestParam(value="result", required=false) String result,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	    public ResponseEntity overlapped(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	    public ResponseEntity overlappedPh(String phone,HttpServletRequest request, HttpServletResponse response) throws Exception;
	    public ResponseEntity overlappedEm(String email, HttpServletRequest request, HttpServletResponse response) throws Exception;
	    //Ã£±â
	    public String findid(HttpServletResponse response, @RequestParam("email") String email, Model md) throws Exception;
	    public String findidform() throws Exception;
	    public void findpw(@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws Exception;
	    public String findpwform() throws Exception;
	
}