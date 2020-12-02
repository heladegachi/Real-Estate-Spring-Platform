 package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Assurance;
import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.entity.Surveillance;
import tn.esprit.spring.entity.User;


@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,Long>  {
	 
   /*@Query(nativeQuery = true, value ="update Date_début FROM Abonnement_de_publication")
   public List<Subscription> datedebut();*/
	//@Query(nativeQuery = true, value ="select Date_fin FROM Abonnement_de_publication")
   //public List<Subscription> datefin();
	/*@Modifying
	@Query(nativeQuery=true,value= "update Subscription s set s.prix = (:Datefin-:Datedebut)*1200")
	public void update(@Param("Datefin") Date Datefin,@Param("Datedebut") Date Datedebut);*/
	@Query("SELECT f FROM Subscription f WHERE f.id=:id and f.code=:code")
	public Subscription getSubByIdAndCode(@Param("id")Long id, @Param("code")String code);
	@Query("SELECT f FROM Subscription f WHERE f.user=:user ")
	public List<Subscription> getSubByUser(@Param("user")User user);
	@Query("SELECT f FROM Subscription f WHERE f.id=:id ")
	public Subscription getSubById1(@Param("id")Long id);
	
    @Modifying
    @Transactional
    @Query("UPDATE Subscription e SET e.prix=:newprice where e.id=:id")
    public void changePriceJPQL( @Param("newprice")float prix, @Param("id")Long id);
}
