package tn.esprit.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.SubscriptionRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class SubscripServiceImpl implements SubscripService {
	@Autowired
	SubscriptionRepository subscriptionRepository;

	private static final Logger L=LogManager.getLogger(SubscripServiceImpl.class);

	@Override
	public List<Subscription>retrieveAllSubscription(){
		List<Subscription> subscriptions=(List<Subscription>) subscriptionRepository.findAll();
		for(Subscription subscription:subscriptions){
		L.info("user +++ : "+ subscription);}
		return subscriptions;
	}
	@Override
	public Subscription addSubscription(Subscription s){
		s.setPrix(calcul() );
		return subscriptionRepository.save(s);
		
	}
	@Override
	public Subscription updateSubscription(Subscription s){
		return subscriptionRepository.save(s);
		
	}

	@Override
	public void deleteSubscription(String id) {
		subscriptionRepository.deleteById(Long.parseLong(id));
		
	}
	@Override
	public Subscription retrieveSubscription(String id) {
		Subscription s;
		s=subscriptionRepository.findById(Long.parseLong(id)).orElse(null);
		return s;
		
	}
	
	 public float calcul(){
	     Subscription subscription=new Subscription();
	     float prix=0;
	     float r=1200;
		   SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		     try {
		        Date dateAvant = sdf.parse(subscription.getDateDebut().toString());
		       Date dateApres = sdf.parse(subscription.getDateFin().toString());
		       long diff = dateApres.getTime() - dateAvant.getTime();
		       float res = (diff / (1000*60*60*24));
		       System.out.println("Nombre de jours entre les deux dates est: "+res);
		       prix=r*res;
		       
		     } catch (Exception e) {
		         e.printStackTrace();
		     }
			return prix;
		   }
}
