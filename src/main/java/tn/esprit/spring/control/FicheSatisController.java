package tn.esprit.spring.control;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Fiche;
import tn.esprit.spring.entity.Question2;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.FicheService;
@Scope(value = "session") 
@Controller(value = "FicheSatisController") 
@ELBeanName(value = "FicheSatisController") 
@Join(path = "/a", to = "/login.jsf")
public class FicheSatisController {
	private String question3; private String question4; private String question5;
	private boolean question1; private Question2 question2;
	private String question6; 
	private String question7;
	private String question8;
	private String proposition;
	public Question2[] getQuestions2() { return Question2.values(); }
	
	public Question2 getQuestion2() {
		return question2;
	}

	public FicheService getFicheservice() {
		return ficheservice;
	}
	public void setFicheservice(FicheService ficheservice) {
		this.ficheservice = ficheservice;
	}
	public UserController getUsercontroller() {
		return usercontroller;
	}
	public void setUsercontroller(UserController usercontroller) {
		this.usercontroller = usercontroller;
	}

	@Autowired
	FicheService ficheservice;
	@Autowired
	UserController usercontroller;
	public void addFiche() {
		User currentuser=usercontroller.getAuthenticatedUser();
		ficheservice.addFiche(new Fiche(question1, question2, question3, question4, question5, question6,question7,question8,proposition,currentuser));
		}
public int getNombretrueJPQL() {
		
		return ficheservice.getNombretrueJPQL();
	}
public int getNombrefalseJPQL() {
	
	return ficheservice.getNombrefalseJPQL();
}
public int getNombreamiJPQL() {
	
	return ficheservice.getNombreamiJPQL();
}
public int getNombrefamilleJPQL() {
	
	return ficheservice.getNombrefamilleJPQL();
}
public int getNombresitewebJPQL() {
	
	return ficheservice.getNombresitewebJPQL();
}
public int getNombrefacebookJPQL() {
	
	return ficheservice.getNombrefacebookJPQL();
}
	public String getQuestion3() {
		return question3;
	}
	public void setQuestion3(String question3) {
		this.question3 = question3;
	}
	public String getQuestion4() {
		return question4;
	}
	public void setQuestion4(String question4) {
		this.question4 = question4;
	}
	public String getQuestion5() {
		return question5;
	}
	public void setQuestion5(String question5) {
		this.question5 = question5;
	}
	public boolean getQuestion1() {
		return question1;
	}
	public void setQuestion1(boolean question1) {
		this.question1 = question1;
	}
	
	public void setQuestion2(Question2 question2) {
		this.question2 = question2;
	}
	public String getQuestion6() {
		return question6;
	}
	public void setQuestion6(String question6) {
		this.question6 = question6;
	}
	public String getQuestion7() {
		return question7;
	}
	public void setQuestion7(String question7) {
		this.question7 = question7;
	}
	public String getQuestion8() {
		return question8;
	}
	public void setQuestion8(String question8) {
		this.question8 = question8;
	}
	public String getProposition() {
		return proposition;
	}
	public void setProposition(String proposition) {
		this.proposition = proposition;
	}
	
	private List<Fiche> surveils;

	public List<Fiche> getSurveils() {
		User currentuser=usercontroller.getAuthenticatedUser();
		//System.out.println(currentuser);
		surveils= ficheservice.affichersurveil(currentuser);
		//System.out.println(surveillances);
		return surveils;
	}
	public void setSurveils(List<Fiche> surveils) {
		this.surveils = surveils;
	}
	public void removeSurv(String surveillanceId)
	{
		ficheservice.deleteSurv(surveillanceId);
	}
}
