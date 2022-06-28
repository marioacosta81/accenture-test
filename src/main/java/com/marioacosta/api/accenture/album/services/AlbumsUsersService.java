package com.marioacosta.api.accenture.album.services;

import com.marioacosta.api.accenture.album.model.dtos.AlbumsUsersDto;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;

public interface AlbumsUsersService {
	
	AlbumsUsersDto saveAlbumsUsersDto(AlbumsUsersDto albumDto) throws AlbumServiceExceptions;

}
