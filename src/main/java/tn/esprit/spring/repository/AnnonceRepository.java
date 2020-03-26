package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.*;
@Repository
public interface AnnonceRepository extends CrudRepository<Annonce, Long> {
	List<Annonce> findByAdresse(String adresse);
	List<Annonce> findByType(String adresse);
	//Annonce findById(long l);
	//void deleteById(long l);
	void deleteAll();
	List<Annonce> findByState(String state);
//	@Query("SELECT (MAX(a.id), 0) FROM Annonce a")
//	Long getMaxId();
}

