package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Fiche;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.User;

@Repository
public interface FicheRepository extends CrudRepository<Fiche,Long> {
	 
	@Query(nativeQuery = true, value ="select count(*) FROM fiche_de_satisfaction f  where f.question1=1")
    public int count1();
	@Query(nativeQuery = true, value ="select count(*) FROM fiche_de_satisfaction f where f.question1=0")
    public int count2();
	@Query(nativeQuery = true, value ="SELECT count(*) FROM fiche_de_satisfaction f where f.question2=\"friend\"")
    public int count3();
	@Query(nativeQuery = true, value ="select count(*) FROM fiche_de_satisfaction f where f.question2=\"family\"")
    public int count4();
	@Query(nativeQuery = true, value ="select count(*) FROM fiche_de_satisfaction f where f.question2=\"website\"")
    public int count5();
	@Query(nativeQuery = true, value ="select count(*) FROM fiche_de_satisfaction f where f.question2=\"facebook\"")
    public int count6();
	@Query("SELECT f FROM Fiche f WHERE f.user=:user ")
	public List<Fiche> getSubByUser(@Param("user")User user);
}
