
## Сервисы
### Описание
Сервисный слой инкапсулирует бизнес-логику приложения, обрабатывая данные между контроллерами и репозиториями.
Каждый сервис отвечает за конкретную область предметной области и взаимодействует с мапперами, DTO и БД.
Описание актуально на момент Июнь 2025. С последнего коммита.


### AuthService
Отвечает за регистрацию и аутентификацию пользователей через JWT-токены.
```java
JwtAuthResponse login(UserLoginRequest request);
JwtAuthResponse register(UserRegisterRequest request);
```

### CourseService
Предоставляет список всех курсов или отдельный курс по ID, с возможностью фильтрации по уровню сложности.
```java
List<CourseResponse> getAllCourses(Integer difficulty);
CourseResponse getCourseById(Long id);
```

### LessonService
Возвращает список уроков для курса, а также конкретный урок с количеством секций.
```java
List<LessonResponse> getLessonsByCourseId(Long courseId);
LessonResponse getLessonById(Long lessonId);
```

### SectionService
Формирует полное содержимое секции урока: лекции, практические задания и тесты.
```java
SectionContentResponse getSectionContent(Long sectionId);
```

### SectionStatusService
Обновляет статус завершения секции (пройдено/не пройдено) для конкретного пользователя.
```java
void updateSectionStatus(SectionStatusRequest request);
```

### TestService
Обрабатывает ответы пользователя на тестовые вопросы, включая проверку корректности.
```java
void submitAnswer(TestAnswerRequest request);
void submitAnswers(List<TestAnswerRequest> requests);
```

### UserProgressService
Управляет прогрессом пользователя по курсам, включая обновление и получение текущего состояния.
```java
UserProgressResponse updateProgress(ProgressUpdateRequest request);
UserProgressResponse getProgress(Long userId, Long courseId);
List<UserProgressResponse> getProgressByUser(Long userId);
```
