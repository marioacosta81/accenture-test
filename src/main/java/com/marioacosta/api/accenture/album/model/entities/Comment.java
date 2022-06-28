package com.marioacosta.api.accenture.album.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Comment {

	@Id
	private Long id;

	@OneToOne
	@JoinColumn(name = "post_id")
	private Post post;

	private String name;
	private String email;
	
	@Column(length = 500)
	private String body;

}
