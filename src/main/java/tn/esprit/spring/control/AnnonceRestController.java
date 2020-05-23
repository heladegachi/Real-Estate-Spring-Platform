package tn.esprit.spring.control;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.service.AnnServiceImpl;


@RestController
public class AnnonceRestController {
	
	 @Autowired 
	 AnnServiceImpl annService; 
	 
	 // http://localhost:8081/SpringMVC/servlet/retrieve-all-annonces
	 @GetMapping("/retrieve-all-annonces") 
	 @ResponseBody 
	 public List<Annonce> getAnnonces() { 
		 List<Annonce> list = annService.retrieveAllAnnonces(); 
		 return list; 
		 } 
	// http://localhost:8081/SpringMVC/servlet/retrieve-annonce/{annonce-id} 
	 @GetMapping("/retrieve-ann/{annonce-id}") 
	 @ResponseBody 
	 public Annonce retrieveAnn(@PathVariable("annonce-id") String annonceId) { 
		 return annService.retrieveAnnonce(annonceId); 
		 } 
	  // Ajouter Annonce : http://localhost:8081/SpringMVC/servlet/add-annonce 
	 @PostMapping("/add-annonce") 
	 @ResponseBody 
	 public Annonce addAnn(@RequestBody Annonce u) { 
		 Annonce ann = annService.addAnnonce(u); 
		 return ann; 
	 }
	 
}
