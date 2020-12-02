package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.VisitReelleEntity;

public interface VisiteReelleService {
	//void create(VisitReelle visitReelle);
	/*public VisitReelle saveVisitReelle(VisitReelle visitReelle) ;
	
	public VisitReelle updateVisitReelle(VisitReelle visitReelle);
	
	public List<VisitReelle> findAllVisitReelles();
	
	public void deleteVisitReelle(Long id);*/
	
	List<VisitReelleEntity> retrieveAllvisitReelles();
	VisitReelleEntity addVisitReelle(VisitReelleEntity V);
	void deleteVisitReelle(Long id);
	VisitReelleEntity updateVisitReelle(VisitReelleEntity V);
	VisitReelleEntity retrieveVisitReelle(Long id);
	void run() throws Exception;
	
	
		
	}


