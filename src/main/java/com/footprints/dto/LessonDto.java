package com.footprints.dto;

import java.util.UUID;

public class LessonDto {
    private UUID lessonId;
    private UUID courseId;
    private int lessonOrder;

    // Геттеры и сеттеры
    public UUID getLessonId() { return lessonId; }
    public void setLessonId(UUID lessonId) { this.lessonId = lessonId; }
    public UUID getCourseId() { return courseId; }
    public void setCourseId(UUID courseId) { this.courseId = courseId; }
    public int getLessonOrder() { return lessonOrder; }
    public void setLessonOrder(int lessonOrder) { this.lessonOrder = lessonOrder; }
}