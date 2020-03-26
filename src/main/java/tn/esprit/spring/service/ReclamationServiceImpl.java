package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reclamation;

import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl {
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
}
