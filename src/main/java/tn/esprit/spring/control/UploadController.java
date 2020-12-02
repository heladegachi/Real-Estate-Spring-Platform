package tn.esprit.spring.control;




import javax.servlet.http.Part;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.service.AnnReviewService;
import tn.esprit.spring.service.AnnService;


@Scope(value = "session") 
@Controller(value = "uploadController") 
@ELBeanName(value = "uploadController") 
public class UploadController {

	
	private Part file;
	
	public Part getFile() {
		return file;
	}


	public void setFile(Part file) {
		this.file = file;
	}
    public void submit() {
    	System.out.println("ssssssssssssssssssssssssssssss");
       
    }
	
	


	

}