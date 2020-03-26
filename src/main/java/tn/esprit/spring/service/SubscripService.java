package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Subscription;

public interface SubscripService {
	List<Subscription> retrieveAllSubscription();
	Subscription addSubscription(Subscription s);
	void deleteSubscription(String id);
	Subscription updateSubscription(Subscription s);
	Subscription retrieveSubscription(String id);
}
