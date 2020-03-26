package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Subscription;
@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,Long> {

}
