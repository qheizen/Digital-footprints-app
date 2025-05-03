package com.footprints.dto;

import java.util.UUID;

public class CourseDto {
    private UUID courseId;
    private String title;
    private String description;

    public CourseDto() {}

    public CourseDto(UUID courseId, String title, String description) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
    }

    public UUID getCourseId() { return courseId; }
    public void setCourseId(UUID courseId) { this.courseId = courseId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}