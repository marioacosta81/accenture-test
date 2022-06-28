package com.marioacosta.api.accenture.album.model.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class AlbumsUsersId implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	@OneToOne
	@JoinColumn(name = "album_id")
	private Album album;

	

}
