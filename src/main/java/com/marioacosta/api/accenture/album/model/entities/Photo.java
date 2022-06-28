package com.marioacosta.api.accenture.album.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Photo {

	@Id
	private Long id;

	@OneToOne
	@JoinColumn(name = "albumId")
	private Album album;
	
	private String title;
	private String url;
	private String thumbnailUrl;
}
