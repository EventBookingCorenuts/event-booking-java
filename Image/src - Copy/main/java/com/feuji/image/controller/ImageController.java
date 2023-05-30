package com.feuji.image.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.feuji.image.service.ImageService;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {
@Autowired
	private ImageService service;
	
@PostMapping(path="/post")
	
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile image) throws IOException{
		String uploadImage=service.insertImage(image);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
		
	}
@GetMapping("/get/{fileName}")
public ResponseEntity<?> downloadImage(@PathVariable String fileName){
	byte[] imageData=service.downloadImage(fileName);
	return ResponseEntity.status(HttpStatus.OK)
			.contentType(MediaType.valueOf("image/png"))
			.body(imageData);
	}



	
}
