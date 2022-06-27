package com.marioacosta.api.accenture.album.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marioacosta.api.accenture.album.model.exceptions.AlbumIntegratedExceptions;
import com.marioacosta.api.accenture.album.services.PlaceHolderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("album")
@Slf4j
public class AlbumController {

	@Autowired
	private PlaceHolderService placeHolderService;

	@GetMapping("/find-all")
	public ResponseEntity<?> listAlbum() {
		try {
			placeHolderService.readPlaceHolder();
			log.info("OK");
			return ResponseEntity.ok("creado");
		} catch (AlbumIntegratedExceptions e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getStatusText());
		}

	}

}
