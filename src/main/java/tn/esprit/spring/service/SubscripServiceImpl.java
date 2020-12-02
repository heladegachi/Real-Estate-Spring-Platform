package tn.esprit.spring.service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Assurance;
import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.entity.Surveillance;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.SubscriptionRepository;
@Service
public class SubscripServiceImpl implements SubscripService {
	@Autowired
	SubscriptionRepository subscriptionRepository;
	Subscription sub;

	private static final Logger L=LogManager.getLogger(SubscripServiceImpl.class);

	@Override
	public List<Subscription>retrieveAllSubscription(){
		return (List<Subscription>)subscriptionRepository.findAll();
		/*for(Subscription subscription:subscriptions){
		L.info("user +++ : "+ subscription);}
		return subscriptions;*/
	}
	@Override
	public Long addSubscription(Subscription s){
		
		// float r=1200;
//		 Subscription subscription=new Subscription();
	      // System.out.println("Nombre de jours entre les deux dates est: "+res);
	     //  String ch1="10-10-2020";
	    // int  yeard = Integer.parseInt(ch1.substring(6, 10));// la variable reçoit l'année
	    //  int  monthd = Integer.parseInt(ch1.substring(3, 5));// ... le mois
	    //  int  dayd = Integer.parseInt(ch1.substring(0, 2));// ... le jour
	   //   String ch2="15-10-2020";
		 //    int  yearf = Integer.parseInt(ch2.substring(6,10));// la variable reçoit l'année
		   //   int  monthf = Integer.parseInt(ch2.substring(3, 5));// ... le mois
		     // int  dayf = Integer.parseInt(ch2.substring(0, 2));// ... le jour
//    Date dateAvant= new GregorianCalendar(yeard,monthd,dayd).getTime();
	//    Date  dateApres=new GregorianCalendar(yearf,monthf,dayf).getTime();
	  // 	long d=dateApres.getTime()-dateAvant.getTime();
	   	//int nbreJour=(int)d/(60*60*24*1000);
	 //float  prix=r*nbreJour;
		
		subscriptionRepository.save(s);
		return s.getId();
		
	     
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
	@Override
	public Subscription retrieveSubscriptionL(Long id) {
		Subscription s;
		s=subscriptionRepository.findById(id).orElse(null);
		return s;
		
	}
	
	@Override
	public void changePriceJPQL(float prix, Long id) {
		subscriptionRepository.changePriceJPQL(prix, id);
	}
	
	 //public float calcul(){
	    // Subscription subscription=new Subscription();
	     //float prix=0;
	    // float r=1200;
		   
		      // System.out.println("Nombre de jours entre les deux dates est: "+res);
		     //  String ch1=subscription.getDateDebut().toString();
		    // int  yeard = Integer.parseInt(ch1.substring(6, 8));// la variable reçoit l'année
		    //  int  monthd = Integer.parseInt(ch1.substring(3, 5));// ... le mois
		    //  int  dayd = Integer.parseInt(ch1.substring(0, 2));// ... le jour
		     // String ch2=subscription.getDateFin().toString();
			  //   int  yearf = Integer.parseInt(ch2.substring(6, 8));// la variable reçoit l'année
			    //  int  monthf = Integer.parseInt(ch2.substring(3, 5));// ... le mois
			    //  int  dayf = Integer.parseInt(ch2.substring(0, 2));// ... le jour
	     //Date dateAvant= new GregorianCalendar(yeard,monthd,dayd).getTime();
		 //   Date  dateApres=new GregorianCalendar(yearf,monthf,dayf).getTime();
		   //	long d=dateApres.getTime()-dateAvant.getTime();
		   //	int nbreJour=(int)d/(60*60*24*1000);
		// float  prix=r*nbreJour;
			//return prix;
	//  }
@Override
 public	void updatePrix(){
		//Subscription subscription=new Subscription();
		List<Subscription> list=(List<Subscription>)subscriptionRepository.findAll();
		System.out.println("list.size()"+list.size());
	//List<Subscription> list =retrieveAllSubscription();
		for(Subscription subs :list){
			String datedeb=subs.getDateDebut().toString();
			
			String datef=subs.getDateFin().toString();
			int yeard=Integer.parseInt(datedeb.substring(0,4));
			
			int monthd=Integer.parseInt(datedeb.substring(5,7));
			int dayd=Integer.parseInt(datedeb.substring(8,10));
			int yearf=Integer.parseInt(datef.substring(0,4));
		//	System.out.println("aaaa"+yearf);
			int monthf=Integer.parseInt(datef.substring(5,7));
			
			int dayf=Integer.parseInt(datef.substring(8,10));
			
			 Date dateAvant= new GregorianCalendar(yeard,monthd,dayd).getTime();
			 System.out.println("aaaa"+dateAvant);
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    // try {
		    	 
		    	 /*String a=(Integer.toString((yeard-monthd-dayd)));
		    	 System.out.println("aaaa"+a);*/
		    	// Date dateAvant = sdf.parse(sub.getDateDebut().toString());
		    	
			//Date dateAvant = sdf.parse(Integer.toString((monthd-dayd-yeard)));
			// System.out.println("aaaa"+dateAvant);
			    Date  dateApres=new GregorianCalendar(yearf,monthf,dayf).getTime();
			// Date dateApres = sdf.parse(sub.getDateFin().toString());
			  	long d=dateApres.getTime()-dateAvant.getTime();
			   	int nbreJour=(int)d/(60*60*24*1000);
			   	float  prix=1200*nbreJour;
			    subs.setPrix(prix);
		
			  subscriptionRepository.save(subs);
		  /*   } catch (Exception e) {
			         e.printStackTrace();
			     }*/
			   
	}
			    
	
		
	}
	//public void updatePrix(){
		
	//	subscriptionRepository.update(sub.getDateFin(),sub.getDateDebut());
	//}
@Override
public Long addOrUpdateSubscription(Subscription subscription) {
	
	//surveillance.setPrix(null);
	subscriptionRepository.save(subscription);
return subscription.getId();
}
@Override
public Subscription authenticate(Long id, String code) {
return subscriptionRepository.getSubByIdAndCode(id, code);}
@Override
public List<Subscription> affichersurveil(User user) {
return (List<Subscription>) subscriptionRepository.getSubByUser(user);}
@Override
public void deleteSurv(String id) {
	subscriptionRepository.deleteById(Long.parseLong(id));
	
}
}
