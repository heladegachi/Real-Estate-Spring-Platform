package tn.esprit.spring;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.control.AnnonceController;
import tn.esprit.spring.control.AnnonceReviewController;
import tn.esprit.spring.control.UserController;
import tn.esprit.spring.entity.Action;
import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.State;
import tn.esprit.spring.entity.Type;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.AnnonceReviewRepository;
import tn.esprit.spring.service.AnnReviewService;
import tn.esprit.spring.service.AnnServiceImpl;
import tn.esprit.spring.service.NotificationServiceImpl;
import tn.esprit.spring.service.SubscripService;
import tn.esprit.spring.service.UserSerivce;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DariApplicationTests {
	@Autowired
	UserSerivce us;
	@Autowired
	AnnServiceImpl as;
	@Autowired
	AnnonceController anc;
	@Autowired
	AnnReviewService ars;
	@Autowired
	UserController uc;
	@Autowired
	AnnonceReviewController arc;
	@Autowired
	NotificationServiceImpl notser;
	@Autowired
	AnnonceReviewRepository arr;
	@Autowired
	SubscripService subsser;
	

	
	
	
	 @Test
	public void contextLoads() {
		 User u = new User ("hela","deg","hela@gmail.com","hela",Type.Admin);
		 User u2 = new User("user","simple","user@gmail.com","user",Type.SimpleUser);
		 User u3 = new User("user2","simple","user2@gmail.com","user2",Type.SimpleUser);
		 Notification not = new Notification( "okay", new Date() , Action.Added, false);
		 
		 
		 //subsser.changePriceJPQL(22000, (long) 2);
		 //notser.save(not);
		 //ars.getAllReviewsByAnnonce(24);
		 //arr.deleteAnnonceReview(79);
		 //arc.deleteAnnonceReviewById(86);
		 //ars.deleteAnnonceReview(9);
		//us.addUser(u2);
		//us.addUser(u);
		 //us.getAllUsers();
		 //us.retrieveAllUsers();
		 //uc.ajouterUser(u3);
		 //uc.displayUser(u2);
		 //ars.retrieveAllAnnonceReviews();
		 //annonceRevController.getAnnonceReviews();
		
	}
	
	
	@Test
	public void contextLoads3() {
		Annonce u = new Annonce("Ann2220",new Date(),State.sold);
		Annonce u2 = new Annonce("Annonce",new Date(),State.sold);
	//	as.addAnnonce(u);
	//	as.addAnnonce(u2);
	//	as.retrieveAllAnnonces();
	//	as.deleteAnnonce("3");
	//	as.retrieveAnnonce("4");
		
	}
	
	
	@Test
	public void contextLoads2() {
		
	//	AnnonceReview u = new AnnonceReview ("annonce22 review",new Date() );
	//	ars.addAnnonceReview(u);
	//	ars.retrieveAllAnnonceReviews();
	//	ars.deleteAnnonceReview(10);
	//	anc.deleteReviewById(10);
	//	ars.retrieveAnnonce("4");
		
	}
	
}
