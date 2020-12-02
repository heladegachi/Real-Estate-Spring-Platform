package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import tn.esprit.spring.entity.VisitReelleEntity;

import tn.esprit.spring.service.VisiteReelleServiceImpl;

@RestController


public class VisiteReelleRestController {
	
		
		 @Autowired 
		 VisiteReelleServiceImpl VisiteReelleService; 
		 	 
	
		 // http://localhost:8081/SpringMVC/servlet/retrieve-all-visites
		 @GetMapping("/retrieve-all-visites") 
		 @ResponseBody 
		 public List<VisitReelleEntity> getVisiteReelle() { 
			 return VisiteReelleService.retrieveAllvisitReelles(); 
			 } 
		 
		// http://localhost:8081/SpringMVC/servlet/retrieve-visr/{visiter-id} 
		 @GetMapping("/retrieve-visr/{visiter-id}") 
		 @ResponseBody 
		 public VisitReelleEntity retrieveVisiteReelle(@PathVariable("visiter-id") Long visiterId) { 
			 return VisiteReelleService.retrieveVisitReelle(visiterId); 
			 } 
		  //  : http://localhost:8081/SpringMVC/servlet/add-visrr 
		 @PostMapping("/add-visrr") 
		 @ResponseBody 
		 public VisitReelleEntity addVisiteReelle(@RequestBody VisitReelleEntity V) { 
			 return VisiteReelleService.addVisitReelle(V); 
			   
		 }
		 
		// http://localhost:8081/SpringMVC/servlet/remove-visr/{visiter-id}
			@DeleteMapping("/remove-visr/{visiter-id}")
			@ResponseBody
			public void removeUser(@PathVariable("visiter-id") Long visiterId) {
				VisiteReelleService.deleteVisitReelle(visiterId);
			}

			
			// http://localhost:8081/SpringMVC/servlet/modify-visiter
			@PutMapping("/modify-visiter")
			@ResponseBody
			public VisitReelleEntity modifyvisiter(@RequestBody VisitReelleEntity VisiteReelle) {
			return VisiteReelleService.updateVisitReelle(VisiteReelle );
			}
			
		/*	@GetMapping("sendSms")
			@ResponseBody
			public String sendSms(@RequestBody String message){
				
				return smsService.sendSMS(message);
			}*/
		}
		 
		 
		 
	



