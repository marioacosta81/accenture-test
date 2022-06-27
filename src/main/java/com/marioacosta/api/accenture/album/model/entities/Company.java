package com.marioacosta.api.accenture.album.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Company {
	
	@Id
	private String name;
	private String catchPhrase;
	private String bs;
}
