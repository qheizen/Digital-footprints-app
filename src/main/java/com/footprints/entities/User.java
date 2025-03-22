package com.footprints.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User
{
    private List<CourseProgress> completedCourses; // Исправлен тип
    private SkillLevel currentSkillLevel; // Исправлен тип
    private final UUID userId;
    private String username;

    public User(String username)
    {
        this.userId = UUID.randomUUID();
        this.username = username;
        this.completedCourses = new ArrayList<>();
    }

    // Добавление курса
    public void addCompletedCourse(CourseProgress course)
    {
        completedCourses.add(course);
    }

    // Удаление курса
    public void removeCompletedCourse(CourseProgress course)
    {
        completedCourses.remove(course);
    }

    // Получение копии списка курсов
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
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    // Расчет уровня навыка
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

    // Геттер для уровня навыка
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