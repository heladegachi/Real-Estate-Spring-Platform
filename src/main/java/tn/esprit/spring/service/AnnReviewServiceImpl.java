package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.AnnonceReview;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.AnnonceReviewRepository;

@Service
public class AnnReviewServiceImpl implements AnnReviewService{

	@Autowired
	AnnonceReviewRepository annReviewRepository;
	@Autowired
	AnnonceRepository annRepository;

	private static final Logger L=LogManager.getLogger(AnnServiceImpl.class);

	
	public List<AnnonceReview> retrieveAllAnnonceReviews() {
		List<AnnonceReview> AnnonceReviews=(List<AnnonceReview>) annReviewRepository.findAll();
		for(AnnonceReview annonceRev:AnnonceReviews){
		L.info("user +++ : "+ annonceRev);}
		return AnnonceReviews;
	}
	
	
	
	public AnnonceReview addAnnonceReview(AnnonceReview r){
		return annReviewRepository.save(r);
		
	}
	
	public AnnonceReview updateAnnonceReview(AnnonceReview r){
		return annReviewRepository.save(r);
		
	}

	
	@Override
	public void deleteAnnonceReview(Long id) {
		annReviewRepository.deleteAnnonceReview(id);
		
	}

	
	public AnnonceReview retrieveAnnonceReview(long id) {
		AnnonceReview r;
		r=annReviewRepository.findById(id).orElse(null);
		return r;
		
	}
	
	
	@Transactional	
	public void affecterAnnRevAAnnonce(long annRevId, long annId) {
		Annonce annManagedEntity = annRepository.findById(annId).get();
		AnnonceReview annRevManagedEntity = annReviewRepository.findById(annRevId).get();

		if(annManagedEntity.getAnnonceReviews() == null){

			List<AnnonceReview> annonceReviews = new ArrayList<>();
			annonceReviews.add(annRevManagedEntity);
			annManagedEntity.setAnnonceReviews(annonceReviews);
		}else{

			annManagedEntity.getAnnonceReviews().add(annRevManagedEntity);

		}

	}

	
	
	@Override 
	  public List<AnnonceReview> getAllReviewsByAnnonce(long annonceid) {
	 
		Annonce annonceManagedEntity = annRepository.findById(annonceid).orElse(null);
		List<AnnonceReview> reviews = new ArrayList<>();
		for(AnnonceReview annRev : annonceManagedEntity.getAnnonceReviews()){
			reviews.add(annRev);
		}
		
		return reviews;
	}
	
	
	
}
