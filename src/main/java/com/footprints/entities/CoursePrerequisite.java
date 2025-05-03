package com.footprints.entities;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "course_prerequisites")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // Добавляет конструктор с параметрами
public class CoursePrerequisite {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Явно указываем стратегию
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(optional = false)
    @JoinColumn(name = "prerequisite_id")
    private Course prerequisite;

    public CoursePrerequisite() {}

    public CoursePrerequisite(Course course, Course prerequisite) {
        this.course = course;
        this.prerequisite = prerequisite;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        this.course = course;
    }

    public Course getPrerequisite() { return prerequisite; }
    public void setPrerequisite(Course prerequisite) {
        if (prerequisite == null) {
            throw new IllegalArgumentException("Prerequisite cannot be null");
        }
        this.prerequisite = prerequisite;
    }
}