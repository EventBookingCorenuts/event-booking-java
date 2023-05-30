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
public class ImageService
{
	@Autowired
	private ImageRepository imageRepository;
	
	public Image insertImage(MultipartFile file) throws IOException 
	{
		return imageRepository.save(Image.builder()
			    .imageName(file.getOriginalFilename())
				.imageType(file.getContentType())
				.imageData(ImageUtils.compressImage(file.getBytes())).build());
	}
	
	public byte[] downloadImage(String fileName)
	{
        Optional<Image> dbImageData = imageRepository.findByImageName(fileName);
        return ImageUtils.decompressImage(dbImageData.get().getImageData());
    }
	
	public List<Image> getImage()
	{
		return imageRepository.findAll();
	}

	public Image getImage(int imageId) 
	{
		Optional<Image> dbImageData = imageRepository.findById((long)imageId);
		if(dbImageData.isPresent())
		{
			return dbImageData.get();
		}
        return null;
	}

}
