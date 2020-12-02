package tn.esprit.spring.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements ReclamationService {
	@Autowired
	ReclamationRepository reclamationRepository;

	private static final Logger L=LogManager.getLogger(SubscripServiceImpl.class);

	
	public List<Reclamation>retrieveAllReclamation(){
		List<Reclamation> Reclamations=(List<Reclamation>) reclamationRepository.findAll();
		for(Reclamation reclamation:Reclamations){
		L.info("user +++ : "+ reclamation);}
		return Reclamations;
	}
	
	public Reclamation addReclamation(Reclamation r){
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		r.setDate(date);
		System.out.println(format.format(date));
		return reclamationRepository.save(r);
		
	}
	
	public Reclamation updateReclamation(Reclamation r){
		return reclamationRepository.save(r);
		
	}

	
	public void deleteReclamation(String id) {
		reclamationRepository.deleteById(Long.parseLong(id));
		
	}
	
	public Reclamation retrieveReclamation(String id) {
		Reclamation r;
		r=reclamationRepository.findById(Long.parseLong(id)).orElse(null);
		return r;
		
	}
	@Override
	public List<Reclamation> affichersurveil(User user) {
	return (List<Reclamation>) reclamationRepository.getSubByUser(user);}
	@Override
	public void deleteSurv(String id) {
		reclamationRepository.deleteById(Long.parseLong(id));
		
	}
}
