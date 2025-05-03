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
@Builder
@Table(name = "question_options")
public class QuestionOption {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID optionId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @NotNull(message = "Question cannot be null")
    private Question question;

    @Column(columnDefinition = "TEXT", nullable = false)
    @NotBlank(message = "Option text cannot be blank")
    private String optionText;

    @Column(nullable = false)
    private boolean isCorrect;

    @Column(name = "option_order", nullable = false)
    @Min(value = 0, message = "Order cannot be negative")
    private int optionOrder;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionOption that = (QuestionOption) o;
        return Objects.equals(optionId, that.optionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optionId);
    }
}