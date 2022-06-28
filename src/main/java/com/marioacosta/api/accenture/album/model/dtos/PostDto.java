package com.marioacosta.api.accenture.album.model.dtos;

import lombok.Data;

@Data
public class PostDto {

	
	private Long id;
	private Long userId;
	private String title;
	private String body;

}
