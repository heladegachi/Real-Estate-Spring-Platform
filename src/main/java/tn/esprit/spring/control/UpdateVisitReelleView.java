package tn.esprit.spring.control;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;

import tn.esprit.spring.entity.VisitReelleEntity;
import tn.esprit.spring.service.VisiteReelleService;

@Named
@ViewScoped
public class UpdateVisitReelleView {
	private VisitReelleEntity visitReelle;
    
    @Inject
    private VisiteReelleService service;
    
    private Integer id;
    
    private boolean skip;
     
    @PostConstruct
    public void init() {
    	//visitReelles = service.retrieveAllvisitReelles();
    	
    }
    
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
 
    public VisitReelleEntity getVisitReelle() {
        return visitReelle;
    }
 
    public void setService(VisiteReelleService service) {
        this.service = service;
    }
    
    public void update() {        
    	service.updateVisitReelle(visitReelle);
    }
    
    public void loadVistReelle(int id) {
    	visitReelle = service.retrieveVisitReelle(Long.valueOf(id));
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
    
    public void onDateSelect(SelectEvent event) {
       
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        visitReelle.setDate(format.format(event.getObject()));
    }
}
