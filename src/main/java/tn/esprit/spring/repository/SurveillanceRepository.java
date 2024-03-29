package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Surveillance;
import tn.esprit.spring.entity.User;
@Repository
public interface SurveillanceRepository extends CrudRepository<Surveillance,Long> {
	@Query("SELECT f FROM Surveillance f WHERE f.id=:id and f.code=:code")
	public Surveillance getSubByIdAndCode(@Param("id")Long id, @Param("code")String code);
	@Query("SELECT f FROM Surveillance f WHERE f.id=:id ")
	public List<Surveillance> getSubById(@Param("id")Long id);
	@Query("SELECT f FROM Surveillance f WHERE f.user=:user ")
	public List<Surveillance> getSubByUser(@Param("user")User user);
	@Query("SELECT f FROM Surveillance f WHERE f.id=:id ")
	public Surveillance getSubById1(@Param("id")Long id);
	
}
