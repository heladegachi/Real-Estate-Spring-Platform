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

import tn.esprit.spring.entity.Fiche;
import tn.esprit.spring.service.FicheServiceImpl;
@RestController
public class FicheController {
	@Autowired
	FicheServiceImpl subscriptionService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-fiches
	@GetMapping("/retrieve-all-fiches")
	@ResponseBody
	public List<Fiche> getFiche() {
	List<Fiche> list= subscriptionService.retrieveAllFiche();
	return list;
}
	// http://localhost:8081/SpringMVC/servlet/retrieve-fiches/{fiche-id}
	@GetMapping("/retrieve-fiche/{fiche-id}")
	@ResponseBody
	public Fiche retrieveFiche(@PathVariable("fiche-id") String ficheId) {
	return subscriptionService.retrieveFiche(ficheId);}
	
	// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-fiche
	@PostMapping("/add-fiche")
	@ResponseBody
	public Long addFiche(@RequestBody Fiche s) {
	Long subscription= subscriptionService.addFiche(s);
	return subscription;
	}
	// http://localhost:8081/SpringMVC/servlet/remove-fiche/{fiche-id}
	@DeleteMapping("/remove-fiche/{fiche-id}")
	@ResponseBody
	public void removeUser(@PathVariable("fiche-id") String ficheId) {
		subscriptionService.deleteFiche(ficheId);
	}

	
	// http://localhost:8081/SpringMVC/servlet/modify-fiche
	@PutMapping("/modify-fiche")
	@ResponseBody
	public Fiche modifyFiche(@RequestBody Fiche fiche) {
	return subscriptionService.updateFiche(fiche);
	}
	// http://localhost:8081/SpringMVC/servlet/retrieve-nb1
		@GetMapping("/retrieve-nb1")
		@ResponseBody
		public int getNombretrueJPQL() {
		
		return subscriptionService.getNombretrueJPQL();
	}
		// http://localhost:8081/SpringMVC/servlet/retrieve-nb2
				@GetMapping("/retrieve-nb2")
				@ResponseBody
				public int getNombrefalseJPQL() {
				
				return subscriptionService.getNombrefalseJPQL();
			}
				// http://localhost:8081/SpringMVC/servlet/retrieve-nb3
				@GetMapping("/retrieve-nb3")
				@ResponseBody
				public int getNombreamiJPQL() {
				
				return subscriptionService.getNombreamiJPQL();
			}
				// http://localhost:8081/SpringMVC/servlet/retrieve-nb4
				@GetMapping("/retrieve-nb4")
				@ResponseBody
				public int getNombrefamilleJPQL() {
				
				return subscriptionService.getNombrefamilleJPQL();
			}
				// http://localhost:8081/SpringMVC/servlet/retrieve-nb5
				@GetMapping("/retrieve-nb5")
				@ResponseBody
				public int getNombresitewebJPQL() {
				
				return subscriptionService.getNombresitewebJPQL();
			}
				// http://localhost:8081/SpringMVC/servlet/retrieve-nb6
				@GetMapping("/retrieve-nb6")
				@ResponseBody
				public int getNombrefacebookJPQL() {
				
				return subscriptionService.getNombrefacebookJPQL();
			}
}
