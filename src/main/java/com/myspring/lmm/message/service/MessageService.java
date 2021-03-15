package com.myspring.lmm.message.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.message.vo.MessageVO;


public interface MessageService {
	
	 public int transMessage(MessageVO messageVO) throws DataAccessException;
	 public int removeMessage(int umNum) throws DataAccessException;
	 public List messageList(String cusId) throws DataAccessException;
	 public List stomessageList(String stoId) throws DataAccessException;
	 
	 
}
