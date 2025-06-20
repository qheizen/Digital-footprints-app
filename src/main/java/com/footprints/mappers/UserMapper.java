package com.footprints.mappers;

import com.footprints.dto.request.UserRequest;
import com.footprints.dto.response.UserResponse;
import com.footprints.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "request.username", target = "username")
    @Mapping(source = "request.userEmail", target = "userEmail")
    @Mapping(source = "request.userPassword", target = "userPassword")
    @Mapping(source = "roleId", target = "roleId")
    User toEntity(UserRequest request, Integer roleId);

    @Mapping(source = "entity.id", target = "id")
    @Mapping(source = "entity.username", target = "username")
    @Mapping(source = "entity.userEmail", target = "email")
    @Mapping(source = "entity.createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "role", target = "role")
    UserResponse toResponse(User entity, String role);
}