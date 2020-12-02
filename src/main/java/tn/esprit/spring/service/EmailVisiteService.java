package tn.esprit.spring.service;



import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Service
public class EmailVisiteService {
	  private JavaMailSender javaMailSender;

	    public EmailVisiteService(JavaMailSender javaMailSender) {
	        this.javaMailSender = javaMailSender;
	    }

	    public void sendMail(String toEmail, String subject, String message) {

	        SimpleMailMessage mailMessage = new SimpleMailMessage();

	        mailMessage.setTo(toEmail);
	        mailMessage.setSubject(subject);
	        mailMessage.setText(message);

	        mailMessage.setFrom("chaima.mezri@esprit.tn");
	        
	        try {
	        	javaMailSender.send(mailMessage);
	        } catch(Exception e) {
	        	e.printStackTrace();
	        }
	        //javaMailSender.send(mailMessage);
	    }
	    
	   
}


