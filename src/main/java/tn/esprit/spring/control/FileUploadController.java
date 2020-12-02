package tn.esprit.spring.control;

 

   

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.service.AnnReviewService;
import tn.esprit.spring.service.AnnService;
import tn.esprit.spring.service.UserSerivce;



@Async
@Scope(value = "session")
@ELBeanName(value = "FileUploadController")
@RestController
@Join(path= "/uploadview", to = "/uploadview.jsf")
@Controller(value="FileUploadController")
public class FileUploadController  {
	
	@Autowired
	AnnService iannservice;
	@Autowired
	AnnReviewService iannRevservice;
	@Autowired 
	AnnonceRepository annRepo;

	
	//http://localhost:8081/SpringMVC/servlet/fileuploads
  public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
  @RequestMapping("/fileuploads")
  public String UploadPage(Model model) {
	  return "uploadview";
  }
  
  
  //http://localhost:8081/SpringMVC/servlet/upload
  @PostMapping("/upload")
  public String upload(Model model,@RequestParam("files") MultipartFile[] files) {
	  StringBuilder fileNames = new StringBuilder();
	  for (MultipartFile file : files) {
		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
		  fileNames.append(file.getOriginalFilename()+" ");
		
		  try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
		Annonce ann = iannservice.retrieveAnnonceid(5);
		//prod = annController.getAnnonceById(id);
		ann.setPicture(fileNames.toString());
		
	  model.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
	  return "uploadstatusview";
  }



	/* public String ajouterPicture() throws FileNotFoundException {
			FacesMessage facesMessage = new FacesMessage("consomi tounsi");
			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
			Product f1 = new Product(name, code, price, quantity_alert, expirationDate, category, Description);
			productService.addProduct(f1);
			f2 = f1;
			return "/uploadview.xhtml?faces-redirect=true";
	} */

}