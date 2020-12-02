package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.VisitReelleEntity;
import tn.esprit.spring.entity.VisiteVirtuelleEntity;
import tn.esprit.spring.service.VisiteReelleServiceImpl;
import tn.esprit.spring.service.VisiteVirtuelleServiceImpl;

@RestController

public class VisiteVirtuelleRestController {
	

	 @Autowired 
	 VisiteVirtuelleServiceImpl VisiteVirtuelleService; 
	 
	 
	 // http://localhost:8081/SpringMVC/servlet/retrieve-all-visitesV
	 @GetMapping("/retrieve-all-visitesV") 
	 @ResponseBody 
	 public List<VisiteVirtuelleEntity> getVisiteVirtuelle() { 
		 return VisiteVirtuelleService.retrieveAllVisitesVirtuelles(); 
		 } 
	 
	 
	// http://localhost:8081/SpringMVC/servlet/retrieve-VisV/{visiteV-id} 
			 @GetMapping("/retrieve-VisV/{visiteV-id}") 
			 @ResponseBody 
			 public VisiteVirtuelleEntity retrieveVisiteVirtuelle(@PathVariable("visiteV-id") Long visiteVId) { 
				 return VisiteVirtuelleService.retrieveVisiteVirtuelle(visiteVId); 
				 } 
			 
			 //  http://localhost:8081/SpringMVC/servlet/add-VisV 
			 @PostMapping("/add-VisV") 
			 @ResponseBody 
			 public VisiteVirtuelleEntity addVisiteVirtuelle(@RequestBody VisiteVirtuelleEntity V1) { 
				 return VisiteVirtuelleService.addVisiteVirtuelle(V1); 
				   
			 }
			 
			 
			// http://localhost:8081/SpringMVC/servlet/remove-VisV/{VisiteV-id}
				@DeleteMapping("/remove-VisV/{VisiteV-id}")
				@ResponseBody
				public void removeUser(@PathVariable("VisiteV-id") Long visiteVIRTUELLEId) {
					VisiteVirtuelleService.deleteVisiteVirtuelle(visiteVIRTUELLEId);
					
				}
				
				
				// http://localhost:8081/SpringMVC/servlet/modify-visiteVIRTUELLE
				@PutMapping("/modify-visiteVIRTUELLE")
				@ResponseBody
				public VisiteVirtuelleEntity modifyvisiteVIRTUELLE(@RequestBody VisiteVirtuelleEntity VisiteVirtuelle) {
				return VisiteVirtuelleService.updateVisiteVirtuelle(VisiteVirtuelle );
				}


}
