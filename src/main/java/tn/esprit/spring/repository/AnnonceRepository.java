package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	
    @Modifying
    @Transactional
    @Query("UPDATE Annonce e SET e.AdState='Accepted' where e.id=:annonceId")
    public void acceptAnnonceJPQL( @Param("annonceId")long annonceId);
    
    @Modifying
    @Transactional
    @Query("UPDATE Annonce e SET e.AdState='Paid' where e.id=:annonceId")
    public void paidAnnonceJPQL( @Param("annonceId")long annonceId);
    
    @Modifying
    @Transactional
    @Query("UPDATE Annonce e SET e.AdState='Denied' where e.id=:annonceId")
    public void denyAnnonceJPQL( @Param("annonceId")long annonceId);

	@Query("SELECT COUNT(u) FROM Annonce u WHERE u.AdState = 'Accepted' ")
	public int countAcceptedAds();
	
	@Query("SELECT COUNT(u) FROM Annonce u WHERE u.user.id=:userId ")
	public int countUserAds(@Param("userId")long userId);
	
	@Query("SELECT u FROM Annonce u WHERE u.AdState = 'Accepted'  ORDER BY u.rating Desc ")
	public List<Annonce> findBestReviewed();
	
	@Query("SELECT u FROM Annonce u WHERE u.user.id=:userId  ORDER BY u.price Desc ")
	public List<Annonce> findHighestPrice(@Param("userId")long userId);
	
    @Modifying
    @Transactional
    @Query("UPDATE Annonce e SET e.rating=:rating where e.id=:annonceId")
    public void changeRatingJPQL( @Param("annonceId")Long annonceId, @Param("rating")int rating);
	
    
}

