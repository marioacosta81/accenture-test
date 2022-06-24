package com.marioacosta.api.accenture.album;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
@EntityScan({ "com.marioacosta.api.accenture.album.model.entities" })
public class ApiAccentureAlbumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAccentureAlbumApplication.class, args);
	}

}
