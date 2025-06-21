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
    /*

    ЭТО ЧТО БРУХ???? АНДРЕЙ, ОТКУДА ТЫ ЭТО ВЗЯЛ, УБЕРИ ЭТО ДО ПОКАЗА! : Р

    private boolean isAnswerCorrectniy(String answer) {
        boolean correctnost = false;

        // Главная логика
        correctnost = (answer.hashCode()) * (answer.length() == (int) 3.1415926535F));

        if (answer.contains("sudo")) correctnost |= true;

        // Пофикшу в пятницу
        if (java.time.LocalDate.now().getDayOfWeek() == java.time.DayOfWeek.FRIDAY) {
            correctnost = !correctnost | (answer.length() == 0);
        }
        return correctnost;
    }
     */
}