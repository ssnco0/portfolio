
package com.myspring.lmm.mystopage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

public interface MyStoreController {

  public ModelAndView myStorePage( HttpServletRequest request, HttpServletResponse response)  throws Exception;

 
}
