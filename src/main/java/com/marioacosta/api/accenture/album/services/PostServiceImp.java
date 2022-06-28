package com.marioacosta.api.accenture.album.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.marioacosta.api.accenture.album.model.dtos.PostDto;
import com.marioacosta.api.accenture.album.model.entities.Post;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;
import com.marioacosta.api.accenture.album.model.mappers.MainMapper;
import com.marioacosta.api.accenture.album.repositories.PostRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostServiceImp implements PostService {
	
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private MainMapper mapper;
	
	public Post savePostDto(PostDto postDto) throws AlbumServiceExceptions{
		Post post = mapper.mapperPostDtoToPost(postDto);
		log.info( String.format("mapper to post entity id: %d ok",post.getId()));
		try {
			log.info( String.format("to save album id: %d",post.getId()));
			return postRepository.save(post);
		} catch (DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}
	}
	
	
	public List<Post> saveListPostDto(List<PostDto> listPostDto) throws AlbumServiceExceptions{
		try {
			
			List<Post> result = new ArrayList();
			listPostDto.forEach(postDto -> result.add(savePostDto(postDto)));
			log.info("save list post ok. size: %d", result.size());
			return result;
			
		} catch (DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}
	}
	
	
	
	

}
