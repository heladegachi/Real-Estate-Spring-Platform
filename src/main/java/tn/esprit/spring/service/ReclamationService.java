package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.User;


public interface ReclamationService {
	List<Reclamation> retrieveAllReclamation();
	Reclamation addReclamation(Reclamation r);
	void deleteReclamation(String id);
	Reclamation updateReclamation(Reclamation r);
	Reclamation retrieveReclamation(String id);
	
	public List<Reclamation> affichersurveil(User user);
	public void deleteSurv(String id);
}
