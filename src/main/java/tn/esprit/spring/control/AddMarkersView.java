package tn.esprit.spring.control;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.AnnoncePosition;
import tn.esprit.spring.service.AnnPositionService;
import tn.esprit.spring.service.AnnService;

@Scope(value = "session") 
@Controller(value = "markerSelectionView") 
@ELBeanName(value = "markerSelectionView") 
public class AddMarkersView implements Serializable {
	@Autowired 
	AnnPositionService annPosSer;
	@Autowired
	AnnService iannservice;

	
     
	  
    private MapModel simpleModel;
  
    private Marker marker;
 
    private double lat=0;
    private double lng=0;
    
    public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public void changelat(double latt, double lngg)
    {
    	 lat= latt ;
    	 lng = lngg;
    	
    }
  
    
  
    @PostConstruct
    public void init() {
    	simpleModel = new DefaultMapModel();
        
    	 changelat(lat,lng);
    	
    	
        //AnnoncePosition annpos = iannservice.retrieveAnnonceid(annid).getAnnoncePosition();
        //Shared coordinates
        //LatLng coord1 = new LatLng(36.861641, 10.167307);
        LatLng coord1 = new LatLng(lat, lng);
           
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "ff"));
    }
      
    public MapModel getSimpleModel() {
        return simpleModel;
    }
      
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
         
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
    }
      
    public Marker getMarker() {
        return marker;
    }
    
    
}