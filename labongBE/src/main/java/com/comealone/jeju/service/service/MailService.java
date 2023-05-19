package com.comealone.jeju.service.service;

import com.comealone.jeju.util.mail.MailForm;
import lombok.RequiredArgsConstructor;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MailService {
	private final JavaMailSender javaMailSender;

	public void sendSignUpCertificationMail(String email, String code) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

		MailForm mailForm = new MailForm();
		String mailContent = mailForm.getCertificationCodeMail(code);

		helper.setTo(email); //받는사람
		helper.setSubject("[라봉라봉] 반갑다봉~ 회원가입 이메일 인증코드다봉~"); //메일제목
		helper.setText(mailContent, true); //true넣을경우 html

		javaMailSender.send(mimeMessage);
	}
}
