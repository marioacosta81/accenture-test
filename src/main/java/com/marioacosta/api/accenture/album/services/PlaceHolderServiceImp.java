package com.marioacosta.api.accenture.album.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClientException;

import com.marioacosta.api.accenture.album.integrations.PlaceHolder;
import com.marioacosta.api.accenture.album.model.dtos.AlbumDto;
import com.marioacosta.api.accenture.album.model.dtos.CommentDto;
import com.marioacosta.api.accenture.album.model.dtos.PhotoDto;
import com.marioacosta.api.accenture.album.model.dtos.PostDto;
import com.marioacosta.api.accenture.album.model.dtos.UserDto;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlaceHolderServiceImp implements PlaceHolderService {

	@Autowired
	private PlaceHolder placeHolder;

	@Autowired
	private UserService userService;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private PostService postService;
	

	@Override
	@Transactional
	public void readPlaceHolder() throws AlbumServiceExceptions {

		try {
			
			// update users
			List<UserDto> listUserDto = placeHolder.listUsers();
			log.info(String.format("get place holder users ok. size : %d", listUserDto.size()));
			userService.saveListUserDto(listUserDto);
			log.info("userService.saveListUserDto ok" );
			
			
			//update albums
			List<AlbumDto> listAlbumDto = placeHolder.listAlbums();
			log.info(String.format("get place holder album ok. size : %d", listAlbumDto.size()));
			albumService.saveListAlbumDto(listAlbumDto);
			log.info("albumService.saveListAlbumDto ok" );
			
			
			//update post
			List<PostDto> listPostDto = placeHolder.listPosts();
			log.info(String.format("get place holder post ok. size : %d", listPostDto.size()));
			postService.saveListPostDto(listPostDto);
			log.info("postService.saveListPostDto ok" );
			
			//update comments
			List<CommentDto> listCommentDto = placeHolder.listComments();
			log.info(String.format("get place holder comment ok. size : %d", listCommentDto.size()));
			commentService.saveListCommentDto(listCommentDto);
			log.info("commentService.saveListCommentDto ok" );
			
			//update photos
			List<PhotoDto> listPhotoDto = placeHolder.listPhotos();
			log.info(String.format("get place holder photo ok. size : %d", listPhotoDto.size()));
			photoService.saveListPhotoDto(listPhotoDto);
			log.info("photoService.saveListPhotoDto ok" );
			
			log.info("readPlaceHolder ok" );
			
			
		} catch (WebClientException | DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}

	}

}
