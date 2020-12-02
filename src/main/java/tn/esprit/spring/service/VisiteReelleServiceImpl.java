package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import tn.esprit.spring.entity.VisitReelleEntity;
import tn.esprit.spring.repository.VisiteReelleRepo;


	@Service
	public class VisiteReelleServiceImpl implements VisiteReelleService  {
		
		@Autowired
		VisiteReelleRepo visiteReelleRepository;

		private static final Logger L=LogManager.getLogger(VisiteReelleServiceImpl .class);

		@Override
		public List<VisitReelleEntity> retrieveAllvisitReelles() {
			List<VisitReelleEntity> VisitReelles= (List<VisitReelleEntity>) visiteReelleRepository.findAll();
			L.info(VisitReelles.toString());
			return VisitReelles;
		}
		
		@Override
		public VisitReelleEntity addVisitReelle(VisitReelleEntity V){
			return visiteReelleRepository.save(V);
		}
		
	

		@Override
		public void deleteVisitReelle(Long id) {
			visiteReelleRepository.deleteById(id);
			
		}

		@Override
		public VisitReelleEntity updateVisitReelle(VisitReelleEntity V) {
			return visiteReelleRepository.save(V);
			 
		}

		@Override
		public VisitReelleEntity retrieveVisitReelle(Long id) {
			return visiteReelleRepository.findById(id).orElse(null);
		}

		 private final static String ACCOUNT_SID = "AC31ad04d6f2dd8502b8710c471805eab1";
		   private final static String AUTH_ID = "10280d7bc12ed51a66625c2552597612";

		   static {
		      Twilio.init(ACCOUNT_SID, AUTH_ID);
		   }
		 
		   public void run() throws Exception {
		      Message.creator(new PhoneNumber("+21695420746"), new PhoneNumber("+19564774947"),
		         "Message from Spring Boot Application").create();
		   }
		
	


	}



   