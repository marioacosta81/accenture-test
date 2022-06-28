package com.marioacosta.api.accenture.album.services;

import java.util.List;

import com.marioacosta.api.accenture.album.model.dtos.PhotoDto;
import com.marioacosta.api.accenture.album.model.entities.Photo;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;

public interface PhotoService {
	
	Photo savePhotoDto(PhotoDto photoDto) throws AlbumServiceExceptions;
	
	List<Photo> saveListPhotoDto(List<PhotoDto> listPhotoDto) throws AlbumServiceExceptions;
	
	List<PhotoDto> getPhotosAll() throws AlbumServiceExceptions;
	
	List<PhotoDto> getPhotosByUser(Long iduser)throws AlbumServiceExceptions;

}
