package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.AnnonceReview;
import tn.esprit.spring.service.AnnReviewServiceImpl;

@RestController
public class AnnonceReviewRestController {
	
	 @Autowired 
	 AnnReviewServiceImpl annReviewService; 
	 
	 // http://localhost:8081/SpringMVC/servlet/retrieve-all-annonceReviews
	 @GetMapping("/retrieve-all-annonceReviews") 
	 @ResponseBody 
	 public List<AnnonceReview> getAnnonceReviews() { 
		 List<AnnonceReview> list = annReviewService.retrieveAllAnnonceReviews(); 
		 return list; 
		 } 
	// http://localhost:8081/SpringMVC/servlet/retrieve-annonceReview/{annonceReview-id} 
	 @GetMapping("/retrieve-annReview/{annonceReview-id}") 
	 @ResponseBody 
	 public AnnonceReview retrieveAnnReview(@PathVariable("annonceReview-id") long annonceReviewId) { 
		 return annReviewService.retrieveAnnonceReview(annonceReviewId); 
		 } 
	  // Ajouter AnnonceReview : http://localhost:8081/SpringMVC/servlet/add-annonceReview 
	 @PostMapping("/add-annonceReview") 
	 @ResponseBody 
	 public AnnonceReview addAnn(@RequestBody AnnonceReview u) { 
		 AnnonceReview ann = annReviewService.addAnnonceReview(u); 
		 return ann; 
	 }
	 @PutMapping("/modify-annonceReview/{annonceReview-id}") 
	 @ResponseBody 
	 public AnnonceReview modifyAnn(@RequestBody AnnonceReview u) { 
		 AnnonceReview ann = annReviewService.updateAnnonceReview(u); 
		 return ann; 
	 }
	 

}
