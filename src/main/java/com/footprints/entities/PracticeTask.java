package com.footprints.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("practice_tasks")
public class PracticeTask {

    @Id
    @Column("id")
    private Long taskId;

    @Column("section_id")
    private Long sectionId;

    @Column("question")
    private String question;

    @Column("solution")
    private String solution;

    @Column("order_index")
    private Integer orderIndex;
}