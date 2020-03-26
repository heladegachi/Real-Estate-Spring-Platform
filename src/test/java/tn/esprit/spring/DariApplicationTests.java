package tn.esprit.spring;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.State;
import tn.esprit.spring.service.AnnServiceImpl;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.entity.Type;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.UserSerivce;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DariApplicationTests {
	@Autowired
	UserSerivce us;
	@Autowired
	AnnServiceImpl as;
	
	/*
	 @Test
	void contextLoads() {
		us.retrieveAllUsers();
		
	}
	*/
	
	@Test
	public void contextLoads1() {
		Annonce u = new Annonce("Ann20",new Date(),State.sold);
	//	as.addAnnonce(u);
	//	as.retrieveAllAnnonces();
	//	as.deleteAnnonce("2");
		as.retrieveAnnonce("4");
		
	}
	
}
