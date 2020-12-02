package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.entity.User;

public interface SubscripService {
	List<Subscription> retrieveAllSubscription();
	Long addSubscription(Subscription s);
	void deleteSubscription(String id);
	Subscription updateSubscription(Subscription s);
	Subscription retrieveSubscription(String id);
	//public float calcul();
	public void updatePrix();
	//public void updatePrix();
	public Subscription authenticate(Long id, String code);
	public Long addOrUpdateSubscription(Subscription subscription);
	public List<Subscription> affichersurveil(User user);
	public void deleteSurv(String id);
	Subscription retrieveSubscriptionL(Long id);
	void changePriceJPQL(float prix, Long id);
}
