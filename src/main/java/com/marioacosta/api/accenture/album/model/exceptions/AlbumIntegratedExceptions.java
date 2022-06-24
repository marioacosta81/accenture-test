package com.marioacosta.api.accenture.album.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class AlbumIntegratedExceptions extends HttpClientErrorException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlbumIntegratedExceptions(HttpStatus statusCode, String statusText) {
		super(statusCode, statusText);
	}

}
