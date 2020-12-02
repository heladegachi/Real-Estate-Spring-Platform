package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Assurance;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.User;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation,Long> {
	@Query("SELECT f FROM Reclamation f WHERE f.user=:user ")
	public List<Reclamation> getSubByUser(@Param("user")User user);
}
