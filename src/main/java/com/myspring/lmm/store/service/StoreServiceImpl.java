package com.myspring.lmm.store.service;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lmm.store.dao.StoreDAO;
import com.myspring.lmm.store.vo.StoreVO;

@Service("storeService")
@Transactional(propagation = Propagation.REQUIRED)
public class StoreServiceImpl implements StoreService {
	@Autowired
	private StoreDAO storeDAO;
	
	
	@Override
	public StoreVO login(StoreVO storeVO) throws Exception{
		return storeDAO.login(storeVO);
	}
	
	@Override
	public void addStore(StoreVO storeVO) throws Exception{
		storeDAO.insertStore(storeVO);
	
	}

	@Override
	public String overlapped(String id) throws Exception{
		return storeDAO.selectOverlappedID(id);
	}
	@Override
	public String overlappedPh(String phone) throws Exception{
		return storeDAO.selectOverlappedPhone(phone);
	}
	@Override
	public String overlappedEm(String email) throws Exception{
		return storeDAO.selectOverlappedEmail(email);
	}
	
	
	// 아이디 찾기
	@Override
	public String findid(HttpServletResponse response, String email) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String stoId = storeDAO.findid(email);
		
		if (stoId == null) {
			out.println("<script>");
			out.println("alert('가입된 아이디가 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return stoId;
		}
	}
	
	//비밀번호 찾기 이메일발송
	@Override
	public void sendEmail(StoreVO storeVO, String div) throws Exception {
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; //네이버 이용시 smtp.naver.com
		String hostSMTPid = "yhr9983@gmail.com";
		String hostSMTPpwd = "Q9983123";

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "yhr9983@gmail.com";
		String fromName = "LMM";
		String subject = "";
		String msg = "";

		if(div.equals("findpw")) {
			subject = "LMM 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += storeVO.getStoId() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += storeVO.getStoPassword() + "</p></div>";
		}

		// 받는 사람 E-Mail 주소
		String mail = storeVO.getStoEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(465); //네이버 이용시 587

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}

	// 비밀번호 찾기
	@Override
	public void findpw(HttpServletResponse response, StoreVO storeVO) throws Exception {
	    	response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 임시 비밀번호 생성
		String pw = "";
		for (int i = 0; i < 12; i++) {
		pw += (char) ((Math.random() * 26) + 97);
		}
		storeVO.setStoPassword(pw);
			
		// 비밀번호 변경
		storeDAO.update_pw(storeVO);
			
		// 비밀번호 변경 메일 발송
		sendEmail(storeVO, "findpw");
				
		out.print("이메일로 임시 비밀번호를 발송하였습니다.");
		out.close();
				
	}
	//단일 이미지 추가하기
	@Override
	public int addScImg(Map scMap) throws Exception{
		return storeDAO.insertNewScImg(scMap);
	}


	
}
