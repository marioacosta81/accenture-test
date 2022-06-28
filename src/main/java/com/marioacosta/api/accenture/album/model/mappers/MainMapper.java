package com.marioacosta.api.accenture.album.model.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.marioacosta.api.accenture.album.model.dtos.AddressDto;
import com.marioacosta.api.accenture.album.model.dtos.AlbumDto;
import com.marioacosta.api.accenture.album.model.dtos.CommentDto;
import com.marioacosta.api.accenture.album.model.dtos.CompanyDto;
import com.marioacosta.api.accenture.album.model.dtos.GeoDto;
import com.marioacosta.api.accenture.album.model.dtos.PhotoDto;
import com.marioacosta.api.accenture.album.model.dtos.PostDto;
import com.marioacosta.api.accenture.album.model.dtos.UserDto;
import com.marioacosta.api.accenture.album.model.entities.Address;
import com.marioacosta.api.accenture.album.model.entities.Album;
import com.marioacosta.api.accenture.album.model.entities.Comment;
import com.marioacosta.api.accenture.album.model.entities.Company;
import com.marioacosta.api.accenture.album.model.entities.Geo;
import com.marioacosta.api.accenture.album.model.entities.Photo;
import com.marioacosta.api.accenture.album.model.entities.Post;
import com.marioacosta.api.accenture.album.model.entities.User;

@Mapper(componentModel = "spring")
public interface MainMapper {

	User mapperUserDtoToUser(UserDto dto);
	List<User> mapperListUserDtoToListUser(List<UserDto> dto);
	
	Company mapperCompanyDtoToCompany(CompanyDto dto);
	
	Address mapperAddressDtoToAddress(AddressDto dto);

	@Mappings({ @Mapping(target = "geoId.lat", source = "dto.lat"),
		@Mapping(target = "geoId.lng", source = "dto.lng") })
	Geo mapperGeoDtoToGeo(GeoDto dto);
	
	@Mappings({ @Mapping(target = "user.id", source = "dto.userId")})
	Album mapperAlbumDtoToAlbum(AlbumDto dto);
	
	@Mappings({ @Mapping(target = "user.id", source = "dto.userId")})
	Post mapperPostDtoToPost(PostDto dto);
	
	@Mappings({ @Mapping(target = "post.id", source = "dto.postId")})
	Comment mapperCommentDtoToComment(CommentDto dto);
	
	@Mappings({ @Mapping(target = "album.id", source = "dto.albumId")})
	Photo mapperPhotoDtoToPhoto(PhotoDto dto);
	
	

}
