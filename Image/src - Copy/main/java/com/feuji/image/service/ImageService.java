package com.feuji.image.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.feuji.image.entity.Image;

import com.feuji.image.repository.ImageRepository;
import com.feuji.image.util.ImageUtils;

@Service
public class ImageService {
	@Autowired
	private ImageRepository imageRepository;
	public String insertImage(MultipartFile file) throws IOException {
	Image image=imageRepository.save(Image.builder()
			    .imageName(file.getOriginalFilename())
				.imageType(file.getContentType())
				.imagePath("http://localhost:8084/api/image/get/"+file.getOriginalFilename())
				.imageData(ImageUtils.compressImage(file.getBytes())).build());
		if(image!=null) {
		return "image uploaded" +file.getOriginalFilename();	
		}
		return null;
	}
	
	
	public byte[] downloadImage(String fileName){
        Optional<Image> dbImageData = imageRepository.findByImageName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
	public List<Image> getImage(){
		return imageRepository.findAll();
	}

}
