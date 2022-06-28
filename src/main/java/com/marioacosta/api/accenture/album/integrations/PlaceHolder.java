package com.marioacosta.api.accenture.album.integrations;

import java.util.List;

import com.marioacosta.api.accenture.album.model.dtos.AlbumDto;
import com.marioacosta.api.accenture.album.model.dtos.CommentDto;
import com.marioacosta.api.accenture.album.model.dtos.PhotoDto;
import com.marioacosta.api.accenture.album.model.dtos.PostDto;
import com.marioacosta.api.accenture.album.model.dtos.UserDto;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumIntegratedExceptions;

public interface PlaceHolder {

	List<AlbumDto> listAlbums() throws AlbumIntegratedExceptions;

	List<UserDto> listUsers() throws AlbumIntegratedExceptions;

	List<PhotoDto> listPhotos() throws AlbumIntegratedExceptions;

	List<CommentDto> listComments() throws AlbumIntegratedExceptions;

	List<PostDto> listPosts() throws AlbumIntegratedExceptions;
}
