package com.footprints.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SkillMatrix {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID matrixId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String skillDomain;

    @Column(nullable = false)
    private int skillLevel;

    @Column
    private OffsetDateTime lastUpdated = OffsetDateTime.now();

    @PreUpdate
    public void preUpdate() {
        this.lastUpdated = OffsetDateTime.now();
    }
}