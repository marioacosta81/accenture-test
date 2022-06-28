package com.marioacosta.api.accenture.album.services;

import java.util.List;

import com.marioacosta.api.accenture.album.model.dtos.CommentDto;
import com.marioacosta.api.accenture.album.model.entities.Comment;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;

public interface CommentService {
	Comment saveCommentDto(CommentDto commentDto) throws AlbumServiceExceptions;
	
	List<Comment> saveListCommentDto(List<CommentDto> listCommentDto) throws AlbumServiceExceptions;

}
