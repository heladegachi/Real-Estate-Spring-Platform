package tn.esprit.spring.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailServiceHela {
	  private JavaMailSender javaMailSender;

	    public EmailServiceHela(JavaMailSender javaMailSender) {
	        this.javaMailSender = javaMailSender;
	    }

	    public void sendMail(String toEmail, String subject, String message) {

	        SimpleMailMessage mailMessage = new SimpleMailMessage();

	        mailMessage.setTo(toEmail);
	        mailMessage.setSubject(subject);
	        mailMessage.setText(message);

	        mailMessage.setFrom("amir.akari@esprit.tn");

	        javaMailSender.send(mailMessage);
	    }
}
