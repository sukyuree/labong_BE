package com.comealone.jeju.util.mail;

public class MailForm {
	public String getBaseMail(String content) {

		return "<!DOCTYPE html>" +
				"<html>" +
				"<head>" +
				"</head>" +
				"<body>" +
				" <div" +
				"	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 400px; height: 600px; border-top: 4px solid #02b875; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">" +
				"	<h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">" +
				"		<span style=\"font-size: 15px; margin: 0 0 10px 3px;\">라봉라봉</span><br />" +
				"		<span style=\"color: #02b875\">MP2022</span> 안내 메일입니다." +
				"	</h1>\n" +
				"	<p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">" +
				content +
				"	</p>" +
				"	<div style=\"border-top: 1px solid #DDD; padding: 5px;\"></div>" +
				" </div>" +
				"</body>" +
				"</html>";
	}

	public String getCertificationCodeMail(String code) {

		return "<!DOCTYPE html>" +
			"<html>" +
			"<head>" +
			"</head>" +
			"<body>" +
			" <div" +
			"	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 400px; height: 600px; border-top: 4px solid #ED8F20; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">" +
			"	<h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">" +
			"		<span style=\"font-size: 15px; margin: 0 0 10px 3px;\">라봉라봉</span><br />" +
			"		<span style=\"color: #F26B1D\">메일인증코드</span> 안내입니다." +
			"	</h1>\n" +
			"	<p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">" +
			"		안녕하세요.<br />" +
			"		라봉라봉 입니다.<br />" +
			"		아래 <b style=\"color: #F26B1D\">'인증 코드'</b> 를 통해 회원가입 절차를 진행해주시길 바랍니다.<br />" +
			"		감사합니다." +
			"	</p>" +
			"	<a style=\"color: #FFF; text-decoration: none; text-align: center;\"" +
			"	>" +
			"		<p" +
			"			style=\"display: inline-block; width: 210px; height: 45px; margin: 30px 5px 40px; background: #ED8F20; line-height: 45px; vertical-align: middle; font-size: 30px; font-weight:bold;\">" +
			"			" + code + "</p>" +
			"	</a>" +
			"	<div style=\"border-top: 1px solid #DDD; padding: 5px;\"></div>" +
			" </div>" +
			"</body>" +
			"</html>";
	}
}
