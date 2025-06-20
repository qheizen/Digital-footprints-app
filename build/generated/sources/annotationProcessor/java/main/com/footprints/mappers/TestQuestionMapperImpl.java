package com.footprints.mappers;

import com.fasterxml.jackson.databind.JsonNode;
import com.footprints.dto.response.TestQuestionResponse;
import com.footprints.entities.TestQuestion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-20T22:46:22+0300",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class TestQuestionMapperImpl implements TestQuestionMapper {

    @Override
    public TestQuestionResponse toResponse(TestQuestion entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String question = null;
        JsonNode options = null;
        String correctAnswer = null;

        id = entity.getId();
        question = entity.getQuestion();
        options = entity.getOptions();
        correctAnswer = entity.getCorrectAnswer();

        TestQuestionResponse testQuestionResponse = new TestQuestionResponse( id, question, options, correctAnswer );

        return testQuestionResponse;
    }
}
