package com.footprints.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("user_section_status")
public class UserSectionStatus {

    @Id
    @Column("user_id")
    private Long userId;

    @Id
    @Column("section_id")
    private Long sectionId;

    @Column("is_completed")
    private Boolean isCompleted;

    @Column("completed_at")
    private LocalDateTime completedAt;
}