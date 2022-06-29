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
@RequestMapping("read")
@Slf4j
public class ReadController {

	@Autowired
	private PlaceHolderService placeHolderService;

	@GetMapping("/readPlaceHolder")
	public ResponseEntity<?> readPlaceHolder() {
		try {
			placeHolderService.readPlaceHolder();
			log.info("readPlaceHolder OK. The reading was done correctly");
			return ResponseEntity.ok().body("the reading was done correctly");
		} catch (AlbumIntegratedExceptions e) {
			log.error(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getStatusText());
		}
	}
}
