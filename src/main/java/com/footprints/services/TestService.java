package com.footprints.services;

import com.footprints.dto.request.TestAnswerRequest;
import com.footprints.entities.TestQuestion;
import com.footprints.entities.UserTestAnswer;
import com.footprints.repositories.TestQuestionRepository;
import com.footprints.repositories.UserTestAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestQuestionRepository testQuestionRepository;
    private final UserTestAnswerRepository userTestAnswerRepository;

    public void submitAnswer(TestAnswerRequest request) {
        TestQuestion question = testQuestionRepository.findById(request.questionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        boolean isCorrect = question.getCorrectAnswer().equals(request.answer());

        UserTestAnswer answer = UserTestAnswer.builder()
                .userId(request.userId())
                .questionId(request.questionId())
                .answer(request.answer())
                .isCorrect(isCorrect)
                .answeredAt(LocalDateTime.now())
                .build();

        userTestAnswerRepository.save(answer);
    }

    public void submitAnswers(List<TestAnswerRequest> requests) {
        for (TestAnswerRequest req : requests) {
            submitAnswer(req);
        }
    }
}