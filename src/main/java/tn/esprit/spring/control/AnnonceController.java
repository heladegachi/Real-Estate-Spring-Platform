package tn.esprit.spring.control;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Action;
import tn.esprit.spring.entity.AdState;
import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.AnnoncePosition;
import tn.esprit.spring.entity.AnnonceReview;
import tn.esprit.spring.entity.ContractType;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.State;
import tn.esprit.spring.entity.StatePrice;
import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.entity.Type;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.service.AnnPositionService;
import tn.esprit.spring.service.AnnReviewService;
import tn.esprit.spring.service.AnnService;
import tn.esprit.spring.service.EmailServiceHela;
import tn.esprit.spring.service.NotificationServiceImpl;
import tn.esprit.spring.service.SubscripService;
import tn.esprit.spring.service.UserSerivce;
import tn.esprit.spring.control.UserController;


 

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
	EmailServiceHela emailService;
	@Autowired
	SubscripService subsservice;
	@Autowired
	SubscripController subscontroller;
	@Autowired 
	AnnPositionService annPosSer;
	@Autowired
	AddMarkersView addMarkerView;



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
	public int countAcceptedUserAnnonces(long id)
	{
		int numberreviews = annRepo.countUserAds(id);
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
		for (int i = 0, j = annonces.size() - 1; i < j; i++) {
			annonces.add(i, annonces.remove(j));
		}
		return annonces;
	}
	
	

	
	
	public List<Annonce> getBestReviewedAnnonces() {
		annonces = iannservice.retrieveBestReviewed(); 
	
		return annonces;
	}
	
	
	private Boolean sortByHighestPrice = false;
	
	public Boolean checkRetrieveHighestPrice() {
		return sortByHighestPrice = true;
		
	}
	public List<Annonce> getHighestPriceAnnonces() {
		if (sortByHighestPrice = false)
		{
			annonces = iannservice.retrieveAllAnnonces();
			for (int i = 0, j = annonces.size() - 1; i < j; i++) {
				annonces.add(i, annonces.remove(j));
			}			
		}
		else if (sortByHighestPrice = true)
		{
			User currentuser= usercontroller.getAuthenticatedUser();
			annonces = iannservice.retrieveHighestPrice(currentuser.getId());}
		
		
		
		return annonces;
	}
	
	
	public Boolean getSortByHighestPrice() {
		return sortByHighestPrice;
	}

	public void setSortByHighestPrice(Boolean sortByHighestPrice) {
		this.sortByHighestPrice = sortByHighestPrice;
	}



	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

	private Long id;
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
	private Date updatedAt;
	private User user;

	private AdState AdState;
	private Long numberBathrooms;

	private Long numberGarages;
	
	private ContractType contractType;
	
	private User authenticatedUser;
	
	private Boolean loggedIn;
	
	private Annonce currentAnnonce;
	
	private Long currentAnnonceid;
	
	private int rating;
	 
	private Boolean changecurr=false;
	

	
	
	
	
	
	

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getRating() {
		
		//int rating = annonceRating(id);
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}   

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
			return (price*285)/100;
		else
			return price;
	}
	public Float fromDollarToDinar(Float price)
	{
		return (price*285)/100;
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
	private AnnoncePosition annoncePosition;
	 

	

	public AnnoncePosition getAnnoncePosition() {
		annoncePosition = annPosSer.getAnnoncePosByAnnId(currentAnnonce.getId());
		
		return annoncePosition;
	}

	public void setAnnoncePosition(AnnoncePosition annoncePosition) {
		this.annoncePosition = annoncePosition;
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

	private double lat;
	
    private double lng;
    
	
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

	public String ajouterAnnonce( )
	{
		String navigateTo = "/pages/user/AnnonceDetails.xhtml?faces-redirect=true";   
		if (usercontroller.doLogin()==navigateTo )
			{return "/login.xhtml?faces-redirect=true";}
		else{
			
			User currentuser= usercontroller.getAuthenticatedUser();
			Date currentdate = new Date();
		long annid = iannservice.addOrUpdateAnnonce(new Annonce( title,   adresse, price , description, picture, intSurface, extSurface , numberRooms ,  statePrice ,currentdate, currentuser, history , state, contractType, country , city, numberBathrooms, numberGarages, AdState.InReview, 0));
		AnnoncePosition annPos =annPosSer.addAnnoncePosition( new AnnoncePosition ( iannservice.retrieveAnnonceid(annid).getTitle(), lat , lng , iannservice.retrieveAnnonceid(annid) ) );
		  
		iannservice.retrieveAnnonceid(annid).setAnnoncePosition(annPos);
		
		
		notificationservice.save(new Notification("User added property", currentdate, Action.Added, false, currentuser, iannservice.retrieveAnnonceid(annid)) );
		String mailmsg= "Your property " + iannservice.retrieveAnnonceid(annid).getTitle() + " " + "(" + iannservice.retrieveAnnonceid(annid).getAdresse() +")" + " is being reviewed" ;
		emailService.sendMail(iannservice.retrieveAnnonceid(annid).getUser().getEmail(), "Dari Update", mailmsg);
	
		return navigateTo;
		}
	}
	
	
    private UploadedFile file; 
    
	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
 
	public void upload() {
		System.out.println("test");
        if (file != null) {
        	System.out.println("start");
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void handleAisleFile(FileUploadEvent event) {
    	System.err.println("file uploaded success" );
    	UploadedFile file = event.getFile();
    }
	
	public String addAnnonceTest( )
	{
		String navigateTo = "/pages/user/AnnonceDetails.xhtml?faces-redirect=true"; 
		
			Date currentdate = new Date(); 
		iannservice.addOrUpdateAnnonce(new Annonce( "annonce test",   adresse, price , description, file.getFileName(), intSurface, extSurface , numberRooms ,  statePrice ,currentdate, userservice.retrieveUser("1"), history , state, contractType, country , city, numberBathrooms, numberGarages, AdState.InReview, 0));
		//iannservice.retrieveAnnonceid(annid).setPicture(file.getFileName());

		
		return navigateTo;
		
	}
	
	public Long checkIfPaid( ) {
		
		User currentuser= usercontroller.getAuthenticatedUser();
		List<Subscription> subs = subscontroller.getSurveils();
		if ( subs.isEmpty() )
			return (long) 0;
		for (int i=0; i<subs.size();i++)
		{
			
			 if ( !subs.isEmpty() && subs.get(i).getUser().getId() == currentuser.getId() && subs.get(i).getPrix()> 2000 )
				 return subs.get(i).getId();
			 			 
		}
	    return (long) 0;
	  }
	
	public String payAnnonce(Long annId)
	{
		User currentuser= usercontroller.getAuthenticatedUser();
		List<Subscription> subs = subscontroller.getSurveils();
		Long test = checkIfPaid();
		String navigateTo = "null";
		if (usercontroller.doLogin()==navigateTo )
		{return "/login.xhtml?faces-redirect=true";}
		
		if (currentuser != null && test != (long) 0 )
		{ 
			iannservice.paidAnnonceJPQL(annId);
			subsservice.changePriceJPQL(subsservice.retrieveSubscriptionL(test).getPrix() - 2000, test);
			Date currentdate = new Date();
			notificationservice.save(new Notification("Annonce was paid", currentdate, Action.Paid, false,currentuser, iannservice.retrieveAnnonceid(annId) ) );
			//emailService.sendMail(iannservice.retrieveAnnonceid(annId).getUser().getEmail(), "Dari Update", "Your property ad has been accepted.");
		
		}
		else {
			FacesMessage facesMessage =
					new FacesMessage("Go To subscription page to pay before");
			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
			return "/pages/user/creerAbPublication.xhtml?faces-redirect=true";
		}
		return "InReview";
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
 
	
	
	
	
	public int annonceRating(long id)
	{
		int rating=0;
		List<AnnonceReview> annRevs = iannservice.retrieveAnnonceid(id).getAnnonceReviews(); 
		if (annRevs.isEmpty())
			return 0;
		else {
			for (int i=0; i<annRevs.size(); i++)
			{
				rating += annRevs.get(i).getRating();
			}
		}
		rating = Math.round( rating/annRevs.size() );
		       

		iannservice.changeRatingJPQL(id, rating);
		//iannservice.retrieveAnnonceid(id).setRating(rating); 
		
		if (rating<2 && annRevs.size()>=2)
			iannservice.denyAnnonceJPQL(id);
		
        		
		return rating ;
	}
	 
	 
	
	public String updateAnnonce(Long annonceIdToBeUpdated) {
		Date currentdate = new Date();
		iannservice.addOrUpdateAnnonce(new Annonce(annonceIdToBeUpdated, title,   adresse, price , description, picture, intSurface, extSurface , numberRooms ,  statePrice ,createdAt, currentdate, user, history , state, contractType, country , city, numberBathrooms, numberGarages, AdState.InReview)); 
		User currentuser= usercontroller.getAuthenticatedUser();
		notificationservice.save(new Notification("Property was updated", currentdate, Action.Updated, false, currentuser, iannservice.retrieveAnnonceid(annonceIdToBeUpdated) ) );
		//emailService.sendMail(iannservice.retrieveAnnonceid(annonceIdToBeUpdated).getUser().getEmail(), "Dari Update", "Your property update is being reviewed.");
	
		
		return "/pages/user/AnnonceDetails.xhtml?faces-redirect=true";
	}   
	
	
	

	public void removeAnnonce(String annonceId) {
		
		User currentuser= usercontroller.getAuthenticatedUser();
		if (currentuser != null && ( currentuser.getType() == Type.Admin || currentuser== iannservice.retrieveAnnonce(annonceId).getUser())  )
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
	
	
	
	public String removeAnnonceL(long annonceId) {
	 
			
			User currentuser= usercontroller.getAuthenticatedUser();
			if (currentuser != null && currentuser.getId()== currentAnnonce.getUser().getId()  )
			{
				iannservice.deleteAnnonceL(annonceId);
				Date currentdate = new Date();
				notificationservice.save(new Notification("User deleted property", currentdate, Action.Deleted, false, currentuser, iannservice.retrieveAnnonceid(annonceId) ) );
			}
			else {
				FacesMessage facesMessage =
						new FacesMessage("You don't have the privilege to delete this Advertisement");
				FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
			}
			return "/pages/user/welcomeUser2.xhtml?faces-redirect=true";
			
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
