package com.footprints.entities;
import java.util.UUID;

public class AbstractCourse {
    private UUID _courseId;
    private String _description;
    private String _title;

    // Конструктор (может быть дополнен в зависимости от требований)
    public AbstractCourse(UUID courseId, String description, String title) {
        this._courseId = courseId;
        this._description = description;
        this._title = title;
    }

    // Геттеры (возвращают значения полей, несмотря на указание void в задании - предположена опечатка)
    public UUID getCourseId() {
        return _courseId;
    }

    public String getDescription() {
        return _description;
    }

    public String getTitle() {
        return _title;
    }

    // Сеттеры (добавлены для полноты, но не указаны в задании)
    public void setCourseId(UUID courseId) {
        this._courseId = courseId;
    }

    public void setDescription(String description) {
        this._description = description;
    }

    public void setTitle(String title) {
        this._title = title;
    }
}