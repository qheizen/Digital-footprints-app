package com.footprints.mappers;

import com.footprints.dto.request.LectureContentRequest;
import com.footprints.entities.LectureContent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LectureContentMapper {

    @Mapping(target = "sectionId", source = "sectionId")
    LectureContent toEntity(LectureContentRequest request, Long sectionId);
}