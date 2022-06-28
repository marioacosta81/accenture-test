package com.marioacosta.api.accenture.album.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.marioacosta.api.accenture.album.model.dtos.AlbumDto;
import com.marioacosta.api.accenture.album.model.entities.Album;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;
import com.marioacosta.api.accenture.album.model.mappers.MainMapper;
import com.marioacosta.api.accenture.album.repositories.AlbumRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlbumServiceImp implements AlbumService {
	
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private MainMapper mapper;
	
	public Album saveAlbumDto(AlbumDto albumDto) throws AlbumServiceExceptions{
		Album album = mapper.mapperAlbumDtoToAlbum(albumDto);
		log.info( String.format("mapper to album entity id: %d ok",album.getId()));
		try {
			log.info( String.format("to save album id: %d",album.getId()));
			return albumRepository.save(album);
		} catch (DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}
	}
	
	
	public List<Album> saveListAlbumDto(List<AlbumDto> listAlbumDto) throws AlbumServiceExceptions{
		try {
			
			List<Album> result = new ArrayList();
			listAlbumDto.forEach(dto -> result.add(saveAlbumDto(dto)));
			log.info("save list album ok. size: %d", result.size());
			return result;
			
		} catch (DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}
	}
	
	
	
	

}
