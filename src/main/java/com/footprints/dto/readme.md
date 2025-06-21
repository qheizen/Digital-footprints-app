## DTO
### Описание
Используются для передачи данных между слоями приложения 
и клиентом (REST API). Классы из dto.request определяют 
структуру входящих данных (JSON-запросов), а из dto.response
– исходящих данных (JSON-ответов). DTO отделяют внутреннюю 
модель (сущности) от внешнего представления, упрощают 
валидацию и документирование API.

### Взаимосвязи между DTO
- **CourseRequest** используется для создания/обновления курса и соответствует **CourseResponse** в ответе.
- **LessonRequest** создаёт урок в курсе; возвращается **LessonResponse**.
- **LessonSectionRequest** и **LectureContentRequest** вместе позволяют добавить секцию в урок (причём **LectureContentRequest** – только содержимое лекционной секции).
- **PracticeTaskRequest** и **TestQuestionRequest** используются внутри секций урока, а их результаты возвращаются в составе **SectionContentResponse** списками **practiceTasks** и **testQuestions** соответственно.
- **UserLoginRequest** ведёт к ответу **AuthResponse**, который содержит **UserResponse**.
- **UserRequest** применяется при регистрации и соответствует **UserResponse** после сохранения.
- **ProgressUpdateRequest** и **SectionStatusRequest** обновляют прогресс пользователя; итоговый прогресс можно получить в **UserProgressResponse**.


### Запросы
#### CourseRequest - CourseResponse
```json 
// Запрос
{
  "title": "Java для начинающих",
  "description": "Обучение основам Java",
  "keyWord": "java",
  "difficultyLevel": 2
}

// Ответ
{
  "id": 1,
  "title": "Java для начинающих",
  "description": "Обучение основам Java",
  "difficultyLevel": 2,
  "createdAt": "2025-01-10T10:00:00"
}
```
#### LectureContentRequest
```json 
// Запрос 
{
  "content": {
    "text": "Добро пожаловать в курс Java!",
    "media": null
  }
}
```
#### LessonRequest - LessonResponse
```json 
// Запрос
{
  "courseId": 1,
  "title": "Введение в Java",
  "orderIndex": 1
}

// Ответ
{
  "id": 10,
  "courseId": 1,
  "title": "Введение в Java",
  "orderIndex": 1,
  "sectionCount": 0
}
```
#### LessonSectionRequest
```json
{
  "lessonId": 10,
  "sectionType": "LECTURE",
  "orderIndex": 1
}
```
#### PracticeTaskRequest - PracticeTaskResponse
```json 
// Запрос
{
  "question": "Как объявить переменную в Java?",
  "solution": "int x = 5;",
  "orderIndex": 1
}
// Ответ
{
  "taskId": 101,
  "question": "Как объявить переменную в Java?",
  "solution": "int x = 5;"
}
```
#### ProgressUpdateRequest
```json 
// Запрос
{
  "completionPercentage": 80,
  "correctnessPercentage": 75
}
```
#### SectionStatusRequest
```json 
// Запрос
{
  "isCompleted": true
}
```
#### TestAnswerRequest
```json 
// Запрос
{
  "questionId": 2001,
  "answer": "Полиморфизм"
}
```
#### TestQuestionRequest - TestQuestionResponse
```json 
// Запрос 
{
  "question": "Что такое наследование в Java?",
  "options": ["Наследование", "Инкапсуляция", "Полиморфизм"],
  "correctAnswer": "Наследование",
  "orderIndex": 1
}
// Ответ
{
  "id": 2001,
  "question": "Что такое наследование в Java?",
  "options": ["Наследование", "Инкапсуляция", "Полиморфизм"],
  "correctAnswer": "Наследование"
}
```
#### UserLoginRequest - AuthResponse
```json
// Запрос
{
  "email": "user@example.com",
  "password": "MyPassword123"
}
// Ответ
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "tokenType": "Bearer",
  "user": {
    "id": 5,
    "username": "user123",
    "email": "user@example.com",
    "role": "STUDENT",
    "createdAt": "2025-01-01T08:00:00"
  }
}
```
#### UserRequest - UserResponse
```json 
// Запрос 
{
  "username": "Ivan",
  "userEmail": "ivan@example.com",
  "userPassword": "StrongPass1"
}
// Ответ
{
  "id": 5,
  "username": "Ivan",
  "email": "ivan@example.com",
  "role": "STUDENT",
  "createdAt": "2025-01-15T08:30:00"
}
```
#### ApiResponse
```json 
{
  "status": "success",
  "code": 200,
  "message": "Операция выполнена успешно",
  "data": {
    "id": 1,
    "title": "Java Basics",
    "description": "Курс для начинающих",
    "difficultyLevel": 2,
    "createdAt": "2025-01-10T08:00:00"
  }
}
```
#### SectionContentResponse
```json 
{
  "sectionId": 10,
  "sectionType": "LECTURE",
  "content": {
    "text": "Введение в Java...",
    "codeSample": null
  },
  "practiceTasks": [
    {
      "taskId": 1,
      "question": "Как создать переменную?",
      "solution": "int a = 10;"
    }
  ],
  "testQuestions": [
    {
      "id": 2,
      "question": "Что такое класс?",
      "options": ["Тип данных", "Метод", "Объект"],
      "correctAnswer": "Тип данных."
    }
  ]
}
```
#### UserProgressResponse
```json 
{
  "courseId": 1,
  "completionPercentage": 90,
  "correctnessPercentage": 85,
  "lastAccessed": "2025-06-18T12:00:00"
}
```