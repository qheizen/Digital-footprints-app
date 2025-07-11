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
    @Column("id")
    private Long id;

    @Column("section_id")
    private Long sectionId;

    @Column("task_description")
    private String taskDescription;

    @Column("order_index")
    private Integer orderIndex;


}
