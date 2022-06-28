package com.marioacosta.api.accenture.album.model.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class GeoId implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String lat;
	private String lng;
	
	public GeoId() {}
	
	public GeoId(String lat,String lng) {
		this.lat = lat;
		this.lng = lng;
	}
	

}
