package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.AnnonceReview;

public interface AnnReviewService {
	List<AnnonceReview> retrieveAllAnnonceReviews();
	AnnonceReview addAnnonceReview(AnnonceReview r);
	void deleteAnnonceReview(long id);
	AnnonceReview updateAnnonceReview(AnnonceReview r);
	AnnonceReview retrieveAnnonceReview(long id);
	List<AnnonceReview> getAllReviewsByAnnonce(long annonceid);
	
	

}
