package com.xaver.service;

import java.util.Date;
import java.util.HashMap;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	VelocityEngine velocityEngine;
	
	@Value("${mail.enable}")
	private Boolean enable;
	
	@Value("${site.url}")
	private String url;
	
	private void send(MimeMessagePreparator preparator){
		if(enable){
			mailSender.send(preparator);
		}
	}
	
	@Async
	public void sendVerificationEmail(String emailAddress, String token){
			
		HashMap<String, Object> model = new HashMap<>();
		model.put("token", token);
		model.put("url", url);
		
		
		String contents = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/com/xaver/velocity/verifyemail.vm","UTF-8", model);
		
		
		MimeMessagePreparator preparator = new MimeMessagePreparator(){
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception{
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(emailAddress);
				message.setFrom(new InternetAddress("no-replay@babilo.de"));
				message.setSubject("Please verify your Email Address.");
				message.setSentDate(new Date());
				
				message.setText(contents, true);
			}
		};
		send(preparator);
	}
}
