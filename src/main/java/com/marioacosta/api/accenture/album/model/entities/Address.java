package com.marioacosta.api.accenture.album.model.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Address {
	@Id
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	
	@OneToOne(fetch= FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "lat" , referencedColumnName = "lat"),
			@JoinColumn(name = "lng" , referencedColumnName = "lng")
	})
	private Geo geo;
	
	
	
}
