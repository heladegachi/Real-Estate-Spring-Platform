package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Reclamation;


public interface ReclamationService {
	List<Reclamation> retrieveAllReclamation();
	Reclamation addReclamation(Reclamation r);
	void deleteReclamation(String id);
	Reclamation updateReclamation(Reclamation r);
	Reclamation retrieveReclamation(String id);
}
