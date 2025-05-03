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
public class CodeSnippet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID snippetId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private LectureContent lecture;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String code;

    @Column(nullable = false)
    private String language;

    @Column(columnDefinition = "TEXT")
    private String explanation;

    @Column
    private int snippetOrder;
}