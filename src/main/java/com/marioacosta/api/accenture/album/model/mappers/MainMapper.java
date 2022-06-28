package com.marioacosta.api.accenture.album.model.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.marioacosta.api.accenture.album.model.dtos.AddressDto;
import com.marioacosta.api.accenture.album.model.dtos.AlbumDto;
import com.marioacosta.api.accenture.album.model.dtos.AlbumsUsersDto;
import com.marioacosta.api.accenture.album.model.dtos.CommentDto;
import com.marioacosta.api.accenture.album.model.dtos.CompanyDto;
import com.marioacosta.api.accenture.album.model.dtos.GeoDto;
import com.marioacosta.api.accenture.album.model.dtos.PhotoDto;
import com.marioacosta.api.accenture.album.model.dtos.PostDto;
import com.marioacosta.api.accenture.album.model.dtos.UserDto;
import com.marioacosta.api.accenture.album.model.entities.Address;
import com.marioacosta.api.accenture.album.model.entities.Album;
import com.marioacosta.api.accenture.album.model.entities.AlbumsUsers;
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
	
	UserDto mapperUserToUserDto(User entity);
	List<UserDto> mapperListUserToListUserDto(List<User> listEntity);
	
	
	
	Company mapperCompanyDtoToCompany(CompanyDto dto);
	CompanyDto mapperCompanyToCompanyDto(Company entity);
	
	
	
	Address mapperAddressDtoToAddress(AddressDto dto);
	AddressDto mapperAddressToAddressDto(Address entity);

	
	
	@Mappings({ @Mapping(target = "geoId.lat", source = "dto.lat"),
		@Mapping(target = "geoId.lng", source = "dto.lng") })
	Geo mapperGeoDtoToGeo(GeoDto dto);
	
	@Mappings({ @Mapping(target = "lat", source = "geoId.lat"),
		@Mapping(target = "lng", source = "entity.geoId.lng") })
	GeoDto mapperGeoToGeoDto(Geo entity);
	
	
	
	@Mappings({ @Mapping(target = "user.id", source = "dto.userId")})
	Album mapperAlbumDtoToAlbum(AlbumDto dto);
	
	@Mappings({ @Mapping(target = "userId", source = "entity.user.id")})
	AlbumDto mapperAlbumToAlbumDto(Album entity);
	
	List<Album> mapperListAlbumDtoToListAlbum(List<AlbumDto> listDto);
	List<AlbumDto> mapperListAlbumToListAlbumDto(List<Album> listEntity);
	
	
	@Mappings({ @Mapping(target = "user.id", source = "dto.userId")})
	Post mapperPostDtoToPost(PostDto dto);
	
	@Mappings({ @Mapping(target = "userId", source = "entity.user.id")})
	PostDto mapperPostToPostDto(Post entity);
	
	List<Post> mapperListPostDtoToListPost(List<PostDto> listDto);
	List<PostDto> mapperListPostToListPostDto(List<Post> listEntity);
	
	
	
	@Mappings({ @Mapping(target = "post.id", source = "dto.postId")})
	Comment mapperCommentDtoToComment(CommentDto dto);
	
	@Mappings({ @Mapping(target = "postId", source = "entity.post.id")})
	CommentDto mapperCommentToCommentDto(Comment entity);
	
	List<Comment> mapperListCommentDtoToListComment(List<CommentDto> listDto);
	List<CommentDto> mapperListCommentToListCommentDto(List<Comment> listEntity);
	
	
	
	@Mappings({ @Mapping(target = "album.id", source = "dto.albumId")})
	Photo mapperPhotoDtoToPhoto(PhotoDto dto);
	
	@Mappings({ @Mapping(target = "albumId", source = "entity.album.id")})
	PhotoDto mapperPhotoToPhotoDto(Photo entity);
	
	List<Photo> mapperListPhotoDtoToListPhoto(List<PhotoDto> listDto);
	List<PhotoDto> mapperListPhotoToListPhotoDto(List<Photo> listEntity);
	
	
	
	
	
	
	
	
	
	
	@Mappings({ @Mapping(target = "albumsUsersId.user.id", source = "dto.userId"),
	@Mapping(target = "albumsUsersId.album.id", source = "dto.albumId")})
	AlbumsUsers mapperAlbumsUsersDtoToAlbumsUsers(AlbumsUsersDto dto);
	
	@Mappings({ @Mapping(target = "userId", source = "entity.albumsUsersId.user.id"),
		@Mapping(target = "albumId", source = "entity.albumsUsersId.album.id")})
	AlbumsUsersDto mapperAlbumsUsersToAlbumsUsersDto(AlbumsUsers entity);
	
	List<AlbumsUsersDto> mapperListAlbumsUsersDtoToListAlbumsUsers(List<AlbumsUsersDto> listDto);
	List<AlbumsUsersDto> mapperListAlbumsUsersToListAlbumsUsersDto(List<AlbumsUsers> listEntity);
	
	
	

}
