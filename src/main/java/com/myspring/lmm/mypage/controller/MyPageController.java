package com.myspring.lmm.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.lmm.member.vo.MemberVO;

public interface MyPageController {
  
    public ModelAndView myDetailInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;

}