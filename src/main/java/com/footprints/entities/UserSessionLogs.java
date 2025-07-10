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
@Table("user_session_logs")
public class UserSessionLogs {

    @Id
    @Column("l_id")
    private Long Id;

    @Column("l_user_id")
    private Long userId;

    @Column("l_session_log")
    private String sessionLog;

    @CreatedDate
    @Column("l_created_at")
    private LocalDateTime createdAt;

}