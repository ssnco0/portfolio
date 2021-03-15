package com.myspring.lmm.store.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.lmm.member.vo.MemberVO;
import com.myspring.lmm.store.vo.StoreVO;

public interface StoreController {
    	public ModelAndView login(StoreVO storeVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
//   	public ModelAndView login(@RequestParam Map<String, String> loginMap, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity addStore(@ModelAttribute("storeVO") StoreVO storeVO,
            HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView form(@RequestParam(value="result", required=false) String result,
		HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity overlapped(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity overlappedPh(String phone, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity overlappedEm(String email, HttpServletRequest request, HttpServletResponse response) throws Exception;
	//찾기
	public String findid(HttpServletResponse response, @RequestParam("email") String email, Model md) throws Exception;
	public String findidform() throws Exception;
	public void findpw(@ModelAttribute StoreVO storeVO, HttpServletResponse response) throws Exception;
	public String findpwform() throws Exception;
	
	
	//테스트임
//	public ResponseEntity scUpload(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception;
//	private String upload(MultipartHttpServletRequest multipartRequest) throws Exception;
	ResponseEntity addScImg(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception;

	
	
	
}
