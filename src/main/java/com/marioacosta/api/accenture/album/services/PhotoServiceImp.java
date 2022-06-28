package com.marioacosta.api.accenture.album.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.marioacosta.api.accenture.album.model.dtos.PhotoDto;
import com.marioacosta.api.accenture.album.model.entities.Photo;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;
import com.marioacosta.api.accenture.album.model.mappers.MainMapper;
import com.marioacosta.api.accenture.album.repositories.PhotoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PhotoServiceImp implements PhotoService {
	
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private MainMapper mapper;
	
	public Photo savePhotoDto(PhotoDto photoDto) throws AlbumServiceExceptions{
		Photo photo = mapper.mapperPhotoDtoToPhoto(photoDto);
		log.info( String.format("mapper to photo entity id: %d ok",photo.getId()));
		try {
			log.info( String.format("to save photo id: %d",photo.getId()));
			return photoRepository.save(photo);
		} catch (DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}
	}
	
	
	public List<Photo> saveListPhotoDto(List<PhotoDto> listPhotoDto) throws AlbumServiceExceptions{
		try {
			
			List<Photo> result = new ArrayList();
			listPhotoDto.forEach(dto -> result.add(savePhotoDto(dto)));
			log.info("save list photo ok. size: %d", result.size());
			return result;
			
		} catch (DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}
	}
	
	
	public List<PhotoDto> getPhotosAll() {
		try {

			log.info("service get photos all");
			List<Photo> result = new ArrayList();
			photoRepository.findAll().forEach(result::add);
			return mapper.mapperListPhotoToListPhotoDto(result);

		} catch (DataAccessException e) {
			log.error(e.getMessage(), e);
			throw new AlbumServiceExceptions(e.getMessage(), e);
		}
	}
	
	
	public List<PhotoDto> getPhotosByUser(Long iduser) throws AlbumServiceExceptions {
		try {

			log.info("service get photos all");
			List<Photo> result = new ArrayList();
			photoRepository.photosByUser(iduser).forEach(result::add);
			return mapper.mapperListPhotoToListPhotoDto(result);

		} catch (DataAccessException e) {
			log.error(e.getMessage(), e);
			throw new AlbumServiceExceptions(e.getMessage(), e);
		}
	}
	
	
	

}
