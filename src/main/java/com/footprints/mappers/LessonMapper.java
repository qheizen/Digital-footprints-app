package com.footprints.mappers;

import com.footprints.dto.request.LessonRequest;
import com.footprints.dto.response.LessonResponse;
import com.footprints.entities.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lessonId", ignore = true)
    Lesson toEntity(LessonRequest request);

    @Mapping(source = "entity.lessonId", target = "id")
    @Mapping(source = "sectionCount", target = "sectionCount")
    LessonResponse toResponse(Lesson entity, Integer sectionCount);
}