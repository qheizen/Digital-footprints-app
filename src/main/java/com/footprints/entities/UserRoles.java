package com.footprints.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("user_roles")
public class UserRoles {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    @Column("permissions")
    private Byte[] permissions;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;

}
