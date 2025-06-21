package com.footprints.mappers;

import com.footprints.dto.request.UserRequest;
import com.footprints.dto.response.UserResponse;
import com.footprints.entities.User;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-21T06:54:07+0300",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_T_HH_mm_ss_11798231098 = DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss" );

    @Override
    public User toEntity(UserRequest request, Integer roleId) {
        if ( request == null && roleId == null ) {
            return null;
        }

        User user = new User();

        if ( request != null ) {
            user.setUsername( request.username() );
            user.setUserEmail( request.userEmail() );
            user.setUserPassword( request.userPassword() );
        }
        user.setRoleId( roleId );

        return user;
    }

    @Override
    public UserResponse toResponse(User entity, String role) {
        if ( entity == null && role == null ) {
            return null;
        }

        Long id = null;
        String username = null;
        String email = null;
        String createdAt = null;
        if ( entity != null ) {
            id = entity.getId();
            username = entity.getUsername();
            email = entity.getUserEmail();
            if ( entity.getCreatedAt() != null ) {
                createdAt = dateTimeFormatter_yyyy_MM_dd_T_HH_mm_ss_11798231098.format( entity.getCreatedAt() );
            }
        }
        String role1 = null;
        role1 = role;

        UserResponse userResponse = new UserResponse( id, username, email, role1, createdAt );

        return userResponse;
    }
}
