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
public class ContentValidation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID validationId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ContentType contentType;

    @Column(nullable = false)
    private UUID contentId;

    @Column
    private boolean isValid;

    @Column(columnDefinition = "jsonb")
    private String validationErrors;

    @Column
    private OffsetDateTime validatedAt = OffsetDateTime.now();

    @Column(nullable = false)
    private String validator;
}