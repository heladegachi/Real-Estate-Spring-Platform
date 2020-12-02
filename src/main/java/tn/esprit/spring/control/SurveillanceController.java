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

import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;

import tn.esprit.spring.entity.Surveillance;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.StripeService;
import tn.esprit.spring.service.SurveillanceService;
import tn.esprit.spring.service.UserSerivce;
import tn.esprit.spring.service.UserServiceImpl;

@Scope(value = "session")
@Controller(value = "surveillanceController")
@ELBeanName(value = "surveillanceController")
@Join(path= "/l2", to = "/surveillancelog.jsf")
public class SurveillanceController {
	@Autowired
	SurveillanceService surService;
	@Autowired
	StripeService stripeService;
	
	public StripeService getStripeService() {
		return stripeService;
	}

	public void setStripeService(StripeService stripeService) {
		this.stripeService = stripeService;
	}

	public void setSurveils(List<Surveillance> surveils) {
		this.surveils = surveils;
	}

	private Long id; private String code; private Surveillance surveillance;
	private Boolean loggedIn;
	private Date datedeb;
	private Date datefin;
	private Long nombrecamera;
	private User user;
	@Autowired
	SurveillanceService surveillanceservice;
	@Autowired
	UserServiceImpl userService;
	@Autowired
	UserController usercontroller;
	@Autowired
	UserSerivce userservice;
	
	int idc;String carta; int expMonth;int expYear;String cvc;
	
	public int getIdc() {
		return idc;
	}

	public void setIdc(int idc) {
		this.idc = idc;
	}

	public String getCarta() {
		return carta;
	}

	public void setCarta(String carta) {
		this.carta = carta;
	}

	public int getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public UserController getUsercontroller() {
		return usercontroller;
	}

	public void setUsercontroller(UserController usercontroller) {
		this.usercontroller = usercontroller;
	}

	public UserSerivce getUserservice() {
		return userservice;
	}

	public void setUserservice(UserSerivce userservice) {
		this.userservice = userservice;
	}

	private List<Surveillance> surveils;

	

	public List<Surveillance> getSurveils() {
		surveils= surveillanceservice.affichersurveilconnecté(usercontroller.getAuthenticatedUser().getId());
		System.out.println(surveils);
		return surveils;
	}

	public void setSurveil(List<Surveillance> surveils) {
		this.surveils = surveils;
	}

	public void addSurveillance() {
		
		User currentuser=usercontroller.getAuthenticatedUser();
		
		surveillanceservice.addOrUpdateSurveillance(new Surveillance( datedeb, datefin,code, nombrecamera,currentuser));
		}
	
	public List<Surveillance> getSurveillanceconnecté() {
		
		

		//System.out.println(currentsurveillance);
		surveils= surveillanceservice.affichersurveilconnecté(usercontroller.getAuthenticatedUser().getId());
		System.out.println(surveils);
		return surveils;
		
		
		}
	public List<Surveillance> surveillances;
	public List<Surveillance> getSurveillances1() {
		User currentuser=usercontroller.getAuthenticatedUser();
		//System.out.println(currentuser);
		surveillances= surveillanceservice.affichersurveil(currentuser);
		//System.out.println(surveillances);
		return surveillances;
		}
	public List<Surveillance> getSurveillances() {
		surveillances= surveillanceservice.affichersurveil(usercontroller.getAuthenticatedUser());
		//System.out.println(surveils);
		return surveillances;
	}

	public void setSurveillances(List<Surveillance> surveillances) {
		this.surveillances = surveillances;
	}

	private List<User> users;
	public List<User> getUsers() {
		users= userService.retrieveAllUsers();
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public SurveillanceService getSurveillanceservice() {
		return surveillanceservice;
	}

	public void setSurveillanceservice(SurveillanceService surveillanceservice) {
		this.surveillanceservice = surveillanceservice;
	}

	
	public UserServiceImpl getUserService() {
		return userService;
	}

	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}

	public Date getDatedeb() {
		return datedeb;
	}
	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public Long getNombrecamera() {
		return nombrecamera;
	}
	public void setNombrecamera(Long nombrecamera) {
		this.nombrecamera = nombrecamera;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public SurveillanceService getSurService() {
		return surService;
	}
	public void setSurService(SurveillanceService subService) {
		this.surService = subService;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Surveillance getSurveillance() {
		return surveillance;
	}
	public void setSurveillance(Surveillance surveillance) {
		this.surveillance = surveillance;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	private Surveillance authenticatedSurveillance;
	
	public Surveillance getAuthenticatedSurveillance() {
		return authenticatedSurveillance;
	}

	public void setAuthenticatedSurveillance(Surveillance authenticatedSurveillance) {
		this.authenticatedSurveillance = authenticatedSurveillance;
	}

	public String doLogin() {
		String navigateTo= "null";
		authenticatedSurveillance=surService.authenticate(id, code);
		if(authenticatedSurveillance!= null) {
		navigateTo= "/pages/user/Camera.xhtml?faces-redirect=true";
		loggedIn= true; }
		else{
		FacesMessage facesMessage=
		new FacesMessage("Login Failed: please check your id/code and try again.");
		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		}
		public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return"/surveillancelog.xhtml?faces-redirect=true";
		}
		public String creerAbSurveillance(){
			return "/pages/user/creerAbSurveillance.xhtml?faces-redirect=true";
		}
		public String afabonnement(){
			return "/pages/user/afsurveil.xhtml?faces-redirect=true";
		}
		public void modifyPrix() {
			surveillanceservice.updatePrix();
			
			}
		public void removeSurv(String surveillanceId)
		{
			surService.deleteSurv(surveillanceId);
		}
		public void Pay(int idc,String carta, int expMonth,int expYear,String cvc) throws AuthenticationException, InvalidRequestException, CardException, StripeException{
			 
			stripeService.PaySurveillance(idc,carta,expMonth,expYear,cvc);
			
		}
}
