package com.marioacosta.api.accenture.album.services;

import java.util.List;

import com.marioacosta.api.accenture.album.model.dtos.AlbumDto;
import com.marioacosta.api.accenture.album.model.entities.Album;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;

public interface AlbumService {
	
	Album saveAlbumDto(AlbumDto albumDto) throws AlbumServiceExceptions;
	
	List<Album> saveListAlbumDto(List<AlbumDto> listAlbumDto) throws AlbumServiceExceptions;
	
	List<AlbumDto> getAlbumsAll() throws AlbumServiceExceptions;
	
	List<AlbumDto> getAlbumsByUser(Long iduser) throws AlbumServiceExceptions;

}
