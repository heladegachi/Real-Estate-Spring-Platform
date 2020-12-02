package tn.esprit.spring.control;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import tn.esprit.spring.entity.*;
import tn.esprit.spring.service.*;


@Scope(value = "session") 
@Controller(value = "userController") 
@ELBeanName(value = "userController") 
@Join(path = "/", to = "/login.jsf")

public class UserController  {
	@Autowired
	UserSerivce userservice;
	

	
	
	

	
	public void deleteUserById(String userId) {
		userservice.deleteUser(userId);
		
	}

	
	private List<User> users;
	
	

	public List<User> getUsers() {
		users = userservice.retrieveAllUsers();
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	public List<User> getAllUsers() {
		
		return userservice.retrieveAllUsers();
				}

	
	private String login;
	private String password;
	private User user;
	private Boolean loggedIn;
	private User authenticatedUser;
	 private boolean actif; 
	 private String nom;
	 private Type type;
	 private String prenom;
	 private String email;


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}

	public Type getType() {
		return type; 
	}

	public Type[] getTypes() {
		return Type.values(); 
	}



	public void setType(Type type) {
		this.type = type;
	}



	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}
	

	

	public UserSerivce getUserservice() {
		return userservice;
	}

	public void setUserservice(UserSerivce userservice) {
		this.userservice = userservice;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	

	public User getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(User authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	public String doLogin() {
		String navigateTo = "null";
		authenticatedUser= userservice.authenticate(login, password); 
		if (authenticatedUser != null  && authenticatedUser.getType() == Type.Admin)
		{ 
			navigateTo = "/pages/admin/AnnonceManagement.xhtml?faces-redirect=true";
			loggedIn = true;
		}
		else if (authenticatedUser != null  && authenticatedUser.getType() == Type.SimpleUser)
		{ 
			navigateTo = "/pages/user/welcomeUser2.xhtml?faces-redirect=true";
			loggedIn = true;
		}
		
		else {
			FacesMessage facesMessage =

					new FacesMessage("Login Failed: please check your username/password and try again.");

			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		}
		return navigateTo;
	}
	
	
	
	
	public void removeUser(String userId) {
		userservice.deleteUser(userId); }

    
	
	
	
	private Long userIdToBeUpdated; 
	
	public Long getUserIdToBeUpdated() {
		return userIdToBeUpdated;
	}

	public void setUserIdToBeUpdated(Long userIdToBeUpdated) {
		this.userIdToBeUpdated = userIdToBeUpdated;
	}

	public void displayUser(User user) {
		this.setPrenom(user.getPrenom());
		this.setNom(user.getNom());
	//	this.setActif(user.getActif());
		this.setEmail(user.getEmail());
		this.setPassword(user.getPassword());
		this.setType(user.getType());
		this.setUserIdToBeUpdated(user.getId());
		}

	public long ajouterUser(User user)
	{
		userservice.addUser(user);
		return user.getId();
	}
    
	
	
	public void updateUser() {
		userservice.addOrUpdateUser(new User(userIdToBeUpdated ,prenom, nom, email, password, type)); } 

	

	
	
	
	
	

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}
	
	
	public String gotoLogin(){
		return "/login.xhtml?faces-redirect=true";
	}

	public String gotoMeuble(){
		return "/pages/user/oumema.xhtml?faces-redirect=true";
	}
	public String gotoVirtualVisit(){
		return "/pages/user/chaima.xhtml?faces-redirect=true";
	}
	
	public String gotolistAdvertisement(){
		return "/pages/user/AnnoncesListing.xhtml?faces-redirect=true";
	}
	public String gotoHomepageUser(){
		return "/pages/user/welcomeUser2.xhtml?faces-redirect=true";
	}
	public String gotoAnnonceAdd(){
		return "/pages/user/AnnonceAdd.xhtml?faces-redirect=true";
	}
	
	public String gotoAnnonceDetail(){
		return "/pages/user/AnnonceDetails.xhtml?faces-redirect=true";
	}
	
	public String gotopagelog(){
		return "/login.xhtml?faces-redirect=true";
	}
	public String gotoLog(){
		return "/pages/user/UserProfile.xhtml?faces-redirect=true";
	}
	public String gotoUserProfile(){
		return "/pages/user/UserProfile.xhtml?faces-redirect=true";
	}
	public String gotoRent(){
		return "/pages/user/eya.xhtml?faces-redirect=true";
	}
	public String gotoBuy(){
		return "/pages/user/salsabil.xhtml?faces-redirect=true";
	}
	public String viewPurchases(){
		return "/pages/user/mesachatsprevu.xhtml?faces-redirect=true";
	}
	public String gotoSubscribe(){
		return "/pages/user/Logsubs.xhtml?faces-redirect=true";
	}
	public String gotoPublication(){
		return "/pages/user/publicab_login.xhtml?faces-redirect=true";
	}
	public String gotoSurveillance(){
		return "/pages/user/surveillancelog.xhtml?faces-redirect=true";
	}

	
	public String creerCompte(){
		return "/pages/user/user_register.xhtml?faces-redirect=true";
	}
	public String gotoReclamation(){
		return "/pages/user/reclamation.xhtml?faces-redirect=true";
	}
	public String gotoFiche(){
		return "/pages/user/fiche.xhtml?faces-redirect=true";
	}
	public String gotoAff(){
		return "/pages/user/table.xhtml?faces-redirect=true";
	}
	public String gotoLogassurance(){
		return "/pages/user/assurance_login.xhtml?faces-redirect=true";
	}
	public String gotoStatistique(){
		return "/pages/admin/bar.xhtml?faces-redirect=true";
	}
	
	
}
