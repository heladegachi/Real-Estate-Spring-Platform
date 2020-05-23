package tn.esprit.spring.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Action;
import tn.esprit.spring.entity.AdState;
import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.AnnonceReview;
import tn.esprit.spring.entity.ContractType;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.State;
import tn.esprit.spring.entity.StatePrice;
import tn.esprit.spring.entity.Type;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.service.AnnReviewService;
import tn.esprit.spring.service.AnnService;
import tn.esprit.spring.service.EmailService;
import tn.esprit.spring.service.NotificationServiceImpl;
import tn.esprit.spring.service.UserSerivce;


@Scope(value = "session") 
@Controller(value = "annonceController") 
@ELBeanName(value = "annonceController") 


public class AnnonceController {

	
	@Autowired
	AnnService iannservice;
	@Autowired
	AnnReviewService iannRevservice;
	@Autowired 
	AnnonceRepository annRepo;
	@Autowired
	UserSerivce userservice;
	@Autowired
	UserController usercontroller;
	@Autowired
	NotificationServiceImpl notificationservice;
	@Autowired
	EmailService emailService;


	public void deleteAnnonceById(String id)
	{
		iannservice.deleteAnnonce(id);
	}
	
	public Annonce getAnnonceById(String id) {

		return iannservice.retrieveAnnonce(id);
	}
	
	public int countAnnonces(List<Annonce> annonces)
	{
		int numberreviews = annonces.size();
		return numberreviews;
	}
	public int countAcceptedAnnonces(List<Annonce> annonces)
	{
		int numberreviews = annRepo.countAcceptedAds();
		return numberreviews;
	}
	
	
	public long ajouterAnnonceReview(AnnonceReview annRev) {
		return iannservice.ajouterAnnReview(annRev);
	}
	
	
	public List<AnnonceReview> getAllReviewsByAnnonce(long annId) {
		return iannservice.getAllReviewsByAnnonce(annId);
	}
	
	

	public void deleteReviewById(long annrevId) {
		iannRevservice.deleteAnnonceReview(annrevId);

	}
	
	private List<Annonce> annonces;
	
	public List<Annonce> getAnnonces() {
		annonces = iannservice.retrieveAllAnnonces();
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

	private Long annonceIdToBeUpdated;
	private String title;
	private String country;
	private String city;
	private String adresse;
	private String description;
	private State state;
	private String type;
	private Float price;
	private String history;
	private List<AnnonceReview> annonceReviews;
	private String picture;
	private String intSurface;
	private String extSurface;
	private Long numberRooms;
	private StatePrice statePrice;
	private Date createdAt;
	private User user;

	private AdState AdState;
	private Long numberBathrooms;

	private Long numberGarages;
	
	private ContractType contractType;
	
	private User authenticatedUser;
	
	private Boolean loggedIn;
	
	private Annonce currentAnnonce;
	
	private Long currentAnnonceid;
	
	
	private Boolean changecurr=false;
	

	
	
	
	
	
	

	public AdState getAdState() {
		return AdState;
	}

	public void setAdState(AdState adState) {
		AdState = adState;
	}

	public Boolean getChangecurr() {
		return changecurr;
	}

	public void setChangecurr(Boolean changecurr) {
		this.changecurr = changecurr;
	}

	public Long getCurrentAnnonceid() {
		return currentAnnonceid;
	}

	public void setCurrentAnnonceid(Long currentAnnonceid) {
		this.currentAnnonceid = currentAnnonceid;
	}

	public Annonce getCurrentAnnonce() {
		return currentAnnonce;
	}

	public void setCurrentAnnonce(Annonce currentAnnonce) {
		this.currentAnnonce = currentAnnonce;
	}

	public List<AnnonceReview> getAnnonceReviews() {

		annonceReviews = iannRevservice.getAllReviewsByAnnonce(currentAnnonce.getId());
		return annonceReviews;
	}

	public void setAnnonceReviews(List<AnnonceReview> annonceReviews) {
		this.annonceReviews = annonceReviews;
	}

	

	public User getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(User authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Long getNumberBathrooms() {
		return numberBathrooms;
	}

	public void setNumberBathrooms(Long numberBathrooms) {
		this.numberBathrooms = numberBathrooms;
	}

	public Long getNumberGarages() {
		return numberGarages;
	}

	public void setNumberGarages(Long numberGarages) {
		this.numberGarages = numberGarages;
	}

	public State getState() {
		return state;
	}

	public StatePrice getStatePrice() {
		return statePrice;
	}

	public ContractType getContractType() {
		return contractType;
	}

	

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public AnnService getIannservice() {
		return iannservice;
	}

	public ContractType[] getContractTypes() {
		return ContractType.values();
	}
	

	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}

	public void setIannservice(AnnService iannservice) {
		this.iannservice = iannservice;
	}

	public AnnReviewService getIannRevservice() {
		return iannRevservice;
	}

	public void setIannRevservice(AnnReviewService iannRevservice) {
		this.iannRevservice = iannRevservice;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getPrice() {
		if (changecurr==true)
			return (price*93)/100;
		else
			return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getIntSurface() {
		return intSurface;
	}

	public void setIntSurface(String intSurface) {
		this.intSurface = intSurface;
	}

	public String getExtSurface() {
		return extSurface;
	}

	public void setExtSurface(String extSurface) {
		this.extSurface = extSurface;
	}

	public Long getNumberRooms() {
		return numberRooms;
	}

	public void setNumberRooms(Long numberRooms) {
		this.numberRooms = numberRooms;
	}

	public StatePrice[] getStatePrices() {
		return StatePrice.values();
	}
	

	public void setStatePrice(StatePrice statePrice) {
		this.statePrice = statePrice;
	}
	
	public State[] getStates() {
		return State.values(); 
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return  createdAt= new Date();
		
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getAnnonceIdToBeUpdated() {
		return annonceIdToBeUpdated;
	}

	public void setAnnonceIdToBeUpdated(Long annonceIdToBeUpdated) {
		this.annonceIdToBeUpdated = annonceIdToBeUpdated;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public void displayAnnonce(Annonce annonce) {
		this.setTitle(annonce.getTitle());
		this.setAdresse(annonce.getAdresse());
		this.setDescription(annonce.getDescription());
		this.setState(annonce.getState());
		this.setAnnonceIdToBeUpdated(annonce.getId());
		this.setCountry(annonce.getCountry());
		this.setCity(annonce.getCity());
		this.setPrice(annonce.getPrice());
		this.setExtSurface(annonce.getExtSurface());
		this.setIntSurface(annonce.getIntSurface());
		this.setNumberRooms(annonce.getNumberRooms());
		this.setNumberBathrooms(annonce.getNumberBathrooms());
		this.setNumberGarages(annonce.getNumberGarages());
		this.setContractType(annonce.getContractType());
		this.setCreatedAt(annonce.getCreatedAt());
		
		
		
		}

	
	
	public String ajouterAnnonce( )
	{
		String navigateTo = "null";
		if (usercontroller.doLogin()==navigateTo )
			{return "/login.xhtml?faces-redirect=true";}
		else{
			
			User currentuser= usercontroller.getAuthenticatedUser();
			Date currentdate = new Date();
		long annid = iannservice.addOrUpdateAnnonce(new Annonce( title,   adresse, price , description, picture, intSurface, extSurface , numberRooms ,  statePrice ,currentdate, currentuser, history , state, contractType, country , city, numberBathrooms, numberGarages, AdState.InReview)); 

		
		notificationservice.save(new Notification("User added property", currentdate, Action.Added, false, currentuser, iannservice.retrieveAnnonceid(annid)) );
		//emailService.sendMail(iannservice.retrieveAnnonceid(annId).getUser().getEmail(), "Dari Update", "Your property is being reviewed.");
	
		return navigateTo;
		}
	}
	
	public String acceptAnnonce(Long annId)
	{
		User currentuser= usercontroller.getAuthenticatedUser();
		if (currentuser != null  && currentuser.getType() == Type.Admin)
		{ 
			iannservice.acceptAnnonceJPQL(annId);
			Date currentdate = new Date();
			notificationservice.save(new Notification("Property was accepted", currentdate, false, iannservice.retrieveAnnonceid(annId) ) );
			//emailService.sendMail(iannservice.retrieveAnnonceid(annId).getUser().getEmail(), "Dari Update", "Your property ad has been accepted.");
		
		}
		else {
			FacesMessage facesMessage =

					new FacesMessage("Login as an administrator");

			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		}
		return "InReview";
	}
	
	public String denyAnnonce(Long annId)
	{
		User currentuser= usercontroller.getAuthenticatedUser();
		if (currentuser != null  && currentuser.getType() == Type.Admin)
		{ 
			iannservice.denyAnnonceJPQL(annId);
			Date currentdate = new Date();
			notificationservice.save(new Notification("Property was denied", currentdate, false, iannservice.retrieveAnnonceid(annId) ) );
			//emailService.sendMail(iannservice.retrieveAnnonceid(annId).getUser().getEmail(), "Dari Update", "Your property ad has been denied.");
		}
		else {
			FacesMessage facesMessage =

					new FacesMessage("Login as an administrator");

			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		}
		return "InReview";
	}
	
	
	public boolean changeCurrency()
	{ return changecurr=true;
	}
	
	public boolean changeCurrency2()
	{ return changecurr=false;}

	
	
	
	
	public void updateAnnonce() {
		iannservice.addOrUpdateAnnonce(new Annonce(annonceIdToBeUpdated, title,   adresse, price , description, picture, intSurface, extSurface , numberRooms ,  statePrice ,createdAt, user, history , state, contractType, country , city, numberBathrooms, numberGarages)); } 
	
	public void updateAnnonce(Long annonceIdToBeUpdated) {
		iannservice.addOrUpdateAnnonce(new Annonce(annonceIdToBeUpdated, title,   adresse, price , description, picture, intSurface, extSurface , numberRooms ,  statePrice ,createdAt, user, history , state, contractType, country , city, numberBathrooms, numberGarages)); } 
	
	


	public void removeAnnonce(String annonceId) {
		
		User currentuser= usercontroller.getAuthenticatedUser();
		if (currentuser != null && ( currentuser.getType() == Type.Admin || currentuser.equals(iannservice.retrieveAnnonce(annonceId).getUser()) ) )
		{
			iannservice.deleteAnnonce(annonceId);
			Date currentdate = new Date();
			notificationservice.save(new Notification("User deleted property", currentdate, Action.Deleted, false, currentuser, iannservice.retrieveAnnonce(annonceId) ) );
		}
		else {
			FacesMessage facesMessage =
					new FacesMessage("You don't have the privilege to delete this Advertisement");
			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		}
		}
	
	
	
	public String gotoAnnonceDetail(Annonce annonce){
		
		this.setTitle(annonce.getTitle());
		this.setAdresse(annonce.getAdresse());
		this.setDescription(annonce.getDescription());
		this.setState(annonce.getState());
		this.setAnnonceIdToBeUpdated(annonce.getId());
		this.setCountry(annonce.getCountry());
		this.setCity(annonce.getCity());
		this.setPrice(annonce.getPrice());
		this.setExtSurface(annonce.getExtSurface());
		this.setIntSurface(annonce.getIntSurface());
		this.setNumberRooms(annonce.getNumberRooms());
		this.setNumberBathrooms(annonce.getNumberBathrooms());
		this.setNumberGarages(annonce.getNumberGarages());
		this.setContractType(annonce.getContractType());
		this.setCreatedAt(annonce.getCreatedAt());
		this.setUser(annonce.getUser());
		this.setAnnonceReviews(annonce.getAnnonceReviews());
		
		currentAnnonce = annonce; 
		currentAnnonceid = annonce.getId(); 
		
		return "/pages/user/AnnonceDetails.xhtml?faces-redirect=true";
	}
	
	
	
	

}
