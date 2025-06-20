package com.footprints.mappers;

import com.footprints.dto.request.LessonSectionRequest;
import com.footprints.entities.LessonSection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonSectionMapper {

    LessonSection toEntity(LessonSectionRequest request);
}