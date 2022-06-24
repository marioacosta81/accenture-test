package com.marioacosta.api.accenture.album.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marioacosta.api.accenture.album.integrations.PlaceHolder;
import com.marioacosta.api.accenture.album.model.entities.Album;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumIntegratedExceptions;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("album")
@Slf4j
public class AlbumController {

	@Autowired
	PlaceHolder placeHolder;

	@GetMapping("/find-all")
	public ResponseEntity<?> listAlbum() {
		try {
			List<Album> list = placeHolder.listAlbums();
			log.debug(list.toString());
			return ResponseEntity.ok(list);
		} catch (AlbumIntegratedExceptions e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getStatusText());
		}

	}

}
