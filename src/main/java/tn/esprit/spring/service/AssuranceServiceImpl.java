package tn.esprit.spring.service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Assurance;
import tn.esprit.spring.entity.Surveillance;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.AssuranceRepository;

@Service
public class AssuranceServiceImpl implements AssuranceService {
	@Autowired
	AssuranceRepository assuranceRepository;
	Assurance assurance;
	@Override
	public Assurance authenticate(Long id, String code) {
	return assuranceRepository.getSubByIdAndCode(id, code);}
	
	public Long addOrUpdateAssurance(Assurance assurance) {
		
		//surveillance.setPrix(null);
		assuranceRepository.save(assurance);
	return assurance.getId();
	}
	@Override
	 public	void updatePrix(){
			//Subscription subscription=new Subscription();
			List<Assurance> list=(List<Assurance>)assuranceRepository.findAll();
			System.out.println("list.size()"+list.size());
		//List<Subscription> list =retrieveAllSubscription();
			for(Assurance subs :list){
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
			
				    assuranceRepository.save(subs);
			  /*   } catch (Exception e) {
				         e.printStackTrace();
				     }*/
				   
		}}
	@Override
	public List<Assurance> afficherassurconnecté(Long id) {
	return assuranceRepository.getSubById(id);}
	@Override
	public List<Assurance> affichersurveil(User user) {
	return (List<Assurance>) assuranceRepository.getSubByUser(user);}
	@Override
	public void deleteSurv(String id) {
		assuranceRepository.deleteById(Long.parseLong(id));
		
	}
}
