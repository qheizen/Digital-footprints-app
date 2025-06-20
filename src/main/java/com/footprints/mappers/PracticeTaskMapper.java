package com.footprints.mappers;

import com.footprints.dto.request.PracticeTaskRequest;
import com.footprints.dto.response.PracticeTaskResponse;
import com.footprints.entities.PracticeTask;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PracticeTaskMapper {

    @Mapping(target = "taskId", ignore = true)
    @Mapping(source = "request.orderIndex", target = "orderIndex")
    PracticeTask toEntity(PracticeTaskRequest request, Long sectionId);

    PracticeTaskResponse toResponse(PracticeTask entity);
}