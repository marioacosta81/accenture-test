package com.marioacosta.api.accenture.album.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.marioacosta.api.accenture.album.model.entities.AlbumsUsers;

public interface AlbumsUsersRepository extends CrudRepository<AlbumsUsers, Long>{
	
	@Query("SELECT a FROM AlbumsUsers a WHERE a.albumsUsersId.album.id = :idalbum and a.readPermission = true")
	List<AlbumsUsers> getUsersByAlbumRead(@Param("idalbum") Long idalbum);
	
	@Query("SELECT a FROM AlbumsUsers a WHERE a.albumsUsersId.album.id = :idalbum and a.writePermission = true")
	List<AlbumsUsers> getUsersByAlbumWrite(@Param("idalbum") Long idalbum);
	

}
