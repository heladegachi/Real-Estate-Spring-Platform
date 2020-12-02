package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Surveillance;
import tn.esprit.spring.entity.User;

public interface SurveillanceService {
	public Surveillance authenticate(Long id, String code);
	public Long addOrUpdateSurveillance(Surveillance surveillance);
	public List<Surveillance> affichersurveilconnecté(Long id);
	public	void updatePrix();
	public List<Surveillance> affichersurveil(User user);
	public void deleteSurv(String id);
}
