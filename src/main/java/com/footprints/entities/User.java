package com.footprints.entities;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class User {

    @Id
    @Column("id")
    private Long id;

    @NotNull(message = "Username is required")
    @Column("username")
    private String username;

    @NotNull(message = "Email is required")
    @Column("email")
    private String userEmail;

    @NotNull(message = "Password is required")
    @Column("password")
    private String userPassword;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column("updated_at")
    private LocalDateTime updatedAt;

    @NotNull(message = "Role is required")
    @Column("role_id")
    private Integer roleId;
}
