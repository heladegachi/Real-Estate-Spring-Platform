package tn.esprit.spring.control;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.spring.entity.FileResponse;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.esprit.spring.entity.*;
import tn.esprit.spring.service.*;
@RestController
@Named
@RequestScoped
public class FileController {
	 private FileSystemStorageService storageService;

	
	 public FileController(FileSystemStorageService storageService) {
	        this.storageService = storageService;
	    }
	    @GetMapping("/")
	    public String listAllFiles(Model model) {

	        model.addAttribute("files", storageService.loadAll().map(
	                path -> ServletUriComponentsBuilder.fromCurrentContextPath()
	                        .path("/download/")
	                        .path(path.getFileName().toString())
	                        .toUriString())
	                .collect(Collectors.toList()));

	        return "listFiles";
	    }

	    @GetMapping("/download/{filename:.+}")
	    @ResponseBody
	    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

	        Resource resource = storageService.loadAsResource(filename);

	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION,
	                        "attachment; filename=\"" + resource.getFilename() + "\"")
	                .body(resource);
	    }

	    @PostMapping("/upload-file")
	    @ResponseBody
	    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {
	        String name = storageService.store(file);

	        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/download/")
	                .path(name)
	                .toUriString();

	        return new FileResponse(name, uri, file.getContentType(), file.getSize());
	    }

	    @PostMapping("/upload-multiple-files")
	    @ResponseBody
	    public List<FileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
	        return Arrays.stream(files)
	                .map(file -> uploadFile(file))
	                .collect(Collectors.toList());
	    }
}
