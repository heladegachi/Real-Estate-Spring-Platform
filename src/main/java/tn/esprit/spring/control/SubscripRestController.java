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

import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.SubscripServiceImpl;
import tn.esprit.spring.service.UserServiceImpl;

@RestController
public class SubscripRestController {
	@Autowired
	SubscripServiceImpl subscriptionService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-subscriptions
	@GetMapping("/retrieve-all-subscriptions")
	@ResponseBody
	public List<Subscription> getSubscription() {
	List<Subscription> list= subscriptionService.retrieveAllSubscription();
	return list;
}
	// http://localhost:8081/SpringMVC/servlet/retrieve-subscription/{subscription-id}
	@GetMapping("/retrieve-subscription/{subscription-id}")
	@ResponseBody
	public Subscription retrieveSubscription(@PathVariable("subscription-id") String subscriptionId) {
	return subscriptionService.retrieveSubscription(subscriptionId);}
	
	// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-subscription
	@PostMapping("/add-subscription")
	@ResponseBody
	public Subscription addSubscription(@RequestBody Subscription s) {
	Subscription subscription= subscriptionService.addSubscription(s);
	return subscription;
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
}
