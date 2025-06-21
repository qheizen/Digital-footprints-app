package com.footprints.mappers;

import com.footprints.dto.request.LectureContentRequest;
import com.footprints.entities.LectureContent;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-21T04:47:58+0300",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class LectureContentMapperImpl implements LectureContentMapper {

    @Override
    public LectureContent toEntity(LectureContentRequest request, Long sectionId) {
        if ( request == null && sectionId == null ) {
            return null;
        }

        LectureContent lectureContent = new LectureContent();

        if ( request != null ) {
            lectureContent.setContent( request.content() );
        }
        lectureContent.setSectionId( sectionId );

        return lectureContent;
    }
}
