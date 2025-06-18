package com.footprints.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("user_test_answers")
public class UserTestAnswer {

    @Id
    @Column("user_id")
    private Long userId;

    @Id
    @Column("question_id")
    private Long questionId;

    @Column("answer")
    private String answer;

    @Column("is_correct")
    private Boolean isCorrect;

    @Column("answered_at")
    private LocalDateTime answeredAt;
}