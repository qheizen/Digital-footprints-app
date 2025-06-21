
## Мапперы
### Описание
Во время разработки были добавлены интерфейсы преобразования между DTO и сущностями.
Основные функции заключаются в конвертации данных между слоями приложения (ввод/вывод и бизнес-логика).
Описание актуально на момент Июнь 2025. С последнего коммита.

### CourseMapper
Преобразует `CourseRequest` в `Course` и `Course` в `CourseResponse`, игнорируя поля, генерируемые БД.
```java
// Преобразование запроса в сущность
Course toEntity(CourseRequest request);

// Преобразование сущности в DTO ответа
CourseResponse toResponse(Course entity);
```

### DateMapper
Форматирует `LocalDateTime` в строку и наоборот для сериализации.
```java
// Форматирование даты в строку
@Named("asString")
String asString(LocalDateTime date);

// Обратное преобразование
@Named("asDate")
LocalDateTime asDate(String date);
```

### LectureContentMapper
Создаёт сущность `LectureContent` из запроса и ID секции.
```java
// Создание лекционного контента по ID секции
LectureContent toEntity(LectureContentRequest request, Long sectionId);
```

### LessonMapper
Преобразует `LessonRequest` в `Lesson` и `Lesson` в `LessonResponse`, добавляя количество секций.
```java
Lesson toEntity(LessonRequest request);
LessonResponse toResponse(Lesson entity, Integer sectionCount);
```

### LessonSectionMapper
Преобразует `LessonSectionRequest` в сущность `LessonSection`, игнорируя ID.
```java
LessonSection toEntity(LessonSectionRequest request);
```

### PracticeTaskMapper
Создаёт `PracticeTask` из запроса и ID секции и мапит обратно в ответ.
```java
PracticeTask toEntity(PracticeTaskRequest request, Long sectionId);
PracticeTaskResponse toResponse(PracticeTask entity);
```

### SectionContentMapper
Формирует `SectionContentResponse` из секции, контента, заданий и вопросов.
```java
SectionContentResponse toResponse(
    LessonSection section,
    JsonNode content,
    List<PracticeTaskResponse> practiceTasks,
    List<TestQuestionResponse> testQuestions
);
```

### TestAnswerMapper
Создаёт сущность `UserTestAnswer` из запроса и userId, без автозаполнения результата.
```java
UserTestAnswer toEntity(TestAnswerRequest request, Long userId);
```

### TestQuestionMapper
Создаёт `TestQuestion` из запроса и ID секции, и обратно преобразует в DTO.
```java
TestQuestion toEntity(TestQuestionRequest request, Long sectionId);
TestQuestionResponse toResponse(TestQuestion entity);
```

### UserMapper
Преобразует `UserRequest` в `User`, устанавливая роль и игнорируя ID и даты, и формирует ответ с ролью.
```java
User toEntity(UserRequest request, Integer roleId);
UserResponse toResponse(User entity, String role);
```

### UserProgressMapper
Преобразует `ProgressUpdateRequest` в `UserProgress` и обратно, устанавливая текущую дату доступа.
```java
UserProgress toEntity(ProgressUpdateRequest request, Long userId, Long courseId);
UserProgressResponse toResponse(UserProgress entity);
```
