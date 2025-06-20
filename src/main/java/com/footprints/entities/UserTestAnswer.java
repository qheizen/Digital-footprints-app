package com.footprints.entities;

import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("user_test_answers")
public class UserTestAnswer implements Persistable<UserTestAnswerId> {

    @Column("user_id")
    private Long userId;

    @Column("question_id")
    private Long questionId;

    @Column("answer")
    private String answer;

    @Column("is_correct")
    private Boolean isCorrect;

    @Column("answered_at")
    private LocalDateTime answeredAt;

    @Transient
    private boolean isNew = true;

    @Override
    public UserTestAnswerId getId() {
        return new UserTestAnswerId(userId, questionId);
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }
}