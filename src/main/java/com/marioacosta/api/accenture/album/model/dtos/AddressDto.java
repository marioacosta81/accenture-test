package com.marioacosta.api.accenture.album.model.dtos;

import lombok.Data;

@Data
public class AddressDto {
	
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private GeoDto geo;
	
	
	
}
