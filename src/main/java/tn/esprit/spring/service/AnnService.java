package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.*;

public interface AnnService {
	List<Annonce> retrieveAllAnnonces();
	Annonce addAnnonce(Annonce r);
	void deleteAnnonce(String id);
	void deleteAnnonceL(long id);
	Annonce updateAnnonce(Annonce r);
	Annonce retrieveAnnonce(String id);
	Annonce retrieveAnnonceid(long id);
	
	
	public long ajouterAnnReview(AnnonceReview annRev);
	List<Annonce> getAllAnnonces();
	long addOrUpdateAnnonce(Annonce ann);
	Annonce ajoutAnnonce(Annonce r);
	List<AnnonceReview> getAllReviewsByAnnonce(long annonceid);
	void acceptAnnonceJPQL(Long annId);
	void denyAnnonceJPQL(Long annId);
	List<Annonce> retrieveBestReviewed();
	void changeRatingJPQL(Long annId, int rating);
	void paidAnnonceJPQL(Long annId);
	List<Annonce> retrieveHighestPrice(long userId);
	
}

