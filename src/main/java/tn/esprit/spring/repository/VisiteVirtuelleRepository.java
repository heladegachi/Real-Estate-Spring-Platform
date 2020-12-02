package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
/*import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;*/
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.VisiteVirtuelleEntity;

@Repository

public interface VisiteVirtuelleRepository extends CrudRepository<VisiteVirtuelleEntity, Long>{
	
	/*List<VisiteVirtuelleEntity> findAllByPublicationDate(Date publicationDate);
	 
    List<VisiteVirtuelleEntity> findAllByPublicationTimeBetween(
      Date publicationTimeStart,
      Date publicationTimeEnd);
 
    @Query("select a from Article a where a.creationDateTime <= :creationDateTime")
    List<VisiteVirtuelleEntity> findAllWithCreationDateTimeBefore(
      @Param("creationDateTime") Date creationDateTime);
 */

}
