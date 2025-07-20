package com.footprints.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("user_section_status")
public class UserSectionStatus {

    @Id
    @Column("id")
    private Long id;

    @Column("user_id")
    private Long userId;

    @Column("section_id")
    private Long sectionId;

    @Column("is_completed")
    private boolean isCompleted;

    @Column("completed_at")
    private LocalDateTime completedAt;
}
