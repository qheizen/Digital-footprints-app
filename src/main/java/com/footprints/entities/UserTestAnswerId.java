package com.footprints.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTestAnswerId implements Serializable {
    @Column("user_id")
    private Long userId;

    @Column("question_id")
    private Long questionId;
}