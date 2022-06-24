package com.marioacosta.api.accenture.album.integrations;

import java.util.List;

import com.marioacosta.api.accenture.album.model.entities.Album;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumIntegratedExceptions;

public interface PlaceHolder {

	List<Album> listAlbums() throws AlbumIntegratedExceptions;

}
