package com.footprints.mappers;

import com.footprints.dto.request.TestQuestionRequest;
import com.footprints.dto.response.TestQuestionResponse;
import com.footprints.entities.TestQuestion;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TestQuestionMapper {

    default TestQuestion toEntity(TestQuestionRequest request, Long sectionId) {
        TestQuestion entity = new TestQuestion();
        entity.setQuestion(request.question());
        entity.setOptions(request.options());
        entity.setCorrectAnswer(request.correctAnswer());
        entity.setOrderIndex(request.orderIndex());

        // Создаем объект секции только с ID
        TestQuestion section = new TestQuestion();
        section.setId(sectionId);
        entity.setSectionId(section.getSectionId());

        return entity;
    }

    TestQuestionResponse toResponse(TestQuestion entity);
}