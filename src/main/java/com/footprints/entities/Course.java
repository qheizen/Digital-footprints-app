package com.footprints.entities;
import java.util.List;
import java.util.UUID;


public class Course extends AbstractCourse {
    private int _courseType;
    private List<Lesson> _lessons;
    private List<Course> _prerequisites;
    private double _targetSkillLevel;

    public Course(int courseType, List<Lesson> lessons, List<Course> prerequisites, double targetSkillLevel, String title)
    {
        super(, "",title); //TODO доделать конструктор, чтобы подтягивало из бд
        this._courseType = courseType;
        this._lessons = lessons;
        this._prerequisites = prerequisites;
        this._targetSkillLevel = targetSkillLevel;
    }

    public List<Lesson> getLessons() {
        return _lessons;
    }

    public List<Course> getPrerequisites() {
        return _prerequisites;
    }

    public double getTargetSkillLevel() {
        return _targetSkillLevel;
    }

    @Override
    public String getTitle() {
        return super.getTitle(); // или собственная реализация
    }

    public void setCourseType(int courseType) {
        this._courseType = courseType;
    }

    public void setTargetSkillLevel(double targetSkillLevel) {
        this._targetSkillLevel = targetSkillLevel;
    }
}