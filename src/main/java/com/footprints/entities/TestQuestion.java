package com.footprints.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("test_questions")
public class TestQuestion {

    @Id
    @Column("id")
    private Long id;

    @NotNull(message = "Section ID is required")
    @Column("section_id")
    private Long sectionId;

    @NotNull(message = "Question is required")
    @Column("question")
    private String question;

    @NotNull(message = "Options are required")
    @Column("options")
    private JsonNode options;

    @NotNull(message = "Correct answer is required")
    @Column("correct_answer")
    private String correctAnswer;

    @NotNull(message = "Order index is required")
    @Column("order_index")
    private Integer orderIndex;
}