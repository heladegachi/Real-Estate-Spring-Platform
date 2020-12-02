package tn.esprit.spring.control;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.VisiteVirtuelleEntity;
import tn.esprit.spring.service.VisiteVirtuelleServiceImpl;

@Scope(value = "session") 
@Controller(value = "VisiteVirtuelleController") 
@ELBeanName(value = "VisiteVirtuelleController") 


public class VisiteVirtuelleController {
	@Autowired 
	VisiteVirtuelleServiceImpl VisiteVirtuelleService; 
	
	
	
	private VisiteVirtuelleEntity userV = new VisiteVirtuelleEntity();
	   private boolean skip;


	public VisiteVirtuelleEntity getUserV() {
		return userV;
	}


	public void setUserV(VisiteVirtuelleEntity userV) {
		this.userV = userV;
	}
	
	
	public void save() {        
//        FacesMessage msg = new FacesMessage("Successful" );
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    	
        VisiteVirtuelleService.addVisiteVirtuelle(userV);
    }
	
	public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
	 public String onFlowProcess(FlowEvent event) {
	        if(skip) {
	            skip = false;   //reset in case user goes back
	            return "confirm";
	        }
	        else {
	            return event.getNewStep();
	        }
	    }
	
	

}
