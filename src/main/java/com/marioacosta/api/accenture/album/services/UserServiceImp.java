package com.marioacosta.api.accenture.album.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.marioacosta.api.accenture.album.model.dtos.UserDto;
import com.marioacosta.api.accenture.album.model.entities.User;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;
import com.marioacosta.api.accenture.album.model.mappers.MainMapper;
import com.marioacosta.api.accenture.album.repositories.AddressRepository;
import com.marioacosta.api.accenture.album.repositories.CompanyRepository;
import com.marioacosta.api.accenture.album.repositories.GeoRepository;
import com.marioacosta.api.accenture.album.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private GeoRepository geoRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private MainMapper mapper;
	
	public User saveUserDto(UserDto userDto) throws AlbumServiceExceptions{
		User user = mapper.mapperUserDtoToUser(userDto);
		log.info( String.format("mapper to user entity id: %d ok",user.getId()));
		try {
			geoRepository.save(user.getAddress().getGeo());

			addressRepository.save(user.getAddress());
			
			companyRepository.save(user.getCompany());
			
			log.info( String.format("to save user id: %d",user.getId()));
			return userRepository.save(user);
		} catch (DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}
	}
	
	
	public List<User> saveListUserDto(List<UserDto> listUserDto) throws AlbumServiceExceptions{
		try {
			
			List<User> result = new ArrayList();
			listUserDto.forEach(userDto -> result.add(saveUserDto(userDto)));
			log.info("save list user ok. size: %d", result.size());
			return result;
			
		} catch (DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}
	}
	
	
	
	public List<UserDto> getUsersAll() throws AlbumServiceExceptions{
		try {
			
			log.info("service get users all");
			List<User> result = new ArrayList<User>();
			userRepository.findAll().forEach(result::add);
			return mapper.mapperListUserToListUserDto(result);
			
		} catch (DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}
	}
	
	
	
	

}
