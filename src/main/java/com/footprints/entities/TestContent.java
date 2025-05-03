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
public class TestContent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID testId;

    @Column(nullable = false)
    private int passingScore;

    @Column
    private double timeLimit;
}