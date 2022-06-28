package com.marioacosta.api.accenture.album.services;

import java.util.List;

import com.marioacosta.api.accenture.album.model.dtos.PostDto;
import com.marioacosta.api.accenture.album.model.entities.Post;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;

public interface PostService {
	
	
	Post savePostDto(PostDto postDto) throws AlbumServiceExceptions;
	
	List<Post> saveListPostDto(List<PostDto> listPostDto) throws AlbumServiceExceptions;

}
