package com.footprints.entities;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("test_questions")
public class TestQuestion {

    @Id
    @Column("id")
    private Long id;

    @Column("section_id")
    private Long sectionId;

    @Column("question")
    private String question;

    @Column("options")
    private JsonNode options;

    @Column("correct_answer")
    private String correctAnswer;

    @Column("order_index")
    private Integer orderIndex;
}