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
	
	
	// ���̵� ã��
	@Override
	public String findid(HttpServletResponse response, String email) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String stoId = storeDAO.findid(email);
		
		if (stoId == null) {
			out.println("<script>");
			out.println("alert('���Ե� ���̵� �����ϴ�.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return stoId;
		}
	}
	
	//��й�ȣ ã�� �̸��Ϲ߼�
	@Override
	public void sendEmail(StoreVO storeVO, String div) throws Exception {
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
			subject = "LMM �ӽ� ��й�ȣ �Դϴ�.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += storeVO.getStoId() + "���� �ӽ� ��й�ȣ �Դϴ�. ��й�ȣ�� �����Ͽ� ����ϼ���.</h3>";
			msg += "<p>�ӽ� ��й�ȣ : ";
			msg += storeVO.getStoPassword() + "</p></div>";
		}

		// �޴� ��� E-Mail �ּ�
		String mail = storeVO.getStoEmail();
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
	public void findpw(HttpServletResponse response, StoreVO storeVO) throws Exception {
	    	response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// �ӽ� ��й�ȣ ����
		String pw = "";
		for (int i = 0; i < 12; i++) {
		pw += (char) ((Math.random() * 26) + 97);
		}
		storeVO.setStoPassword(pw);
			
		// ��й�ȣ ����
		storeDAO.update_pw(storeVO);
			
		// ��й�ȣ ���� ���� �߼�
		sendEmail(storeVO, "findpw");
				
		out.print("�̸��Ϸ� �ӽ� ��й�ȣ�� �߼��Ͽ����ϴ�.");
		out.close();
				
	}
	//���� �̹��� �߰��ϱ�
	@Override
	public int addScImg(Map scMap) throws Exception{
		return storeDAO.insertNewScImg(scMap);
	}


	
}
