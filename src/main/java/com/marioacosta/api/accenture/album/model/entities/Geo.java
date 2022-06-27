package com.marioacosta.api.accenture.album.model.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Geo {
	@EmbeddedId
	private GeoId geoId;

}
