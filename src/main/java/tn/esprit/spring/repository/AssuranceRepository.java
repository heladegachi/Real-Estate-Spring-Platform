package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Assurance;
import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.entity.Surveillance;
import tn.esprit.spring.entity.User;

@Repository
public interface AssuranceRepository extends CrudRepository<Assurance,Long> {
	@Query("SELECT f FROM Assurance f WHERE f.id=:id and f.code=:code")
	public Assurance getSubByIdAndCode(@Param("id")Long id, @Param("code")String code);
	@Query("SELECT f FROM Assurance f WHERE f.id=:id ")
	public List<Assurance> getSubById(@Param("id")Long id);
	@Query("SELECT f FROM Assurance f WHERE f.user=:user ")
	public List<Assurance> getSubByUser(@Param("user")User user);
	@Query("SELECT f FROM Assurance f WHERE f.id=:id ")
	public Assurance getSubById1(@Param("id")Long id);
}
