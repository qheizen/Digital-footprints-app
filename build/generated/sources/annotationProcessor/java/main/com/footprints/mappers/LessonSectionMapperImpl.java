package com.footprints.mappers;

import com.footprints.dto.request.LessonSectionRequest;
import com.footprints.entities.LessonSection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-24T00:24:40+0300",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class LessonSectionMapperImpl implements LessonSectionMapper {

    @Override
    public LessonSection toEntity(LessonSectionRequest request) {
        if ( request == null ) {
            return null;
        }

        LessonSection lessonSection = new LessonSection();

        lessonSection.setLessonId( request.lessonId() );
        lessonSection.setSectionType( request.sectionType() );
        lessonSection.setOrderIndex( request.orderIndex() );

        return lessonSection;
    }
}
