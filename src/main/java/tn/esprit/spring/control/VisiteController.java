package tn.esprit.spring.control;



import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.VisitReelleEntity;
import tn.esprit.spring.entity.VisiteVirtuelleEntity;
import tn.esprit.spring.service.VisiteReelleServiceImpl;
import tn.esprit.spring.service.VisiteVirtuelleServiceImpl;

@Scope(value = "session")
@Controller(value ="VisiteController")
@ELBeanName(value = "VisiteController")
public class VisiteController {
	@Autowired 
	VisiteReelleServiceImpl VisiteReelleService; 
	@Autowired 
	VisiteVirtuelleServiceImpl VisiteVirtuelleService; 
	
	public void addVisiteReelle(VisitReelleEntity v) {
		VisiteReelleService.addVisitReelle(v);
		//return "/pages/user/VisiteReelleClientListe.xhtml?faces-redirect=true";
	}
	
	public void updateVisiteReelle(VisitReelleEntity v) {
		VisiteReelleService.updateVisitReelle(v);
	}
	public void addVisiteVirtuelle(VisiteVirtuelleEntity V1) {
		VisiteVirtuelleService.addVisiteVirtuelle(V1);
}
}
