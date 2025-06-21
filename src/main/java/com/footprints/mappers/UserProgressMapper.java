package com.footprints.mappers;

import com.footprints.dto.request.ProgressUpdateRequest;
import com.footprints.dto.response.UserProgressResponse;
import com.footprints.entities.UserProgress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = DateMapper.class)
public interface UserProgressMapper {

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "courseId", target = "courseId")
    @Mapping(source = "request.completionPercentage", target = "completionPercentage")
    @Mapping(source = "request.correctnessPercentage", target = "correctnessPercentage")
    @Mapping(target = "lastAccessed", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "new", constant = "true")
    UserProgress toEntity(ProgressUpdateRequest request, Long userId, Long courseId);

    @Mapping(source = "courseId", target = "courseId")
    @Mapping(source = "completionPercentage", target = "completionPercentage")
    @Mapping(source = "correctnessPercentage", target = "correctnessPercentage")
    @Mapping(source = "lastAccessed", target = "lastAccessed", qualifiedByName = "asString")
    UserProgressResponse toResponse(UserProgress entity);
}