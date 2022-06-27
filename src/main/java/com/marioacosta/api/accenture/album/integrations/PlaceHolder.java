package com.marioacosta.api.accenture.album.integrations;

import java.util.List;

import com.marioacosta.api.accenture.album.model.dtos.UserDto;
import com.marioacosta.api.accenture.album.model.entities.Album;
import com.marioacosta.api.accenture.album.model.entities.Comment;
import com.marioacosta.api.accenture.album.model.entities.Photo;
import com.marioacosta.api.accenture.album.model.entities.Post;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumIntegratedExceptions;

public interface PlaceHolder {

	List<Album> listAlbums() throws AlbumIntegratedExceptions;

	List<UserDto> listUsers() throws AlbumIntegratedExceptions;

	List<Photo> listPhotos() throws AlbumIntegratedExceptions;

	List<Comment> listComments() throws AlbumIntegratedExceptions;

	List<Post> listPosts() throws AlbumIntegratedExceptions;
}
