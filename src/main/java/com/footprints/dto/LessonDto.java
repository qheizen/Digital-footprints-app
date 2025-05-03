package com.footprints.dto;

import java.util.UUID;

public class LessonDto {
    private UUID lessonId;
    private UUID courseId;
    private int lessonOrder;

    public LessonDto() {}

    public LessonDto(UUID lessonId, UUID courseId, int lessonOrder) {
        this.lessonId = lessonId;
        this.courseId = courseId;
        this.lessonOrder = lessonOrder;
    }

    public UUID getLessonId() { return lessonId; }
    public void setLessonId(UUID lessonId) { this.lessonId = lessonId; }
    public UUID getCourseId() { return courseId; }
    public void setCourseId(UUID courseId) { this.courseId = courseId; }
    public int getLessonOrder() { return lessonOrder; }
    public void setLessonOrder(int lessonOrder) { this.lessonOrder = lessonOrder; }
}