package com.codingdojo;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
public class FileUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadApplication.class, args);
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    // Register resource handler for images
	    registry.addResourceHandler("/resources/**").addResourceLocations("/static/images")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}

}
