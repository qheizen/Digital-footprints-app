package com.footprints.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.footprints.dto.response.PracticeTaskResponse;
import com.footprints.dto.response.SectionContentResponse;
import com.footprints.dto.response.TestQuestionResponse;
import com.footprints.entities.LectureContent;
import com.footprints.entities.LessonSection;
import com.footprints.entities.PracticeTask;
import com.footprints.entities.TestQuestion;
import com.footprints.mappers.PracticeTaskMapper;
import com.footprints.mappers.SectionContentMapper;
import com.footprints.mappers.TestQuestionMapper;
import com.footprints.repositories.LectureContentRepository;
import com.footprints.repositories.LessonSectionRepository;
import com.footprints.repositories.PracticeTaskRepository;
import com.footprints.repositories.TestQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectionService {

    private final LessonSectionRepository sectionRepository;
    private final LectureContentRepository contentRepository;
    private final PracticeTaskRepository practiceTaskRepository;
    private final TestQuestionRepository testQuestionRepository;
    private final PracticeTaskMapper practiceTaskMapper;
    private final TestQuestionMapper testQuestionMapper;
    private final SectionContentMapper sectionContentMapper;

    public SectionContentResponse getSectionContent(Long sectionId) {
        LessonSection section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new RuntimeException("Section not found"));

        Optional<LectureContent> lectureContentOpt = contentRepository.findById(sectionId);
        JsonNode lectureJson = lectureContentOpt.map(LectureContent::getContent).orElse(null);

        List<PracticeTask> tasks = practiceTaskRepository.findBySectionId(sectionId);
        List<PracticeTaskResponse> taskResponses = tasks.stream()
                .map(practiceTaskMapper::toResponse)
                .collect(Collectors.toList());

        List<TestQuestion> questions = testQuestionRepository.findBySectionId(sectionId);
        List<TestQuestionResponse> questionResponses = questions.stream()
                .map(testQuestionMapper::toResponse)
                .collect(Collectors.toList());

        return sectionContentMapper.toResponse(section, lectureJson, taskResponses, questionResponses);
    }
}