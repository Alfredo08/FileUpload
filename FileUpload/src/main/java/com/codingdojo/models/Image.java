package com.codingdojo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table( name = "images" )
public class Image {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long image_id;
	
	@NotNull
	private String image_path;
	
	public Image(){}
	
	public Image( String image_path ) {
		this.image_path = image_path;
	}

	public long getImage_id() {
		return image_id;
	}

	public void setImage_id(long image_id) {
		this.image_id = image_id;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	
}
