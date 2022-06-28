package com.marioacosta.api.accenture.album.integrations;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.marioacosta.api.accenture.album.model.dtos.AlbumDto;
import com.marioacosta.api.accenture.album.model.dtos.CommentDto;
import com.marioacosta.api.accenture.album.model.dtos.PhotoDto;
import com.marioacosta.api.accenture.album.model.dtos.PostDto;
import com.marioacosta.api.accenture.album.model.dtos.UserDto;
import com.marioacosta.api.accenture.album.model.exceptions.AlbumIntegratedExceptions;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class PlaceHolderImp implements PlaceHolder {

	WebClient client = WebClient.create("https://jsonplaceholder.typicode.com");

	

	public List<UserDto> listUsers() throws AlbumIntegratedExceptions {
		try {
			Mono<List<UserDto>> response = client.get().uri("/users").accept(MediaType.APPLICATION_JSON).retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<UserDto>>() {
					});
			log.info(String.format("ok  %s %d", "listUsers", response.block().size()));
			return response.block();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new AlbumIntegratedExceptions(HttpStatus.FORBIDDEN, null);
		}
	}
	
	
	public List<AlbumDto> listAlbums() throws AlbumIntegratedExceptions {
		try {
			Mono<List<AlbumDto>> response = client.get().uri("/albums").accept(MediaType.APPLICATION_JSON).retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<AlbumDto>>() {
					});
			log.info(String.format("ok  %s %d", "listAlbums", response.block().size()));
			return response.block();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new AlbumIntegratedExceptions(HttpStatus.FORBIDDEN, null);
		}
	}
	

	public List<PhotoDto> listPhotos() throws AlbumIntegratedExceptions {
		try {
			Mono<List<PhotoDto>> response = client
					.mutate()
					.codecs(configurer -> configurer
							  .defaultCodecs()
							  .maxInMemorySize(16 * 1024 * 1024))
					.build()
					.get()
					.uri("/photos")
					.accept(MediaType.APPLICATION_JSON)
					.retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<PhotoDto>>() {
					});
			log.info(String.format("ok  %s %d", "listPhotos", response.block().size()));
			return response.block();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new AlbumIntegratedExceptions(HttpStatus.FORBIDDEN, null);
		}
	}

	public List<CommentDto> listComments() throws AlbumIntegratedExceptions {
		try {
			Mono<List<CommentDto>> response = client.get().uri("/comments").accept(MediaType.APPLICATION_JSON).retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<CommentDto>>() {
					});
			log.info(String.format("ok  %s %d", "listComments", response.block().size()));
			return response.block();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new AlbumIntegratedExceptions(HttpStatus.FORBIDDEN, null);
		}
	}

	public List<PostDto> listPosts() throws AlbumIntegratedExceptions {
		try {
			Mono<List<PostDto>> response = client.get().uri("/posts").accept(MediaType.APPLICATION_JSON).retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<PostDto>>() {
					});
			log.info(String.format("ok  %s %d", "listPosts", response.block().size()));
			return response.block();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new AlbumIntegratedExceptions(HttpStatus.FORBIDDEN, null);
		}
	}

}
