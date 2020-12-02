package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.ReclamationRepository;
@Service
public class EmailService {
	  private JavaMailSender javaMailSender;
	  Reclamation reclamation;
	  @Autowired
	  ReclamationRepository reclamationRepository;
	    public EmailService(JavaMailSender javaMailSender) {
	        this.javaMailSender = javaMailSender;
	    }

	    public void sendMail() {
	    
	        SimpleMailMessage mailMessage = new SimpleMailMessage();
	        List<Reclamation> list=(List<Reclamation>)reclamationRepository.findAll();
	    	System.out.println("list.size()"+list.size());
	    	for(Reclamation reclam :list){
	    		if(reclam.getObjet().toString()=="Subscriptionproblem"){
	    			mailMessage.setTo("amir.akari@esprit.tn");
	    			mailMessage.setSubject("Answer for your subscription problem");
	    			mailMessage.setText("you can contact Mr. Akari Amir by email (amir.akari@esprit.tn) and in 2 days your problem will be solved");
	    			
	    		}
	    		if(reclam.getObjet().toString()=="PurchaseProblem"){
	    			mailMessage.setTo(reclam.getUser().getEmail());
	    			mailMessage.setSubject("Answer for your purchasing problem");
	    			mailMessage.setText("you can contact Ms. Bejoui Salsabil by email (salsabil.bejoui@esprit.tn) and in 2 days your problem will be solved");
	    			}
	    		
	    		if(reclam.getObjet().toString()=="Salesproblem"){
	    			mailMessage.setTo(reclam.getUser().getEmail());
	    			mailMessage.setSubject("Answer for your sales problem");
	    			mailMessage.setText("you can contact Mrs. Haribi Eya by email (eya.haribi@esprit.tn) and in 2 days your problem will be solved");
	    			}
	    		if(reclam.getObjet().toString()=="Publishingproblem"){
	    			mailMessage.setTo(reclam.getUser().getEmail());
	    			mailMessage.setSubject("Response for your publication problem");
	    			mailMessage.setText("you can contact Ms. Degachi Hela by email (hela.degachi@esprit.tn) and in 2 days your problem will be solved");
	    			}
	    		if(reclam.getObjet().toString()=="Problemvisit"){
	    			mailMessage.setTo(reclam.getUser().getEmail());
	    			mailMessage.setSubject("Response for your visit problem");
	    			mailMessage.setText("you can contact Ms. Mezri Chaime by email (chaima.mezri@esprit.tn) and in 2 days your problem will be solved");
	    			}
	    		if(reclam.getObjet().toString()=="Furnitureproblem"){
	    			mailMessage.setTo(reclam.getUser().getEmail());
	    			mailMessage.setSubject("Answer for your furniture problem");
	    			mailMessage.setText("you can contact Mrs. Jedidi Oumema by email (oumema.jedidi@esprit.tn) and in 2 days your problem will be solved");
	    			}
	    		}

	        mailMessage.setFrom("amir.akari@esprit.tn");
	        javaMailSender.send(mailMessage);
	        //javaMailSender.send(mailMessage);
	    }
}
