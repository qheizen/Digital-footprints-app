package com.footprints.mappers;

import com.footprints.dto.request.CourseRequest;
import com.footprints.dto.response.CourseResponse;
import com.footprints.entities.Course;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-20T17:08:00+0300",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public Course toEntity(CourseRequest request) {
        if ( request == null ) {
            return null;
        }

        Course.CourseBuilder course = Course.builder();

        course.title( request.title() );
        course.description( request.description() );
        course.keyWord( request.keyWord() );
        course.difficultyLevel( request.difficultyLevel() );

        return course.build();
    }

    @Override
    public CourseResponse toResponse(Course entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String description = null;
        Integer difficultyLevel = null;
        String createdAt = null;

        id = entity.getCourseId();
        title = entity.getTitle();
        description = entity.getDescription();
        difficultyLevel = entity.getDifficultyLevel();
        createdAt = dateMapper.asString( entity.getCreatedAt() );

        CourseResponse courseResponse = new CourseResponse( id, title, description, difficultyLevel, createdAt );

        return courseResponse;
    }
}
