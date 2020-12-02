package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Achat;
import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.service.AchatServiceImpl;


@RestController
@RequestMapping(value = "/")
public class AchatRestController {
@Autowired
AchatServiceImpl achatService;

//URL : http://localhost:8081/SpringMVC/servlet/getEmployePrenomById/2
@GetMapping(value = "getAchatRemarqueById/{idacha}")
@ResponseBody
public String getAchatRemarqueById(@PathVariable("idacha")String Id) {
		return "cest la remarque: "+achatService.getAchatRemarqueById(Id);
	}



//http://localhost:8083/SpringMVC/servlet/retrieve-all-achats
	 @GetMapping(value = "retrieve-all-achats") 

	 @ResponseBody 
	 public List<Achat> getAchats() { 
		 List<Achat> list = achatService.retrieveAllAchats(); 
		 return list; 
		 } 
	// http://localhost:8081/SpringMVC/servlet/retrieve-achat/{achat-id} 
		 @GetMapping("/retrieve-achat/{achat-id}") 
		 @ResponseBody 
		 public Achat retrieveAchat(@PathVariable("achat-id") String achatId) { 
			 return achatService.retrieveAchat(achatId); 
			 } 
		 //http://localhost:8081/SpringMVC/servlet/add-achat
		 @PostMapping(value ="add-achat") 
		 @ResponseBody 
		 public Achat addAchat(@RequestBody Achat a) { 
			 Achat achat = achatService.addAchat(a); 
			 return achat; 
		 }
		// http://localhost:8083/SpringMVC/servlet/delete-achat/7
			@DeleteMapping(value ="delete-achat/{achat-id}")
			@ResponseBody
			public void deleteAchat(@PathVariable("achat-id") String achatId) {
				achatService.deleteAchat(achatId);
			}	
			// http://localhost:8081/SpringMVC/servlet/modify-achat
			@PutMapping("/modify-achat")
			@ResponseBody
			public Achat updateAchat(@RequestBody Achat achat) {
			return achatService.updateAchat(achat);
			}	
}
