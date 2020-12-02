package tn.esprit.spring.control;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.EmailVisiteService;

@RestController
public class EmailVisiteRestController {
	
	 @Autowired
	    private EmailVisiteService emailService;
	// http://localhost:8081/SpringMVC/servlet/sendmail
	    @GetMapping(value = "/sendmailvisite")
	    public String sendmail() {
	 
	        emailService.sendMail("chaima.mezri@esprit.tn", "Test Subject", "Test mail");

	        return "emailsent";
	    }}




