package com.footprints.mappers;

import com.footprints.dto.request.UserRequest;
import com.footprints.dto.response.UserResponse;
import com.footprints.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id",        ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "request.username",    target = "username")
    @Mapping(source = "request.userEmail",   target = "userEmail")    // теперь явно маппим email
    @Mapping(source = "request.userPassword",target = "userPassword")
    @Mapping(source = "roleId",             target = "roleId")
    User toEntity(UserRequest request, Integer roleId);

    @Mapping(source = "id",          target = "id")
    @Mapping(source = "username",    target = "username")
    @Mapping(source = "userEmail",   target = "email")
    @Mapping(source = "createdAt",   target = "createdAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "role",        target = "role")
    UserResponse toResponse(User entity, String role);
}