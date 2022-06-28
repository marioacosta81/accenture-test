package com.marioacosta.api.accenture.album.repositories;

import org.springframework.data.repository.CrudRepository;

import com.marioacosta.api.accenture.album.model.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{

}
