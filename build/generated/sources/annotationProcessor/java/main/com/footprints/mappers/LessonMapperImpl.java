package com.footprints.mappers;

import com.footprints.dto.request.LessonRequest;
import com.footprints.dto.response.LessonResponse;
import com.footprints.entities.Lesson;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-21T02:22:00+0300",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class LessonMapperImpl implements LessonMapper {

    @Override
    public Lesson toEntity(LessonRequest request) {
        if ( request == null ) {
            return null;
        }

        Lesson lesson = new Lesson();

        lesson.setCourseId( request.courseId() );
        lesson.setTitle( request.title() );
        lesson.setOrderIndex( request.orderIndex() );

        return lesson;
    }

    @Override
    public LessonResponse toResponse(Lesson entity, Integer sectionCount) {
        if ( entity == null && sectionCount == null ) {
            return null;
        }

        Long id = null;
        Long courseId = null;
        String title = null;
        Integer orderIndex = null;
        if ( entity != null ) {
            id = entity.getLessonId();
            courseId = entity.getCourseId();
            title = entity.getTitle();
            orderIndex = entity.getOrderIndex();
        }
        Integer sectionCount1 = null;
        sectionCount1 = sectionCount;

        LessonResponse lessonResponse = new LessonResponse( id, courseId, title, orderIndex, sectionCount1 );

        return lessonResponse;
    }
}
