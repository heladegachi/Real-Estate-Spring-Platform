package tn.esprit.spring.repository;

//import java.util.Date;
//import java.util.List;

//import org.springframework.data.domain.Page;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.VisitReelleEntity;

@Repository
public interface VisiteReelleRepo extends CrudRepository<VisitReelleEntity, Long>  {
	
	/*@Query("select u from VisiteReelleEntity u where u.datee > :x and u.datee < :y ")
	public List<VisitReelleEntity> chercherVisites (@Param("x")Date d1, @Param("y")Date d2 );
	*/

}
