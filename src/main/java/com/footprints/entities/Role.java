package com.footprints.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("roles")
public class Role {

    @Id
    @Column("role_id")
    private Integer id;

    @Column("role_name")
    private String name;
}