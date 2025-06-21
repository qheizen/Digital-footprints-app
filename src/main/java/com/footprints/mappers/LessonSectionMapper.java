package com.footprints.mappers;

import com.footprints.dto.request.LessonSectionRequest;
import com.footprints.entities.LessonSection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonSectionMapper {

    @Mapping(target = "sectionId", ignore = true)
    LessonSection toEntity(LessonSectionRequest request);
}