package com.codingdojo.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.codingdojo.models.Image;
import com.codingdojo.services.ImageService;
import com.codingdojo.util.FileUploadUtil;


@Controller
public class ImageController {
	
	private final ImageService imageService;
	
	public ImageController( ImageService imageService ) {
		this.imageService = imageService;
	}
	
	@RequestMapping( value = "/images", method = RequestMethod.GET )
	public String displayImages( Model model ) {
		List<Image> images = imageService.getAllImages();
		model.addAttribute( "imageList", images );
		return "images.jsp";
	}
	
	@RequestMapping( value = "/images/new", method = RequestMethod.POST )
	public String addNewImage( @RequestParam("newImage") MultipartFile multipartFile) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        System.out.println(fileName);
		Image newImage = new Image( "/images/" + fileName );
        
		
        newImage = imageService.addImage(newImage);
        
        
        String fileLocation = new File("src/main/resources/static/images").getAbsolutePath();
                
        
        FileUploadUtil.saveFile(fileLocation, fileName, multipartFile);
        
        
        /*
        System.out.println(fileLocation);
        FileOutputStream output = new FileOutputStream(fileLocation);
		output.write(multipartFile.getBytes());
		output.close();
		*/
		
        
		return "redirect:/images";
	}
	
	@RequestMapping( value = "/images/delete", method = RequestMethod.DELETE )
	public String deleteImage( @RequestParam( "imageId" ) Long imageId, @RequestParam( "imageName" ) String imageName ) {
		imageService.deleteImageById(imageId);
		
		File currentImage = new File( new File("src/main/resources/static/images").getAbsoluteFile() + "/" + imageName );
		System.out.println( currentImage.getAbsolutePath() );
		currentImage.delete();
		
		return "redirect:/images";
	}

}
