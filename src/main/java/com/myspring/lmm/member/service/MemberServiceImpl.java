package com.myspring.lmm.member.service;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lmm.member.dao.MemberDAO;
import com.myspring.lmm.member.vo.MemberVO;



@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberVO login(Map  loginMap) throws Exception{
		return memberDAO.login(loginMap);
	}
	@Override
	public void addMember(MemberVO memberVO) throws Exception{
		int qr = 0;
		for (int i = 0; i < 12; i++) {
		qr += (int) ((Math.random() * 9999) + 9999);
		}
		memberVO.setCusQrNo(qr);
		memberDAO.insertMember(memberVO);

	}
	
	@Override
	public String overlapped(String id) throws Exception{
		return memberDAO.selectOverlappedID(id);
	}
	
	@Override
	public String overlappedPh(String phone) throws Exception{
		return memberDAO.selectOverlappedPhone(phone);
	}
	@Override
	public String overlappedEm(String email) throws Exception{
		return memberDAO.selectOverlappedPhone(email);
	}
	// ���̵� ã��
	@Override
	public String findid(HttpServletResponse response, String email) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String cusId = memberDAO.findid(email);
		
		if (cusId == null) {
			out.println("<script>");
			out.println("alert('���Ե� ���̵� �����ϴ�.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return cusId;
		}
	}
	
	//��й�ȣ ã�� �̸��Ϲ߼�
	@Override
	public void sendEmail(MemberVO memberVO, String div) throws Exception {
		// Mail Server ����
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; //���̹� �̿�� smtp.naver.com
		String hostSMTPid = "yhr9983@gmail.com";
		String hostSMTPpwd = "Q9983123";

		// ������ ��� EMail, ����, ����
		String fromEmail = "yhr9983@gmail.com";
		String fromName = "LMM";
		String subject = "";
		String msg = "";

		if(div.equals("findpw")) {
			subject = "�������� �ӽ� ��й�ȣ �Դϴ�.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += memberVO.getCusId() + "���� �ӽ� ��й�ȣ �Դϴ�. ��й�ȣ�� �����Ͽ� ����ϼ���.</h3>";
			msg += "<p>�ӽ� ��й�ȣ : ";
			msg += memberVO.getCusPassword() + "</p></div>";
		}

		// �޴� ��� E-Mail �ּ�
		String mail = memberVO.getCusEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(465); //���̹� �̿�� 587

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("���Ϲ߼� ���� : " + e);
		}
	}

	// ��й�ȣ ã��
	@Override
	public void findpw(HttpServletResponse response, MemberVO memberVO) throws Exception {
	    	response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// �ӽ� ��й�ȣ ����
		String pw = "";
		for (int i = 0; i < 12; i++) {
		pw += (char) ((Math.random() * 26) + 97);
		}
		memberVO.setCusPassword(pw);
			
		// ��й�ȣ ����
		memberDAO.update_pw(memberVO);
			
		// ��й�ȣ ���� ���� �߼�
		sendEmail(memberVO, "findpw");
				
		out.print("�̸��Ϸ� �ӽ� ��й�ȣ�� �߼��Ͽ����ϴ�.");
		out.close();
				
	}
		
	
	
	
}

	
	

