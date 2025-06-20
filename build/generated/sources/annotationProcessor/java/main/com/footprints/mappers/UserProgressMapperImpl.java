package com.footprints.mappers;

import com.footprints.dto.request.ProgressUpdateRequest;
import com.footprints.dto.response.UserProgressResponse;
import com.footprints.entities.UserProgress;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-20T22:46:22+0300",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserProgressMapperImpl implements UserProgressMapper {

    @Override
    public UserProgress toEntity(ProgressUpdateRequest request, Long userId, Long courseId) {
        if ( request == null && userId == null && courseId == null ) {
            return null;
        }

        UserProgress userProgress = new UserProgress();

        if ( request != null ) {
            userProgress.setCompletionPercentage( request.completionPercentage() );
            userProgress.setCorrectnessPercentage( request.correctnessPercentage() );
        }
        userProgress.setUserId( userId );
        userProgress.setCourseId( courseId );
        userProgress.setLastAccessed( java.time.LocalDateTime.now() );

        return userProgress;
    }

    @Override
    public UserProgressResponse toResponse(UserProgress entity) {
        if ( entity == null ) {
            return null;
        }

        Long courseId = null;
        Integer completionPercentage = null;
        Integer correctnessPercentage = null;
        String lastAccessed = null;

        courseId = entity.getCourseId();
        completionPercentage = entity.getCompletionPercentage();
        correctnessPercentage = entity.getCorrectnessPercentage();
        if ( entity.getLastAccessed() != null ) {
            lastAccessed = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( entity.getLastAccessed() );
        }

        UserProgressResponse userProgressResponse = new UserProgressResponse( courseId, completionPercentage, correctnessPercentage, lastAccessed );

        return userProgressResponse;
    }
}
