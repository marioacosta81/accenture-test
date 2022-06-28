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
public class Post {

	@Id
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String title;
	private String body;

}
