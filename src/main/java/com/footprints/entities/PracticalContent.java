package com.footprints.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "practical_content")
public class PracticalContent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID practicalId;

    @Column(nullable = false)
    private int maxAttempts;

    @Column(nullable = false)
    private double successThreshold;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracticalContent that = (PracticalContent) o;
        return Objects.equals(practicalId, that.practicalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(practicalId);
    }
}