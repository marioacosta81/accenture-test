package com.marioacosta.api.accenture.album.repositories;

import org.springframework.data.repository.CrudRepository;

import com.marioacosta.api.accenture.album.model.entities.AlbumsUsers;

public interface AlbumsUsersRepository extends CrudRepository<AlbumsUsers, Long>{
	
	//@Query("SELECT a FROM Album a WHERE a.user.id = :iduser")
	//List<Album> albumsByUser(@Param("iduser") Long iduser);

}
