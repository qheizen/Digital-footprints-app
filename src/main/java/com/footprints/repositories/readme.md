## Репозитории
### Описание
Во время разработки были добавлены интерфейсы обращения к базе данных. 
Основные функции по работе с получением данных из файлов курса, обращение к юзер-таблицам и т.д.
Описание актуально на момент Апрель 2025. С последнего коммита. 

#### Пагинаторы
Для методов, возвращающих Page<T>, используйте объект PageRequest
```java
/* юзайте это когда нужна пагинация */
Pageable pageable = PageRequest.of(0, 10, Sort.by("createdAt").descending());

/* юзайте это когда ненужна пагинация. */
Pageable.unpaged
```

#### Optional
Все методы поиска возвращают Optional. Обязательно проверяйте наличие значения
```java
courseRepository.findByTitle("Math").ifPresent(course -> ...);
```
### CourseRepository 
```java
// Поиск по уровню сложности (пагинация)
Page<Course> findWithDifficulty(String difficultLevel, Pageable pageable);

// Поиск курсов с уровнем сложности НИЖЕ указанного
Page<Course> findWithDifficultyBelow(@Param("maxLevel") int maxLevel, Pageable pageable);

// Поиск курса по точному названию
Optional<Course> findByTitle(String title);
```

### LectureContentRepository
```java
// Поиск по курсу
List<Lesson> findByCourseId(Long courseId);

// Поиск нужного урока (по очереди)
Optional<Lesson> findByCourseIdAndOrderIndex(Long courseId, Integer orderIndex);
```

### LessonSectionRepository
```java
// Получение всех разделов урока
List<LessonSection> findByLessonId(Long lessonId);

// Фильтрация разделов по типу (лекция/практика/тест)
List<LessonSection> findBySectionType(String sectionType);

// Поиск раздела по порядковому индексу в уроке
Optional<LessonSection> findByLessonIdAndOrderIndex(Long sectionId, Integer orderIndex);
```

### PracticeTaskRepository
```java
// Получение всех заданий раздела
List<PracticeTask> findBySectionId(Long sectionId);

// Поиск задания по порядковому индексу в разделе
Optional<PracticeTask> findBySectionIdAndOrderIndex(Long sectionId, Integer orderIndex);
```

### TestQuestionRepository
```java
// Получение всех вопросов раздела
List<TestQuestion> findBySectionId(Long sectionId);

// Поиск вопроса по порядковому индексу в разделе
Optional<TestQuestion> findBySectionIdAndOrderIndex(Long sectionId, Integer orderIndex);
```

### UserProgressRepository
```java
// Обновление процента завершения курса
default void updateCompletionPercentage(Long userId, Long courseId, Integer completionPercentage) { ... }

// Обновление процента правильных ответов
default void updateCorrectnessPercentage(Long userId, Long courseId, Integer correctnessPercentage) { ... }

// Основные операции:
UserProgress save(UserProgress progress);
Optional<UserProgress> findByUserIdAndCourseId(Long userId, Long courseId);
List<UserProgress> findByUserId(Long userId);
List<UserProgress> findByCourseId(Long courseId);
void deleteByUserIdAndCourseId(Long userId, Long courseId);
```

### UserRepository
```java
// Поиск по email
Optional<User> findByEmail(String email);

// Проверка существования пользователя по email
boolean existsByEmail(String email);
```

### UserSectionStatusRepository
```java
// Установка/обновление статуса завершения раздела
default void setCompletionStatus(Long userId, Long sectionId, Boolean isCompleted) { ... }

// Обновление статуса (только для существующих записей)
default void updateCompletionStatus(Long userId, Long sectionId, Boolean isCompleted) { ... }

// Основные операции:
UserSectionStatus save(UserSectionStatus status);
Optional<UserSectionStatus> findByUserIdAndSectionId(Long userId, Long sectionId);
List<UserSectionStatus> findByUserId(Long userId);
List<UserSectionStatus> findByUserIdAndIsCompleted(Long userId, Boolean isCompleted);
```
