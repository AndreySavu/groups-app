## Инструкция по запуску

Для запуска приложения выполните следующие шаги:

1. Убедитесь, что у вас установлены Java 17, Docker, Maven.
2. Склонируйте репозиторий на свою локальную машину:
   ```bash
   git clone https://github.com/AndreySavu/groups-app.git
   cd groups-app
   ```
3. Запустите контейнер MySQL
   ```bash
   docker-compose up -d
   ```
4. Запустите приложение с помощью Maven:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
## Документация

1. http://localhost:8080/groups - получение списка групп
2. http://localhost:8080/groups/{groupId}/students - получение списка студентов в определенной группе
