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
public class Courses {

    @Id
    @Column("c_id")
    private Long Id;

    @Column("c_title")
    private String title;

    @Column("c_description")
    private String description;

    @Column("c_keyword")
    private Long keywordId;

    @Column("c_difficulty_level")
    private Integer difficultyLevel;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column("updated_at")
    private LocalDateTime updatedAt;

    @Version
    @Column("c_version")
    private Integer version;

}
