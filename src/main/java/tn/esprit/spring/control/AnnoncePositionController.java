package tn.esprit.spring.control;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.AnnoncePosition;
import tn.esprit.spring.entity.AnnonceReview;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.AnnPositionService;
import tn.esprit.spring.service.AnnReviewService;
import tn.esprit.spring.service.AnnService;
import tn.esprit.spring.service.UserSerivce;

@Scope(value = "session") 
@Controller(value = "annoncePosController") 
@ELBeanName(value = "annoncePosController") 
public class AnnoncePositionController {
	
	
	
	@Autowired
	UserSerivce iuserService;
	@Autowired
	AnnService iannservice;
	@Autowired
	AnnReviewService iannRevservice;
	@Autowired
	AnnonceController annoncecontroller;
	@Autowired
	UserController usercontroller;
	@Autowired
	RatingView ratingView;
	@Autowired 
	AnnPositionService annPosSer;
	@Autowired
	AddMarkersView addMarkerView;
	
	
	 private String title;
	
   private double lat;

   private double lng;
	
	
	

	


	public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public double getLat() {
	return lat;
}


public void setLat(double lat) {
	this.lat = lat;
}


public double getLng() {
	return lng;
}


public void setLng(double lng) {
	this.lng = lng;
}


	
	public String ajouterAnnoncePos(AnnoncePosition annoncePos) {
		annPosSer.addAnnoncePosition(annoncePos);
		return annoncePos.getTitle();
	}



	
	public AnnoncePosition retrieveAnnoncePosByAnnId(Long id) 

	{
		return annPosSer.getAnnoncePosByAnnId(id);
	}
	
	
	
	
	

	



}
