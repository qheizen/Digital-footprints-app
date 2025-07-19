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
    @Column("id")
    private Long id;

    @Column("user_id")
    private Long user_id;

    @Column("current_skill")
    private Short current_skill;

    @Column("lesson_strike")
    private Integer lesson_strike;

    @LastModifiedDate
    @Column("updated_at")
    private LocalDateTime updatedAt;

}
