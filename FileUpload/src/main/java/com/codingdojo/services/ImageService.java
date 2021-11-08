package com.codingdojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Image;
import com.codingdojo.repositories.ImageRepository;



@Service
public class ImageService {
	private final ImageRepository imageRepository;
	
	public ImageService( ImageRepository imageRepository ) {
		this.imageRepository = imageRepository;
	}
	
	public Image addImage( Image image ) {
		return imageRepository.save( image );
	}
	
	public List<Image> getAllImages(){
		return imageRepository.findAll();
	}
	
}
