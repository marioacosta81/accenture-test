package com.marioacosta.api.accenture.album.model.dtos;

import lombok.Data;

@Data
public class AlbumsUsersDto {

	
	private Long userId;
	private Long albumId;
	private Boolean readPermission;
	private Boolean writePermission;

}
