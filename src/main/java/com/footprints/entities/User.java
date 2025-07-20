package com.footprints.entities;

import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class User {

    @Id
    @Column("id")
    private Long id;

    @Column("username")
    private String username;

    @Column("password")
    private String password;

    @Email
    @Column("email")
    private String email;

    @Column("role_id")
    private Integer roleId;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column("updated_at")
    private LocalDateTime updatedAt;

    @Column("last_login")
    private LocalDateTime lastLogin;

    @Version
    @Column("version")
    private Integer version;
}
