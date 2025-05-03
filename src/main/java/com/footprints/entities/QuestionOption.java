package com.footprints.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class QuestionOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID optionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String optionText;

    @Column(nullable = false)
    private boolean isCorrect;

    @Column
    private int optionOrder;
}