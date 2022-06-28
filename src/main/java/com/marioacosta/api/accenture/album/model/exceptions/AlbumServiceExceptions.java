package com.marioacosta.api.accenture.album.model.exceptions;

public class AlbumServiceExceptions extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public AlbumServiceExceptions(String message) {
		super(message);
	}
	
	public AlbumServiceExceptions(String message,Throwable cause) {
		super(message,cause);
	}

}
