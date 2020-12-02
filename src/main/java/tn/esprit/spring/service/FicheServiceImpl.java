package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Fiche;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.FicheRepository;

@Service
public class FicheServiceImpl implements FicheService {
	@Autowired
	FicheRepository ficheRepository;

	public FicheRepository getFicheRepository() {
		return ficheRepository;
	}

	public void setFicheRepository(FicheRepository ficheRepository) {
		this.ficheRepository = ficheRepository;
	}
	private static final Logger L=LogManager.getLogger(SubscripServiceImpl.class);

	
	public List<Fiche>retrieveAllFiche(){
		List<Fiche> fiches=(List<Fiche>) ficheRepository.findAll();
		for(Fiche subscription:fiches){
		L.info("user +++ : "+ subscription);}
		return fiches;
	}
	
	public Long addFiche(Fiche s){
		ficheRepository.save(s);
		return s.getId();
		
	}
	
	public Fiche updateFiche(Fiche s){
		return ficheRepository.save(s);
		
	}

	
	public void deleteFiche(String id) {
		ficheRepository.deleteById(Long.parseLong(id));
		
	}
	
	public Fiche retrieveFiche(String id) {
		Fiche s;
		s=ficheRepository.findById(Long.parseLong(id)).orElse(null);
		return s;
		
	}
	public int getNombretrueJPQL() {
		return ficheRepository.count1();
	}
	public int getNombrefalseJPQL() {
		return ficheRepository.count2();
	}
	public int getNombreamiJPQL() {
		return ficheRepository.count3();
	}
	public int getNombrefamilleJPQL() {
		return ficheRepository.count4();
	}
	public int getNombresitewebJPQL() {
		return ficheRepository.count5();
		
	}
	public int getNombrefacebookJPQL() {
		return ficheRepository.count6();
	}
	@Override
	public List<Fiche> affichersurveil(User user) {
	return (List<Fiche>) ficheRepository.getSubByUser(user);}
	@Override
	public void deleteSurv(String id) {
		ficheRepository.deleteById(Long.parseLong(id));
		
	}
}
