package com.marioacosta.api.accenture.album.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marioacosta.api.accenture.album.integrations.PlaceHolder;
import com.marioacosta.api.accenture.album.model.dtos.GeoDto;
import com.marioacosta.api.accenture.album.model.dtos.UserDto;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumIntegratedExceptions;
import com.marioacosta.api.accenture.album.repositories.GeoRepository;
import com.marioacosta.api.accenture.album.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlaceHolderServiceImp implements PlaceHolderService {

	@Autowired
	PlaceHolder placeHolder;

	@Autowired
	UserRepository userRepository;

	@Autowired
	GeoRepository geoRepository;

	@Override
	@Transactional
	public void readPlaceHolder() throws AlbumIntegratedExceptions {

		// borrar lo que existe
		// userRepository.deleteAll();

		// recuperar user
		UserDto user1 = placeHolder.listUsers().get(0);
		
		GeoDto geo1 = user1.getAddress().getGeo();

		try {
			// guardar geo
			//geoRepository.save(geo1);

			// guardar company
			// guardar address
			// guardar user

			//userRepository.save(user1);
		} catch (DataAccessException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

	}

}
