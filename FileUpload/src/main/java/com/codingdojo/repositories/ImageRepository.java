package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.codingdojo.models.Image;

public interface ImageRepository extends Repository<Image, Long>{
	Image save( Image image );
	List<Image> findAll();
	
	@Modifying
	@Query(value = "DELETE FROM images WHERE image_id = ?1", nativeQuery=true )
	int deleteById(Long imageId);
	
}
