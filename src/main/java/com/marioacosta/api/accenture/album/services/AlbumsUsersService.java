package com.marioacosta.api.accenture.album.services;

import java.util.List;

import com.marioacosta.api.accenture.album.model.dtos.AlbumsUsersDto;
import com.marioacosta.api.accenture.album.model.dtos.UserDto;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;

public interface AlbumsUsersService {
	
	AlbumsUsersDto saveAlbumsUsersDto(AlbumsUsersDto albumDto) throws AlbumServiceExceptions;
	
	List<UserDto> findUserAlbumsRead(Long albumId) throws AlbumServiceExceptions;
	
	List<UserDto> findUserAlbumsWrite(Long albumId) throws AlbumServiceExceptions;

}
