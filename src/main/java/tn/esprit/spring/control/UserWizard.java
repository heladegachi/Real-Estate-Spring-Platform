package tn.esprit.spring.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import tn.esprit.spring.entity.VisitReelleEntity;
import tn.esprit.spring.service.VisiteReelleServiceImpl;

@Named
@Scope(value = "session")
public class UserWizard implements Serializable{
	
	@Autowired 
	VisiteReelleServiceImpl VisiteReelleService; 
	
	private VisitReelleEntity userW = new VisitReelleEntity();
    
    private boolean skip;
     
//    public UserW get UserW() {
//        return user;
//    }
// 
//    public void setUser(User user) {
//        this.user = user;
//    }
    public VisitReelleEntity getUserW() {
		return userW;
	}



	public void setUserW(VisitReelleEntity userW) {
		this.userW = userW;
	}
     
    public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + userW.getFirstname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    	
        VisiteReelleService.addVisitReelle(userW);
    }
    
    
    /*public void update() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + userW.getFirstname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
   

    public void delete() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + userW.getFirstname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }*/
     
   



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
    
    public void onDateSelect(SelectEvent event) {
       
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        userW.setDate(format.format(event.getObject()));
    }

}
