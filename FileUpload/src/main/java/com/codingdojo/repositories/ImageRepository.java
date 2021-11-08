package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.codingdojo.models.Image;

public interface ImageRepository extends Repository<Image, Long>{
	Image save( Image image );
	List<Image> findAll();
}
