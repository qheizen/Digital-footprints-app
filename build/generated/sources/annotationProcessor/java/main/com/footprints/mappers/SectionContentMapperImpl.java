package com.footprints.mappers;

import com.fasterxml.jackson.databind.JsonNode;
import com.footprints.dto.response.PracticeTaskResponse;
import com.footprints.dto.response.SectionContentResponse;
import com.footprints.dto.response.TestQuestionResponse;
import com.footprints.entities.LessonSection;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-21T04:53:07+0300",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class SectionContentMapperImpl implements SectionContentMapper {

    @Override
    public SectionContentResponse toResponse(LessonSection section, JsonNode content, List<PracticeTaskResponse> practiceTasks, List<TestQuestionResponse> testQuestions) {
        if ( section == null && content == null && practiceTasks == null && testQuestions == null ) {
            return null;
        }

        Long sectionId = null;
        String sectionType = null;
        if ( section != null ) {
            sectionId = section.getSectionId();
            sectionType = section.getSectionType();
        }
        JsonNode content1 = null;
        content1 = content;
        List<PracticeTaskResponse> practiceTasks1 = null;
        List<PracticeTaskResponse> list = practiceTasks;
        if ( list != null ) {
            practiceTasks1 = new ArrayList<PracticeTaskResponse>( list );
        }
        List<TestQuestionResponse> testQuestions1 = null;
        List<TestQuestionResponse> list1 = testQuestions;
        if ( list1 != null ) {
            testQuestions1 = new ArrayList<TestQuestionResponse>( list1 );
        }

        SectionContentResponse sectionContentResponse = new SectionContentResponse( sectionId, sectionType, content1, practiceTasks1, testQuestions1 );

        return sectionContentResponse;
    }
}
