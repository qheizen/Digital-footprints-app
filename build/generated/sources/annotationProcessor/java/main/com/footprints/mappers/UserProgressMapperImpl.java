package com.footprints.mappers;

import com.footprints.dto.request.ProgressUpdateRequest;
import com.footprints.dto.response.UserProgressResponse;
import com.footprints.entities.UserProgress;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-21T12:35:28+0300",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserProgressMapperImpl implements UserProgressMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public UserProgress toEntity(ProgressUpdateRequest request) {
        if ( request == null ) {
            return null;
        }

        UserProgress userProgress = new UserProgress();

        userProgress.setUserId( request.userId() );
        userProgress.setCourseId( request.courseId() );
        userProgress.setCompletionPercentage( request.completionPercentage() );
        userProgress.setCorrectnessPercentage( request.correctnessPercentage() );

        return userProgress;
    }

    @Override
    public UserProgressResponse toResponse(UserProgress entity) {
        if ( entity == null ) {
            return null;
        }

        Long userId = null;
        Long courseId = null;
        Integer completionPercentage = null;
        Integer correctnessPercentage = null;
        String lastAccessed = null;

        userId = entity.getUserId();
        courseId = entity.getCourseId();
        completionPercentage = entity.getCompletionPercentage();
        correctnessPercentage = entity.getCorrectnessPercentage();
        lastAccessed = dateMapper.asString( entity.getLastAccessed() );

        UserProgressResponse userProgressResponse = new UserProgressResponse( userId, courseId, completionPercentage, correctnessPercentage, lastAccessed );

        return userProgressResponse;
    }
}
