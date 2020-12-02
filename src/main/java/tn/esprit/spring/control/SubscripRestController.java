package tn.esprit.spring.control;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.service.SubscripServiceImpl;
import tn.esprit.spring.entity.*;
@Scope(value = "session")
@Controller(value = "subscripController")
@ELBeanName(value = "subscripController")
@Join(path= "/publication", to = "/pages/admin/publication.jsf")
public class SubscripRestController {
	@Autowired
	SubscripServiceImpl subscriptionService;
	private Date dateDebut;
	private Date dateFin;
	private String code;
	private Float prix;
	private User user;
	private List<Subscription> subs;
	
	public List<Subscription> getSubs() {
		return subs;
	}
	public void setSubs(List<Subscription> subs) {
		this.subs = subs;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public SubscripServiceImpl getSubscriptionService() {
		return subscriptionService;
	}
	public void setSubscriptionService(SubscripServiceImpl subscriptionService) {
		this.subscriptionService = subscriptionService;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-subscriptions
	@GetMapping("/retrieve-all-subscriptions")
	@ResponseBody
	public List<Subscription> getSubscription() {
	subs= subscriptionService.retrieveAllSubscription();
	return subs;
}
	// http://localhost:8081/SpringMVC/servlet/retrieve-subscription/{subscription-id}
	@GetMapping("/retrieve-subscription/{subscription-id}")
	@ResponseBody
	public Subscription retrieveSubscription(@PathVariable("subscription-id") String subscriptionId) {
	return subscriptionService.retrieveSubscription(subscriptionId);}
	
	// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-subscription
	@PostMapping("/add-subscription")
	@ResponseBody
	public void addSubscription() {
		//s.setPrix(subscriptionService.calcul(s.getDateDebut(), s.getDateFin()));
	 subscriptionService.addSubscription(new Subscription(dateDebut, dateFin, code, user));
	
	}
	// http://localhost:8081/SpringMVC/servlet/remove-subscription/{subscription-id}
	@DeleteMapping("/remove-subscription/{subscription-id}")
	@ResponseBody
	public void removeUser(@PathVariable("subscription-id") String subscriptionId) {
		subscriptionService.deleteSubscription(subscriptionId);
	}

	
	// http://localhost:8081/SpringMVC/servlet/modify-subscription
	@PutMapping("/modify-subscription")
	@ResponseBody
	public Subscription modifySubscription(@RequestBody Subscription subscription) {
	return subscriptionService.updateSubscription(subscription);
	}
	// http://localhost:8081/SpringMVC/servlet/modify-prix
	/*@PutMapping("/modify-prix")
	@ResponseBody
	public void upPrix(){
		subscriptionService.updatePrix();
	}*/
	// http://localhost:8081/SpringMVC/servlet/modify-prix
		@PutMapping("/modify-prix")
		@ResponseBody
	public void modifyPrix() {
 	subscriptionService.updatePrix();
	
	}
}
