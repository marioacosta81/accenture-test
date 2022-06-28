package com.marioacosta.api.accenture.album.services;

import java.util.List;

import com.marioacosta.api.accenture.album.model.dtos.UserDto;
import com.marioacosta.api.accenture.album.model.entities.User;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;

public interface UserService {
	
	User saveUserDto(UserDto userDto) throws AlbumServiceExceptions;
	
	List<User> saveListUserDto(List<UserDto> listUserDto) throws AlbumServiceExceptions;

}
