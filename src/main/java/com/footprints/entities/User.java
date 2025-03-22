package com.footprints.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User
{
    private List<CourseProgress> completedCourses; // Исправлен тип
    private SkillLevel currentSkillLevel; // Исправлен тип
    private final UUID userId;
    private String userName;

    public User(String username)
    {
        this.userId = UUID.randomUUID();
        this.userName = username;
        this.completedCourses = new ArrayList<>();
    }

    public void addCompletedCourse(CourseProgress course)
    {
        completedCourses.add(course);
    }

    public void removeCompletedCourse(CourseProgress course)
    {
        completedCourses.remove(course);
    }

    public List<CourseProgress> getCompletedCourses()
    {
        return new ArrayList<>(completedCourses);
    }

    public UUID getUserId()
    {
        return userId;
    }

    public String getUsername()
    {
        return userName;
    }

    public void setUsername(String username)
    {
        this.userName = username;
    }

    public void calculateSkillGradient()
    {
        int completedCount = completedCourses.size();
        if (completedCount > 10) {
            currentSkillLevel = SkillLevel.ADVANCED;
        } else if (completedCount > 5) {
            currentSkillLevel = SkillLevel.INTERMEDIATE;
        } else {
            currentSkillLevel = SkillLevel.BEGINNER;
        }
    }

    public SkillLevel getCurrentSkillLevel()
    {
        return currentSkillLevel;
    }

    // Enum для уровней навыка (можно вынести в отдельный файл)
    public enum SkillLevel
    {
        BEGINNER,
        INTERMEDIATE,
        ADVANCED
    }
}