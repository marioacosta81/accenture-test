package com.marioacosta.api.accenture.album.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;
import com.marioacosta.api.accenture.album.services.AlbumService;
import com.marioacosta.api.accenture.album.services.CommentService;
import com.marioacosta.api.accenture.album.services.PhotoService;
import com.marioacosta.api.accenture.album.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("placeholder-queries")
@Slf4j
public class PlaceholderQueriesController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private CommentService commentService;

	
	//getUsers
	@GetMapping("/get-users")
	public ResponseEntity<?> getUsers() {
		try {
			log.info( "get all users");
			return ResponseEntity.ok().body(userService.getUsersAll());
		} catch (AlbumServiceExceptions e) {
			log.error(e.getMessage());
			return ResponseEntity.internalServerError().body(e.getMessage());
		}

	}
	
	
	//getPhotos
	@GetMapping("/get-photos")
	public ResponseEntity<?> getPhotos() {
		try {
			log.info( "get all photos");
			return ResponseEntity.ok().body(photoService.getPhotosAll());
		} catch (AlbumServiceExceptions e) {
			log.error(e.getMessage());
			return ResponseEntity.internalServerError().body(e.getMessage());
		}

	}
	
	//getPhotoByUser
	@GetMapping("/get-photos-by-user/{iduser}")
	public ResponseEntity<?> getPhotosByUser(@PathVariable  Long iduser) {
		try {
			log.info( "get photos by user");
			return ResponseEntity.ok().body(photoService.getPhotosByUser(iduser));
		} catch (AlbumServiceExceptions e) {
			log.error(e.getMessage());
			return ResponseEntity.internalServerError().body(e.getMessage());
		}

	}
	
	
	//getAlbums
	@GetMapping("/get-albums")
	public ResponseEntity<?> getAlbums() {
		try {
			log.info( "get all albums");
			return ResponseEntity.ok().body(albumService.getAlbumsAll()   );
		} catch (AlbumServiceExceptions e) {
			log.error(e.getMessage());
			return ResponseEntity.internalServerError().body(e.getMessage());
		}

	}
	
	
	//getAlbumsByUser
	@GetMapping("/get-album-by-user/{iduser}")
	public ResponseEntity<?> getAlbumsByUser(@PathVariable Long iduser ) {
		try {
			log.info( "get album by user");
			return ResponseEntity.ok().body(albumService.getAlbumsByUser(iduser)   );
		} catch (AlbumServiceExceptions e) {
			log.error(e.getMessage());
			return ResponseEntity.internalServerError().body(e.getMessage());
		}

	}
	
	
	
	
	//getCommentsByName
	@GetMapping("/get-comments-by-name")
	public ResponseEntity<?> getCommentsByName(@RequestParam String name ) {
		try {
			log.info( "get comments by name");
			return ResponseEntity.ok().body(  commentService.getCommentsByName(name)  );
		} catch (AlbumServiceExceptions e) {
			log.error(e.getMessage());
			return ResponseEntity.internalServerError().body(e.getMessage());
		}

	}
	
	//getCommentsByUser 
	@GetMapping("/get-comments-by-user/{iduser}")
	public ResponseEntity<?> getCommentsByUser(@PathVariable Long iduser ) {
		try {
			log.info( "get comments by user");
			return ResponseEntity.ok().body(     commentService.getCommentsByUser(iduser)   );
		} catch (AlbumServiceExceptions e) {
			log.error(e.getMessage());
			return ResponseEntity.internalServerError().body(e.getMessage());
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
