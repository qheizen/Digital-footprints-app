package com.footprints.mappers;

import com.footprints.dto.request.CourseRequest;
import com.footprints.dto.response.CourseResponse;
import com.footprints.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = DateMapper.class)
public interface CourseMapper {

    @Mapping(target = "courseId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Course toEntity(CourseRequest request);

    @Mapping(source = "courseId", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "difficultyLevel", target = "difficultyLevel")
    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "asString")
    CourseResponse toResponse(Course entity);
}