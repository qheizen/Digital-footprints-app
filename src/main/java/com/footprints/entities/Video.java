package com.footprints.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.URL;

import java.util.UUID;

@Entity
@Table(name = "videos")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "lecture")
public class Video {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID videoId;

    @NotNull(message = "Lecture content must be specified")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id", nullable = false)
    private LectureContent lecture;

    @NotBlank(message = "Video URL cannot be empty")
    @URL(message = "Invalid video URL format")
    @Column(nullable = false, length = 2048)
    private String url;

    @PositiveOrZero(message = "Duration cannot be negative")
    @Column(name = "duration_seconds")
    private Integer durationSeconds;

    @Lob
    private String caption;

    @Min(value = 0, message = "Display order cannot be negative")
    @Column(name = "display_order", nullable = false)
    private int displayOrder = 0;

    @Column(name = "video_format", length = 10)
    private String videoFormat;

    @Version
    private Long version;
}