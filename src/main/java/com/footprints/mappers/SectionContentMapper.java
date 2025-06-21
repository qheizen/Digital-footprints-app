package com.footprints.mappers;

import com.footprints.dto.response.PracticeTaskResponse;
import com.footprints.dto.response.SectionContentResponse;
import com.footprints.dto.response.TestQuestionResponse;
import com.footprints.entities.LessonSection;
import com.fasterxml.jackson.databind.JsonNode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectionContentMapper {

    @Mapping(source = "section.sectionId", target = "sectionId")
    @Mapping(source = "section.sectionType", target = "sectionType")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "practiceTasks", target = "practiceTasks")
    @Mapping(source = "testQuestions", target = "testQuestions")
    SectionContentResponse toResponse(
            LessonSection section,
            JsonNode content,
            List<PracticeTaskResponse> practiceTasks,
            List<TestQuestionResponse> testQuestions
    );
}