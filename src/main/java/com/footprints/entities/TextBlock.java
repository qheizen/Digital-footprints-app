package com.footprints.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
@ToString(exclude = "lecture")
@Table(indexes = {
        @Index(name = "idx_textblock_lecture_order", columnList = "lecture_id, blockOrder"),
        @Index(name = "idx_textblock_format", columnList = "formatType")
})
public class TextBlock {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID textBlockId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id", nullable = false)
    @NotNull
    private LectureContent lecture;

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    @NotBlank
    private String content;

    @Column(length = 20)
    @Pattern(regexp = "^(plain|markdown|html)$", message = "Invalid format type")
    private String formatType = "plain";

    @Column(nullable = false)
    private int blockOrder;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdDate = OffsetDateTime.now();

    @Column(nullable = false)
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