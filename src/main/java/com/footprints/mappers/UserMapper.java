package com.footprints.mappers;

import com.footprints.dto.request.UserRequest;
import com.footprints.dto.response.UserResponse;
import com.footprints.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "request.userPassword", target = "userPassword")
    @Mapping(source = "roleId", target = "roleId")
    User toEntity(UserRequest request, Integer roleId);

    @Mapping(source = "entity.id", target = "id")
    @Mapping(source = "entity.userEmail", target = "email")
    @Mapping(source = "entity.username", target = "username")
    @Mapping(source = "entity.createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(target = "role", source = "role")
    UserResponse toResponse(User entity, String role);
}