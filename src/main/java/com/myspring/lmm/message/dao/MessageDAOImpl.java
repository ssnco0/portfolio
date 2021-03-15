package com.myspring.lmm.message.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.lmm.message.vo.MessageVO;

@Repository("messageDAO")
public class MessageDAOImpl implements MessageDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllMessageList(String cusId) throws DataAccessException {
		List messageList = null;
		messageList = sqlSession.selectList("mapper.message.selectAllMessageList",cusId);
		return messageList;
	}
	@Override
	public List selectAllStoMessageList(String stoId) throws DataAccessException {
		List stomessageList = null;
		stomessageList = sqlSession.selectList("mapper.message.selectAllStoMessageList",stoId);
		return stomessageList;
	}
	
	
	@Override
	public int insertMessage(MessageVO messageVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.message.insertMessage", messageVO);
		return result;
	}

	@Override
	public int deleteMessage(int umNumId) throws DataAccessException {
		int result = sqlSession.delete("mapper.message.deleteMessage", umNumId);
		return result;
	}
	
	

}
