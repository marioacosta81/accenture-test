package com.marioacosta.api.accenture.album.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.marioacosta.api.accenture.album.model.dtos.AlbumsUsersDto;
import com.marioacosta.api.accenture.album.model.dtos.UserDto;
import com.marioacosta.api.accenture.album.model.entities.AlbumsUsers;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;
import com.marioacosta.api.accenture.album.model.mappers.MainMapper;
import com.marioacosta.api.accenture.album.repositories.AlbumsUsersRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlbumsUsersServiceImp implements AlbumsUsersService {
	
	
	@Autowired
	private AlbumsUsersRepository albumsUsersRepository; 
	
	@Autowired
	private MainMapper mapper;
	
	public AlbumsUsersDto saveAlbumsUsersDto(AlbumsUsersDto albumDto) throws AlbumServiceExceptions{
		AlbumsUsers albumsUsers = mapper.mapperAlbumsUsersDtoToAlbumsUsers(albumDto);
		log.info( String.format("mapper to albumsUsers entity album: %d user: %d " , albumsUsers.getAlbumsUsersId().getAlbum().getId(),albumsUsers.getAlbumsUsersId().getUser().getId()    ));
		try {
			log.info( String.format("to save album: %d user: %d ", albumsUsers.getAlbumsUsersId().getAlbum().getId(),albumsUsers.getAlbumsUsersId().getUser().getId()    ));
			albumsUsers =  albumsUsersRepository.save(albumsUsers);
			return mapper.mapperAlbumsUsersToAlbumsUsersDto(albumsUsers);
			
		} catch (DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}
	}
	
	public List<UserDto> findUserAlbumsRead(Long albumId) throws AlbumServiceExceptions{
		List<UserDto> listUserDto = new ArrayList<>();
		log.info( String.format("findUserAlbumsRead album: %d" , albumId));
		log.info( "findUserAlbumsRead");
		try {
			
			List<AlbumsUsers> albumsUsers =  albumsUsersRepository.getUsersByAlbumRead(albumId); 
			
			albumsUsers.forEach(au -> listUserDto.add(  mapper.mapperUserToUserDto( au.getAlbumsUsersId().getUser())));
			
			return listUserDto;
			
		} catch (DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}
	}
	
	public List<UserDto> findUserAlbumsWrite(Long albumId) throws AlbumServiceExceptions{
		List<UserDto> listUserDto = new ArrayList<>();
		log.info( String.format("findUserAlbumsRead album: %d" , albumId));
		log.info( "findUserAlbumsRead");
		try {
			
			List<AlbumsUsers> albumsUsers =  albumsUsersRepository.getUsersByAlbumWrite(albumId); 
			
			albumsUsers.forEach(au -> listUserDto.add(  mapper.mapperUserToUserDto( au.getAlbumsUsersId().getUser())));
			
			return listUserDto;
			
		} catch (DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}
	}
	
	
	
	

}
