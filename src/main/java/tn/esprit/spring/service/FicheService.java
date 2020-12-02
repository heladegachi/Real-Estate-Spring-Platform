package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Fiche;
import tn.esprit.spring.entity.User;
public interface FicheService {
	List<Fiche> retrieveAllFiche();
	Long addFiche(Fiche f);
	void deleteFiche(String id);
	Fiche updateFiche(Fiche f);
	Fiche retrieveFiche(String id);
	public int getNombretrueJPQL();
	public int getNombrefalseJPQL();
	public int getNombreamiJPQL();
	public int getNombrefamilleJPQL();
	public int getNombresitewebJPQL();
	public int getNombrefacebookJPQL();
	public List<Fiche> affichersurveil(User user);
	public void deleteSurv(String id);
}
