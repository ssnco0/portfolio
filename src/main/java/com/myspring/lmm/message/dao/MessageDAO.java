package com.myspring.lmm.message.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.lmm.message.vo.MessageVO;


public interface MessageDAO {
//	 public List selectAllMessageList() throws DataAccessException;
	 public int insertMessage(MessageVO messageVO) throws DataAccessException ;
	 public int deleteMessage(int umNum) throws DataAccessException;
	 public List selectAllMessageList(String cusId) throws DataAccessException;
	 public List selectAllStoMessageList(String stoId) throws DataAccessException;

}
