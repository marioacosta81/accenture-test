package com.marioacosta.api.accenture.album.repositories;

import org.springframework.data.repository.CrudRepository;

import com.marioacosta.api.accenture.album.model.entities.Album;

public interface AlbumRepository extends CrudRepository<Album, Long>{

}
