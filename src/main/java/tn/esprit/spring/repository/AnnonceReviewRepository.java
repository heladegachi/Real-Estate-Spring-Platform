package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.AnnonceReview;

@Repository
public interface AnnonceReviewRepository extends CrudRepository<AnnonceReview, Long> {
	
		//List<AnnonceReview> findByAdresse(String adresse);
		//List<AnnonceReview> findByType(String adresse);
		//Annonce findById(long l);
		//void deleteById(long l);
		void deleteAll();
		//List<AnnonceReview> findByState(String state);
//		@Query("SELECT (MAX(a.id), 0) FROM Annonce a")
//		Long getMaxId();
		
		@Modifying
		@Query("DELETE from AnnonceReview b where b.id=:id")
		void deleteAnnonceReview(@Param("id")long id);
		

}
