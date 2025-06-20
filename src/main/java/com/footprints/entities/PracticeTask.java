package com.footprints.entities;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("practice_tasks")
public class PracticeTask {

    @Id
    @Column("id")
    private Long taskId;

    @NotNull(message = "Section ID is required")
    @Column("section_id")
    private Long sectionId;

    @NotNull(message = "Question is required")
    @Column("question")
    private String question;

    @NotNull(message = "Solution is required")
    @Column("solution")
    private String solution;

    @NotNull(message = "Order index is required")
    @Column("order_index")
    private Integer orderIndex;
}