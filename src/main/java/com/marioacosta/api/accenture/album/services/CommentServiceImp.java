package com.marioacosta.api.accenture.album.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.marioacosta.api.accenture.album.model.dtos.CommentDto;
import com.marioacosta.api.accenture.album.model.entities.Comment;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumServiceExceptions;
import com.marioacosta.api.accenture.album.model.mappers.MainMapper;
import com.marioacosta.api.accenture.album.repositories.CommentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImp implements CommentService {
	
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private MainMapper mapper;
	
	public Comment saveCommentDto(CommentDto commentDto) throws AlbumServiceExceptions{
		Comment comment = mapper.mapperCommentDtoToComment(commentDto);
		log.info( String.format("mapper to comment entity id: %d ok",comment.getId()));
		try {
			log.info( String.format("to save comment id: %d",comment.getId()));
			return commentRepository.save(comment);
		} catch (DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}
	}
	
	
	public List<Comment> saveListCommentDto(List<CommentDto> listCommentDto) throws AlbumServiceExceptions{
		try {
			
			List<Comment> result = new ArrayList();
			listCommentDto.forEach(dto -> result.add(saveCommentDto(dto)));
			log.info("save list comment ok. size: %d", result.size());
			return result;
			
		} catch (DataAccessException e) {
			log.error(e.getMessage(),e);
			throw new AlbumServiceExceptions(e.getMessage(),e);
		}
	}
	
	
	
	

}
