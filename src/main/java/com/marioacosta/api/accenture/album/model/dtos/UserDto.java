package com.marioacosta.api.accenture.album.model.dtos;

import com.marioacosta.api.accenture.album.model.entities.Company;

import lombok.Data;

@Data
public class UserDto {

	
	private Long id;
	private String name;
	private String username;
	private String email;
	private String phone;
	private String website;
	private Company company;
	private AddressDto address;
	
	
}
