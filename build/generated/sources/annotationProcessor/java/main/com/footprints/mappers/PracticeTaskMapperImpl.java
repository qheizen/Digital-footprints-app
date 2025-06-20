package com.footprints.mappers;

import com.footprints.dto.request.PracticeTaskRequest;
import com.footprints.dto.response.PracticeTaskResponse;
import com.footprints.entities.PracticeTask;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-20T21:36:15+0300",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class PracticeTaskMapperImpl implements PracticeTaskMapper {

    @Override
    public PracticeTask toEntity(PracticeTaskRequest request, Long sectionId) {
        if ( request == null && sectionId == null ) {
            return null;
        }

        PracticeTask practiceTask = new PracticeTask();

        if ( request != null ) {
            practiceTask.setOrderIndex( request.orderIndex() );
            practiceTask.setQuestion( request.question() );
            practiceTask.setSolution( request.solution() );
        }
        practiceTask.setSectionId( sectionId );

        return practiceTask;
    }

    @Override
    public PracticeTaskResponse toResponse(PracticeTask entity) {
        if ( entity == null ) {
            return null;
        }

        Long taskId = null;
        String question = null;
        String solution = null;

        taskId = entity.getTaskId();
        question = entity.getQuestion();
        solution = entity.getSolution();

        PracticeTaskResponse practiceTaskResponse = new PracticeTaskResponse( taskId, question, solution );

        return practiceTaskResponse;
    }
}
