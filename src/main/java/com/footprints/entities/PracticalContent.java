package com.footprints.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PracticalContent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID practicalId;

    @Column
    private int maxAttempts;

    @Column
    private double successThreshold;
}