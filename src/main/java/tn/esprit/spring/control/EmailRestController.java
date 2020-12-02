package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.EmailService;

@RestController
public class EmailRestController {
	
	 @Autowired
	    private EmailService emailService;
	// http://localhost:8081/SpringMVC/servlet/sendmail
	    @GetMapping(value = "/sendmail")
	    public String sendmail() {
	  /*  if (reclamation.getObjet().toString().){
	    		emailService.sendMail("amir.akari@esprit.tn", "Reponse à votre probléme", "votre probléme sera résollus en 24h et pour plus d'informations contacter le responsable de service Akari Amir sur le numéro 21505435");
	    }*/
	    	
	    	
	    		
	    				emailService.sendMail();
	    		
	    	
	    		
	        return "emailsent";
	    }}
