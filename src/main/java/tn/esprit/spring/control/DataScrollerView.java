package tn.esprit.spring.control;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import tn.esprit.spring.entity.VisitReelleEntity;
import tn.esprit.spring.service.EmailVisiteService;
import tn.esprit.spring.service.VisiteReelleService;

@Named
@ViewScoped
public class DataScrollerView implements Serializable {
	 	private List<VisitReelleEntity> visitReelles;
     
	 	private final static String ACCOUNT_SID = "AC31ad04d6f2dd8502b8710c471805eab1";
		private final static String AUTH_ID = "10280d7bc12ed51a66625c2552597612";
		   
	    @Inject
	    private VisiteReelleService service;
	    
	    @Autowired
	    private EmailVisiteService emailService;
	     
	    @PostConstruct
	    public void init() {
	    	visitReelles = service.retrieveAllvisitReelles();
			
	    	Twilio.init(ACCOUNT_SID, AUTH_ID);
			 
	    }
	 
	    public List<VisitReelleEntity> getVisitReelles() {
	        return service.retrieveAllvisitReelles();
	    }
	 
	    public void setService(VisiteReelleService service) {
	        this.service = service;
	    }
	    
	    public void delete(Long id) {        
	    	service.deleteVisitReelle(id);
	    	
	    	visitReelles = service.retrieveAllvisitReelles();
	    	
	    	
	    }
	    
	    public void onConfirm(String email, String phone) {
	    	 emailService.sendMail(email, "Test Subject", "Test mail");
	    	 
	    	 Message.creator(new PhoneNumber(phone), new PhoneNumber("+19564774947"),
			         "Message from Spring Boot Application").create();
	    }

}
