package tn.esprit.spring.service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.control.UserController;
import tn.esprit.spring.entity.Surveillance;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.SurveillanceRepository;

@Service
public class SurveillanceServiceImpl implements SurveillanceService {
	@Autowired
	SurveillanceRepository surveillanceRepository;
	
	Surveillance sur;
	UserController usercontroller;
	@Override
	public Surveillance authenticate(Long id, String code) {
	return surveillanceRepository.getSubByIdAndCode(id, code);}
	@Override
	public Long addOrUpdateSurveillance(Surveillance surveillance) {
		
		//surveillance.setPrix(null);
		surveillanceRepository.save(surveillance);
	return surveillance.getId();
	}
	@Override
	public List<Surveillance> affichersurveilconnecté(Long id) {
	return surveillanceRepository.getSubById(id);}
	
	@Override
	public List<Surveillance> affichersurveil(User user) {
	return (List<Surveillance>) surveillanceRepository.getSubByUser(user);}
	
	@Override
	 public	void updatePrix(){
			//Subscription subscription=new Subscription();
			List<Surveillance> list=(List<Surveillance>)surveillanceRepository.findAll();
			System.out.println("list.size()"+list.size());
		//List<Subscription> list =retrieveAllSubscription();
			for(Surveillance subs :list){
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
			
				    surveillanceRepository.save(subs);
			  /*   } catch (Exception e) {
				         e.printStackTrace();
				     }*/
				   
		}
}
	@Override
	public void deleteSurv(String id) {
		surveillanceRepository.deleteById(Long.parseLong(id));
		
	}
}