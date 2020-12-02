package tn.esprit.spring.control;

import java.util.Date;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Surveillance;
import tn.esprit.spring.service.SurveillanceService;


@Scope(value = "session")
@Controller(value = "affichageController")
@ELBeanName(value = "affichageController")
@Join(path= "/l2", to = "/surveillancelog.jsf")
public class AffichageController {
	@Autowired
	SurveillanceController surveillance1;
	private Surveillance surveil;
	@Autowired
	SurveillanceService surveillanceservice;
	private Date datedeb;
	private Date datefin;
	private Long nombrecamera;
	private Long id; private String code; private Surveillance surveillance;
	
	public SurveillanceService getSurveillanceservice() {
		return surveillanceservice;
	}

	public void setSurveillanceservice(SurveillanceService surveillanceservice) {
		this.surveillanceservice = surveillanceservice;
	}

	public Surveillance getSurveil() {
		return surveil;
	}

	public void setSurveil(Surveillance surveil) {
		this.surveil = surveil;
	}

	
public SurveillanceController getSurveillance1() {
		return surveillance1;
	}

	public void setSurveillance1(SurveillanceController surveillance1) {
		this.surveillance1 = surveillance1;
	}

	public Date getDatedeb() {
		return datedeb;
	}

	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public Long getNombrecamera() {
		return nombrecamera;
	}

	public void setNombrecamera(Long nombrecamera) {
		this.nombrecamera = nombrecamera;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Surveillance getSurveillance() {
		return surveillance;
	}

	public void setSurveillance(Surveillance surveillance) {
		this.surveillance = surveillance;
	}
	
	
	

/*public Surveillance getSurveillanceconnecté() {
	Surveillance currentsurveillance=surveillance1.getAuthenticatedSurveillance();
	System.out.println(currentsurveillance);
		Long idconnecté=currentsurveillance.getId();
		surveil= surveillanceservice.affichersurveilconnecté(idconnecté);
		System.out.println(surveil);
		return surveil;
		}*/
	
}
