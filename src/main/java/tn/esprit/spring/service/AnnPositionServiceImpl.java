package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.AnnoncePosition;
import tn.esprit.spring.entity.AnnonceReview;
import tn.esprit.spring.repository.AnnoncePositionRepository;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.AnnoncePositionRepository;

@Service
public class AnnPositionServiceImpl implements AnnPositionService{

	@Autowired
	AnnoncePositionRepository annPosRepository;
	@Autowired
	AnnonceRepository annRepository;

	private static final Logger L=LogManager.getLogger(AnnServiceImpl.class);

	@Override
	public List<AnnoncePosition> retrieveAllAnnoncePositions() {
		List<AnnoncePosition> AnnoncePositions=(List<AnnoncePosition>) annPosRepository.findAll();
		for(AnnoncePosition annoncePos:AnnoncePositions){
		L.info("user +++ : "+ annoncePos);}
		return AnnoncePositions;
	}
	
	
	@Override
	public AnnoncePosition addAnnoncePosition(AnnoncePosition r){
		return annPosRepository.save(r);
		
	}
	@Override
	public AnnoncePosition updateAnnoncePosition(AnnoncePosition r){
		return annPosRepository.save(r);
		
	}

	@Override
	public AnnoncePosition getAnnoncePosByAnnId(Long annonceId) {
		return annPosRepository.retrieveAnnPos(annonceId);
		
	}


	
	public AnnoncePosition retrieveAnnoncePosition(long id) {
		AnnoncePosition r;
		r=annPosRepository.findById(id).orElse(null);
		return r;
		
	}
	
	
	
	
	
	
	

}
