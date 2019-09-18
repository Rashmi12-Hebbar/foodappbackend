package com.lucida.example.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucida.example.dtos.UploadFileResponse;
import com.lucida.example.entity.UploadFile;
import com.lucida.example.service.FileStorageService;

@RestController
public class Filecontroller {
	
	@Autowired
	    private FileStorageService fileStorageService;
	    
	    @PostMapping("/uploadFile/{uploadedby}")
	    public UploadFileResponse uploadFile(@PathVariable String uploadedby, @RequestParam("file") MultipartFile file) {
	        String fileName = fileStorageService.storeFile(file);

	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(fileName)
	                .toUriString();
	        System.out.println();
	        fileStorageService.uploadFile(file,uploadedby);
	        return new UploadFileResponse(fileName, fileDownloadUri,
	                file.getContentType(), file.getSize());
	    }
	    
	   
//	    
//	    @GetMapping("/downloadFile/{fileName}")
//	    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
//	        // Load file as Resource
//	        Resource resource = fileStorageService.loadFileAsResource(fileName);
//
//	        // Try to determine file's content type
//	        String contentType = null;
//	        try {
//	            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//	        } catch (IOException ex) {
//	        }
//
//	        // Fallback to the default content type if type could not be determined
//	        if(contentType == null) {
//	            contentType = "application/octet-stream";
//	        }
//
//	        return ResponseEntity.ok()
//	                .contentType(MediaType.parseMediaType(contentType))
//	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//	                .body(resource);
//	    }
	    
	    @GetMapping("/getFile/{filename}")
	    public List<UploadFile> getFile(@PathVariable String filename){
	    	
			return fileStorageService.findbyfilename(filename);

	    	
	    }
	}

