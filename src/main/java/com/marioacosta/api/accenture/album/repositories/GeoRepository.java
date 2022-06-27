package com.marioacosta.api.accenture.album.repositories;

import org.springframework.data.repository.CrudRepository;

import com.marioacosta.api.accenture.album.model.entities.Geo;
import com.marioacosta.api.accenture.album.model.entities.GeoId;

public interface GeoRepository extends CrudRepository<Geo, GeoId>{

}
