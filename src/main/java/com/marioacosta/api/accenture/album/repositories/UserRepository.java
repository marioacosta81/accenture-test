package com.marioacosta.api.accenture.album.repositories;

import org.springframework.data.repository.CrudRepository;

import com.marioacosta.api.accenture.album.model.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
