package com.footprints.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSectionStatusId implements Serializable {
    @Column("user_id")
    private Long userId;

    @Column("section_id")
    private Long sectionId;
}