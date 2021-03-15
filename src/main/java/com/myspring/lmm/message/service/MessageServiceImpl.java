package com.myspring.lmm.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lmm.message.dao.MessageDAO;
import com.myspring.lmm.message.vo.MessageVO;



@Service("messageService")
@Transactional(propagation = Propagation.REQUIRED)
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDAO messageDAO;

	@Override
	public List messageList(String cusId) throws DataAccessException {
		List messageList = null;
		messageList = messageDAO.selectAllMessageList(cusId);
		return messageList;
	}
	@Override
	public List stomessageList(String stoId) throws DataAccessException {
		List stomessageList = null;
		stomessageList = messageDAO.selectAllStoMessageList(stoId);
		return stomessageList;
	}
	
	@Override
	public int transMessage(MessageVO message) throws DataAccessException {
		return messageDAO.insertMessage(message);
	}
	
	@Override
	public int removeMessage(int umNum) throws DataAccessException {
		return messageDAO.deleteMessage(umNum);
	}
	
	
	
	

	

}