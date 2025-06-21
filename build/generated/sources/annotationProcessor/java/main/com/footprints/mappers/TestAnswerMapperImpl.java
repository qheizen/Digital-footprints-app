package com.footprints.mappers;

import com.footprints.dto.request.TestAnswerRequest;
import com.footprints.entities.UserTestAnswer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-21T06:54:07+0300",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class TestAnswerMapperImpl implements TestAnswerMapper {

    @Override
    public UserTestAnswer toEntity(TestAnswerRequest request, Long userId) {
        if ( request == null && userId == null ) {
            return null;
        }

        UserTestAnswer.UserTestAnswerBuilder userTestAnswer = UserTestAnswer.builder();

        if ( request != null ) {
            userTestAnswer.questionId( request.questionId() );
            userTestAnswer.answer( request.answer() );
        }
        userTestAnswer.userId( userId );
        userTestAnswer.isNew( true );

        return userTestAnswer.build();
    }
}
