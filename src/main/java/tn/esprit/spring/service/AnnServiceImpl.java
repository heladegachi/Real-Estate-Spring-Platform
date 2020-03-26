package tn.esprit.spring.service;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.service.*;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.*;

@Service
public class AnnServiceImpl {
	@Autowired
	AnnonceRepository annRepository;

	private static final Logger L=LogManager.getLogger(AnnServiceImpl.class);

	
	public List<Annonce> retrieveAllAnnonces() {
		List<Annonce> Annonces=(List<Annonce>) annRepository.findAll();
		for(Annonce annonce:Annonces){
		L.info("user +++ : "+ annonce);}
		return Annonces;
	}
	
	public Annonce addAnnonce(Annonce r){
		return annRepository.save(r);
		
	}
	
	public Annonce updateAnnonce(Annonce r){
		return annRepository.save(r);
		
	}

	
	public void deleteAnnonce(String id) {
		annRepository.deleteById(Long.parseLong(id));
		
	}
	
	public Annonce retrieveAnnonce(String id) {
		Annonce r;
		r=annRepository.findById(Long.parseLong(id)).orElse(null);
		return r;
		
	}


}

