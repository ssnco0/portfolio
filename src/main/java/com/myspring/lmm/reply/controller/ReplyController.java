package com.myspring.lmm.reply.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.lmm.reply.vo.ReplyVO;


public interface ReplyController {

	public ModelAndView posttWirte(@RequestParam("reContents") String reContents,@RequestParam("qnaNo") int qnaNo,HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
}
