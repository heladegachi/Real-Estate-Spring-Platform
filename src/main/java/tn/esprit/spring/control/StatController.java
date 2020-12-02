package tn.esprit.spring.control;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.service.FicheService;
import tn.esprit.spring.service.SurveillanceService;


@Controller(value = "statcontroller")
@ELBeanName(value = "statcontroller")
@Join(path= "/l2", to = "/surveillancelog.jsf")
public class StatController {
	 @Autowired
		FicheService ficheservice;
	public int getv1() {
		return ficheservice.getNombretrueJPQL();
	}
}
