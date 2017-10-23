package com.xaver.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

		@Value("${mail.smtp.host}")
		private String host;
		
		@Value("${mail.smtp.port}")
		private Integer port;
		
		@Value("${mail.smtp.user}")
		private String user;
		
		@Value("${mail.smtp.pass}")
		private String pass;
	
		@Bean
		public JavaMailSender mailSender(){
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			
			
			mailSender.setHost(host);
			mailSender.setPort(port);
			mailSender.setUsername(user);
			mailSender.setPassword(pass);
			mailSender.setJavaMailProperties(getMailProperties());
			return mailSender;
		}
		
		 private Properties getMailProperties() {
		        Properties properties = new Properties();
		        properties.setProperty("mail.transport.protocol", "smtp");
		        properties.setProperty("mail.smtp.auth", "true");
		        properties.setProperty("mail.smtp.starttls.enable", "true");
		        properties.setProperty("mail.debug", "false");
		        return properties;
		}
}
