## База данных
### Описание
Управления онлайн-курсами, уроками, учебными материалами и 
отслеживания прогресса пользователей. Она обеспечивает 
структурированное хранение данных для образовательной 
платформы с поддержкой различных типов контента (лекции, 
практические задания, тесты).
### Структура таблиц
Родион, вставь картинку

### Развертывание с помощью Docker
Docker-compose:
```
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
или BASH:
```
docker run -d --name trace_db_container -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=trace_db -p 5432:5432 postgres:15
```

### Особенности базы данных
- Использование JSONB для хранения структурированных данных
- Автоматическая очистка связанных данных

### Порядок исполнения
Исполнять SQL начиная с 00 до 14, или использовать универсальный сценарий.