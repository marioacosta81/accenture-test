package com.marioacosta.api.accenture.album.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marioacosta.api.accenture.album.model.dtos.AlbumsUsersDto;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumIntegratedExceptions;
import com.marioacosta.api.accenture.album.services.AlbumsUsersService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("albums-users")
@Slf4j
public class AlbumsUsersController {

	@Autowired
	private AlbumsUsersService albumsUsersService;
	
	
	
	
	//insertAlbumForUserAndPermissions
	@PostMapping("/create")
	public ResponseEntity<?> createAlbumsUsers( @RequestBody AlbumsUsersDto albumsUsersDto) {
		try {
			log.info( "get all users");
			return ResponseEntity.ok().body( albumsUsersService.saveAlbumsUsersDto(albumsUsersDto));
		} catch (AlbumIntegratedExceptions e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getStatusText());
		}
		
		
		
	}
	
	//updatePermissionsUserAlbum
	@PutMapping("/set-permissions")
	public ResponseEntity<?> updateAlbumsUsers( @RequestBody AlbumsUsersDto albumsUsersDto) {
		try {
			log.info( "get all users");
			return ResponseEntity.ok().body( albumsUsersService.saveAlbumsUsersDto(albumsUsersDto));
		} catch (AlbumIntegratedExceptions e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getStatusText());
		}
		
		
		
	}
	/*
	//getUsersAlbumByPermissions
	@GetMapping("/get-users-by-album-read-permission/{idAlbum}")
	public ResponseEntity<?> getUsersByPermissionsAlbum(  @PathVariable Long idAlbum   ){
		try {
			log.info( "get all users");
			return ResponseEntity.ok().body( albumsUsersService.saveAlbumsUsersDto(albumsUsersDto));
		} catch (AlbumIntegratedExceptions e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getStatusText());
		}
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
