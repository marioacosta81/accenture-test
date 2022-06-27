package com.marioacosta.api.accenture.album.integrations;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.marioacosta.api.accenture.album.model.dtos.UserDto;
import com.marioacosta.api.accenture.album.model.entities.Album;
import com.marioacosta.api.accenture.album.model.entities.Comment;
import com.marioacosta.api.accenture.album.model.entities.Photo;
import com.marioacosta.api.accenture.album.model.entities.Post;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumIntegratedExceptions;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class PlaceHolderImp implements PlaceHolder {

	WebClient client = WebClient.create("https://jsonplaceholder.typicode.com");

	public List<Album> listAlbums() throws AlbumIntegratedExceptions {
		try {
			Mono<List<Album>> response = client.get().uri("/albums").accept(MediaType.APPLICATION_JSON).retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<Album>>() {
					});
			log.info(String.format("ok  %s %d", "listAlbums", response.block().size()));
			return response.block();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new AlbumIntegratedExceptions(HttpStatus.FORBIDDEN, null);
		}
	}

	public List<UserDto> listUsers() throws AlbumIntegratedExceptions {
		try {
			Mono<List<UserDto>> response = client.get().uri("/users").accept(MediaType.APPLICATION_JSON).retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<UserDto>>() {
					});
			log.info(String.format("ok  %s %d", "listAlbums", response.block().size()));
			return response.block();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new AlbumIntegratedExceptions(HttpStatus.FORBIDDEN, null);
		}
	}

	public List<Photo> listPhotos() throws AlbumIntegratedExceptions {
		try {
			Mono<List<Photo>> response = client.get().uri("/photos").accept(MediaType.APPLICATION_JSON).retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<Photo>>() {
					});
			log.info(String.format("ok  %s %s", "listAlbums", response.block().size()));
			return response.block();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new AlbumIntegratedExceptions(HttpStatus.FORBIDDEN, null);
		}
	}

	public List<Comment> listComments() throws AlbumIntegratedExceptions {
		try {
			Mono<List<Comment>> response = client.get().uri("/comments").accept(MediaType.APPLICATION_JSON).retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<Comment>>() {
					});
			log.info(String.format("ok  %s %s", "listAlbums", response.block().size()));
			return response.block();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new AlbumIntegratedExceptions(HttpStatus.FORBIDDEN, null);
		}
	}

	public List<Post> listPosts() throws AlbumIntegratedExceptions {
		try {
			Mono<List<Post>> response = client.get().uri("/posts").accept(MediaType.APPLICATION_JSON).retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<Post>>() {
					});
			log.info(String.format("ok  %s %s", "listAlbums", response.block().size()));
			return response.block();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new AlbumIntegratedExceptions(HttpStatus.FORBIDDEN, null);
		}
	}

}
