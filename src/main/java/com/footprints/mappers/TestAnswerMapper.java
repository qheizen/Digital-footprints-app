package com.footprints.mappers;

import com.footprints.dto.request.TestAnswerRequest;
import com.footprints.entities.UserTestAnswer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TestAnswerMapper {

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "request.questionId", target = "questionId")
    @Mapping(source = "request.answer", target = "answer")
    @Mapping(target = "isCorrect", ignore = true)
    @Mapping(target = "answeredAt", ignore = true)
    @Mapping(target = "isNew", constant = "true") // Add this line
    UserTestAnswer toEntity(TestAnswerRequest request, Long userId);
}