package com.footprints.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import jakarta.validation.constraints.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "test_contents", indexes = @Index(columnList = "passingScore"))
public class TestContent {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID testId;

    @Column(nullable = false)
    private Integer passingScore;

    @Column(name = "time_limit_minutes")
    private Double timeLimitInMinutes;

    @Version
    private Long version;
}