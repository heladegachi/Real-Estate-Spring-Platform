package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.*;

public interface AnnService {
	List<Annonce> retrieveAllAnnonces();
	Annonce addAnnonce(Annonce r);
	void deleteAnnonce(String id);
	Annonce updateAnnonce(Annonce r);
	Annonce retrieveAnnonce(String id);
}
