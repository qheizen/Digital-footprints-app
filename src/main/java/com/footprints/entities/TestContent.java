package com.footprints.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("test_content")
public class TestContent {

    @Id
    @Column("q_id")
    private Long id;

    @Column("q_section_id")
    private Long sectionId;

    @Column("q_question_description")
    private String questionDescription;

    @Column("q_correct_answer")
    private Long correctAnswerId;

}
