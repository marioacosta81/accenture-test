package com.marioacosta.api.accenture.album.model.dtos;

import lombok.Data;

@Data
public class PhotoDto {

	private Long id;
	private Long albumId;
	private String title;
	private String url;
	private String thumbnailUrl;
}
