package com.marioacosta.api.accenture.album.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.marioacosta.api.accenture.album.model.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{
	
	
	@Query("SELECT a FROM Comment a WHERE a.name like :name")
	List<Comment> commentsByName(@Param("name") String name);
	
	@Query("SELECT a FROM Comment a WHERE a.post.user.id = :iduser")
	List<Comment> commentsByUser(@Param("iduser") Long iduser);
	

}
