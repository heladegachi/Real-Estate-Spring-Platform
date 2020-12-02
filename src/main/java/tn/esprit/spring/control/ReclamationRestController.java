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

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.service.ReclamationServiceImpl;
@RestController
public class ReclamationRestController {
	@Autowired
	ReclamationServiceImpl reclamationService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-Reclamations
	@GetMapping("/retrieve-all-Reclamations")
	@ResponseBody
	public List<Reclamation> getReclamation() {
	List<Reclamation> list= reclamationService.retrieveAllReclamation();
	return list;
}
	// http://localhost:8081/SpringMVC/servlet/retrieve-Reclamation/{Reclamation-id}
	@GetMapping("/retrieve-Reclamation/{Reclamation-id}")
	@ResponseBody
	public Reclamation retrieveReclamation(@PathVariable("Reclamation-id") String ReclamationId) {
	return reclamationService.retrieveReclamation(ReclamationId);}
	
	// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-Reclamation
	@PostMapping("/add-Reclamation")
	@ResponseBody
	public Reclamation addReclamation(@RequestBody Reclamation r) {
		
	Reclamation reclamation= reclamationService.addReclamation(r);

	return reclamation;
	}
	// http://localhost:8081/SpringMVC/servlet/remove-Reclamation/{Reclamation-id}
	@DeleteMapping("/remove-Reclamation/{Reclamation-id}")
	@ResponseBody
	public void removeUser(@PathVariable("Reclamation-id") String reclamationId) {
		reclamationService.deleteReclamation(reclamationId);
	}

	
	// http://localhost:8081/SpringMVC/servlet/modify-Reclamation
	@PutMapping("/modify-Reclamation")
	@ResponseBody
	public Reclamation modifyReclamation(@RequestBody Reclamation reclamation) {
	return reclamationService.updateReclamation(reclamation);
	}
}
