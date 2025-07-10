package com.footprints.entities;

import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
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
    @Column("u_id")
    private Long id;

    @Column("u_nickname")
    private String username;

    @Column("u_password")
    private String password;

    @Email
    @Column("u_email")
    private String email;

    @Column("u_role")
    private Integer role;

    @CreatedDate
    @Column("u_created_at")
    private LocalDateTime createdAt;

    @Column("u_last_login")
    private LocalDateTime lastLogin;

    @Version
    @Column("u_version")
    private Integer version;

}
