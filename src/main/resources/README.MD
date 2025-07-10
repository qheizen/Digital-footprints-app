# База данных
### Описание
Управления онлайн-курсами, уроками, учебными материалами и отслеживания прогресса пользователей. Она обеспечивает структурированное хранение данных для образовательной платформы с поддержкой различных типов контента (лекции, практические задания, тесты).

### Структура базы данных

![Image alt](https://github.com/qheizen/Digital-footprints-app/blob/data_base_refactore/src/md_resources/db_structure.png)

### Развёртывание с помощью docker
Docker-compose:
```dockerfile
version: "3.9"
services:
  postgres:
    image: postgres:15
    environment:
      POSTGRES_DB: trace_db
      POSTGRES_USER: admin
      POSTGRES_PASSWORD: admin
      PGDATA: "/var/lib/postgresql/data/pgdata"
    volumes:
      - my-data://C/TraceHunterPG4
    ports:
      - "5433:5432"
volumes:
  my-data:
```
Bash
```bash
docker run -d --name trace_db_container -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=trace_db -p 5432:5432 postgres:15
```

Исполнять SQL начиная с 00 до 14, или использовать универсальный сценарий.

### Рекомендации по использованию
#### Для добавления контента
```
Соблюдайте порядок: courses → lessons → lesson_sections → [lecture/practice/test]_content.
```
#### Для анализа прогресса
```postgres-psql
SELECT * 
FROM user_course_status
JOIN user_section_status ON ...
WHERE ucs_user_id = {user_id};
```
#### Оптимизация запросов:
При выборке последовательности уроков/секций применяйте:
```postgres-psql
SELECT * 
FROM lessons 
WHERE l_course_id = {id}
ORDER BY l_order_index;
-- Использует индекс idx_lessons_order
```
### Особенности базы данных
- Иерархическая структура контента
- Поддержка гибкой последовательности через поля order_index
- Система ролей и прав доступа
- Журналирование действий
- Механизмы отслеживания прогресса
- Типизация учебного контента
- Оптимизация производительности
- Система тегирования

