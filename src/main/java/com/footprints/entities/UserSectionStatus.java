package com.footprints.entities;

import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("user_section_status")
public class UserSectionStatus implements Persistable<UserSectionStatusId> {

    @Column("user_id")
    private Long userId;

    @Column("section_id")
    private Long sectionId;

    @Column("is_completed")
    private Boolean isCompleted;

    @Column("completed_at")
    private LocalDateTime completedAt;

    @Transient
    private boolean isNew = true;

    @Override
    public UserSectionStatusId getId() {
        return new UserSectionStatusId(userId, sectionId);
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }
}