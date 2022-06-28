package com.marioacosta.api.accenture.album.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.marioacosta.api.accenture.album.model.entities.Photo;

public interface PhotoRepository extends CrudRepository<Photo, Long>{
	
	@Query("SELECT a FROM Photo a WHERE a.album.user.id = :iduser")
	List<Photo> photosByUser(@Param("iduser") Long iduser);
	
	
	
	
	

}
