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
@Table("practice_content")
public class PracticeContent {

    @Id
    @Column("p_id")
    private Long id;

    @Column("p_section_id")
    private Long sectionId;

    @Column("p_task_description")
    private String taskDescription;

    @Column("p_order_index")
    private Integer orderIndex;


}
