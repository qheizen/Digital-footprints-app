package com.footprints.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("courses")
public class Course {

    @Id
    @Column("id")
    private Long Id;

    @Column("keyword_id")
    private Long keywordId;

    @Column("title")
    private String title;

    @Column("description")
    private String description;

    @Column("difficulty_level")
    private Integer difficultyLevel;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column("updated_at")
    private LocalDateTime updatedAt;

    @Version
    @Column("version")
    private Integer version;
}
