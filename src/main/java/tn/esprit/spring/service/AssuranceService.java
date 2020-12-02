package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Assurance;
import tn.esprit.spring.entity.User;

public interface AssuranceService {
	public Assurance authenticate(Long id, String code);
	public Long addOrUpdateAssurance(Assurance assurance);
	public	void updatePrix();
	public List<Assurance> afficherassurconnecté(Long id);
	public List<Assurance> affichersurveil(User user);
	public void deleteSurv(String id);
}
