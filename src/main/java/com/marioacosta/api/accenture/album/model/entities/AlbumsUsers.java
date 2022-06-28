package com.marioacosta.api.accenture.album.model.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "albums_users")
public class AlbumsUsers {

	@EmbeddedId
	private AlbumsUsersId albumsUsersId;

	@Column(name = "read_permission", columnDefinition = "boolean default false")
	private Boolean readPermission;
	
	@Column(name = "write_permission", columnDefinition = "boolean default false")
	private Boolean writePermission;

}
