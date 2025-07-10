package com.footprints.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("user_status")
public class UserStatus {

    @Id
    @Column("us_id")
    private Long id;

    @Column("us_user_id")
    private Long user_id;

    @Column("us_current_skill")
    private Short current_skill;

    @Column("us_lesson_strike")
    private Integer lesson_strike;

    @LastModifiedDate
    @Column("updated_at")
    private LocalDateTime updatedAt;

}
