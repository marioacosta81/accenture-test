package com.marioacosta.api.accenture.album.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.marioacosta.api.accenture.album.model.entities.Album;

public interface AlbumRepository extends CrudRepository<Album, Long>{
	
	@Query("SELECT a FROM Album a WHERE a.user.id = :iduser")
	List<Album> albumsByUser(@Param("iduser") Long iduser);

}
