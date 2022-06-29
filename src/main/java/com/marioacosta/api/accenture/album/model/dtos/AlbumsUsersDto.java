package com.marioacosta.api.accenture.album.model.dtos;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AlbumsUsersDto {

	@NotNull(message = "Id user is mandatory")
	private Long userId;
	
	@NotNull(message = "Id album is mandatory")
	private Long albumId;
	
	@NotNull(message = "Read permission is mandatory")
	private Boolean readPermission;
	
	@NotNull(message = "Write permission is mandatory")
	private Boolean writePermission;

}
