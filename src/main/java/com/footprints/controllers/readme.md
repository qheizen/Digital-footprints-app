## Контроллеры
### Описание
Контроллеры обрабатывают входящие HTTP-запросы, маршрутизируют их на соответствующие сервисы,
и возвращают ответы в стандартизированном формате. Здесь перечислены доступные REST-эндпоинты.
Описание актуально на момент Июнь 2025. С последнего коммита.


### AuthController

```http
POST /api/v1/auth/login
```
Авторизация пользователя. Ожидает тело запроса с email и паролем.

```http
POST /api/v1/auth/register
```
Регистрация нового пользователя. Ожидает email, пароль и имя пользователя.


### CourseController

```http
GET /api/v1/courses
```
Получить список всех курсов. Необязательный параметр `difficulty` фильтрует по сложности.

```http
GET /api/v1/courses/{id}
```
Получить курс по ID.


### LessonController

```http
GET /api/v1/lessons/course/{courseId}
```
Получить все уроки по ID курса.

```http
GET /api/v1/lessons/{lessonId}
```
Получить конкретный урок по ID.


### SectionController

```http
GET /api/v1/sections/{sectionId}/content
```
Получить содержимое секции урока.


### SectionStatusController

```http
POST /api/v1/sections/status
```
Обновить статус завершения секции пользователем.


### TestController

```http
POST /api/v1/tests/answers
```
Отправить список ответов на тестовые вопросы.


### UserProgressController

```http
POST /api/v1/progress
```
Обновить прогресс пользователя по курсу.

```http
GET /api/v1/progress/{userId}/{courseId}
```
Получить прогресс пользователя по конкретному курсу.

```http
GET /api/v1/progress/user/{userId}
```
Получить прогресс пользователя по всем курсам.
