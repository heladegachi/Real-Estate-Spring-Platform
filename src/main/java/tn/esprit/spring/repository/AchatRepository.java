package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.*;
@Repository
public interface AchatRepository extends CrudRepository<Achat, Long>{
	
	List<Achat> findByDatedachat(Date Datedachat);
	Achat findById(long l);
	void deleteAll();
	  
	@Query(nativeQuery = true, value ="SELECT count(*) FROM achat a where a.payementmode=\"Paycash\"")
    public int count1();
	@Query(nativeQuery = true, value ="select count(*) FROM achat a where a.payementmode=\"Easy_payement\"")
    public int count2();
	
	
	@Query("SELECT Remarque FROM Achat")
	public List<String> achatRemarques();
	//@Query("SELECT (MAX(a.id), 0) FROM Achat a")
//Long getMaxId();
	
   
	
	
	
	
}
