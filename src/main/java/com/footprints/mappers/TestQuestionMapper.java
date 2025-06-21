package com.footprints.mappers;

import com.footprints.dto.request.TestQuestionRequest;
import com.footprints.dto.response.TestQuestionResponse;
import com.footprints.entities.TestQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TestQuestionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "request.question", target = "question")
    @Mapping(source = "request.options", target = "options")
    @Mapping(source = "request.correctAnswer", target = "correctAnswer")
    @Mapping(source = "request.orderIndex", target = "orderIndex")
    @Mapping(source = "sectionId", target = "sectionId")
    TestQuestion toEntity(TestQuestionRequest request, Long sectionId);

    TestQuestionResponse toResponse(TestQuestion entity);
}
