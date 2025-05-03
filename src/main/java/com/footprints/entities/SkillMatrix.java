package com.footprints.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "user")
@Table(indexes = {
        @Index(name = "idx_skillmatrix_user", columnList = "user_id"),
        @Index(name = "idx_skillmatrix_domain", columnList = "skillDomain")
})
public class SkillMatrix {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID matrixId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @Column(nullable = false)
    @NotBlank
    private String skillDomain;

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    private int skillLevel;

    @Column(nullable = false, updatable = false)
    @NotNull
    private OffsetDateTime createdDate = OffsetDateTime.now();

    @Column(nullable = false)
    @NotNull
    private OffsetDateTime lastUpdated = OffsetDateTime.now();

    @PrePersist
    protected void onCreate() {
        createdDate = OffsetDateTime.now();
        lastUpdated = createdDate;
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdated = OffsetDateTime.now();
    }
}