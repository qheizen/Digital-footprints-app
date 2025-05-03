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
public class TextBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID textBlockId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private com.footprints.entity.LectureContent lecture;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column
    private String formatType;

    @Column
    private int blockOrder;
}