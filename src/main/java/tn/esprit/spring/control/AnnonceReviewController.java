package tn.esprit.spring.control;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Action;
import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.AnnonceReview;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.Type;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.AnnReviewService;
import tn.esprit.spring.service.AnnService;
import tn.esprit.spring.service.UserSerivce;


@Scope(value = "session") 
@Controller(value = "annonceRevController") 
@ELBeanName(value = "annonceRevController") 
public class AnnonceReviewController {

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
	
	
	
	private String text;
	private Date createdAt;
	private Date updatedAt;
	private Annonce annonce;
	private User user;
	
	private List<AnnonceReview> annonceReviews;
	
	
	

//	public List<AnnonceReview> getAnnonceReviews(Annonce ann) {
//		annonceReviews = iannservice.getAllReviewsByAnnonce(ann.getId());
//		return annonceReviews;
//	}
	
	public List<AnnonceReview> getAnnonceReviews() {
		annonceReviews = iannRevservice.retrieveAllAnnonceReviews();
		return annonceReviews;
	}
	
	public int countReviews(List<AnnonceReview> annonceReviews)
	{
		int numberreviews = annonceReviews.size();
		return numberreviews;
	}
	


	public void setAnnonceRevs(List<AnnonceReview> annonceReviews) {
		this.annonceReviews = annonceReviews;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public Annonce getAnnonce() {
		return annonce;
	}


	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String ajouterAnnonceReview(AnnonceReview annonceReview) {
		iannRevservice.addAnnonceReview(annonceReview);
		return annonceReview.getText();
	}



	
	public AnnonceReview getAnnonceReviewById(long id) 

	{
		return iannRevservice.retrieveAnnonceReview(id);
	}
	
	
	
	public void deleteAnnonceReviewById(Long id) {

			iannRevservice.deleteAnnonceReview(id);
		}
	
	
	
	
	public List<AnnonceReview> getAllReviewsByAnnonce(long annid)
	{
		return iannRevservice.getAllReviewsByAnnonce(annid);
	}
	
	
	
	public String ajouterAnnonceRev( )
	{
		String navigateTo = "null";
		if (usercontroller.doLogin()==navigateTo )
			{return "/login.xhtml?faces-redirect=true";}
		else{
			
			User currentuser= usercontroller.getAuthenticatedUser();
			Annonce currentAnnonce = annoncecontroller.getCurrentAnnonce();
			Date currentdate = new Date();
			iannRevservice.addAnnonceReview(new AnnonceReview( text, currentdate, currentAnnonce, currentuser )); 
			
		return navigateTo;
		}
	}
	
	
	public void displayAnnonceReview(AnnonceReview annrev) {
		this.setText(annrev.getText());
		this.setCreatedAt(annrev.getCreatedAt());
		this.setUser(annrev.getUser());
		this.setAnnonce(annrev.getAnnonce());
		
		
		
		
		}


	
}
