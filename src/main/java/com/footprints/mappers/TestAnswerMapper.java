package com.footprints.mappers;

import com.footprints.dto.request.TestAnswerRequest;
import com.footprints.entities.UserTestAnswer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TestAnswerMapper {

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "questionId", source = "request.questionId")
    @Mapping(source = "request.answer", target = "answer")
    @Mapping(target = "isCorrect", ignore = true) // рассчитывается в сервисе
    @Mapping(target = "answeredAt", ignore = true)  // заполняется в сервисе
    UserTestAnswer toEntity(TestAnswerRequest request, Long userId);
}