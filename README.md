## Инструкция по запуску

Для запуска приложения выполните следующие шаги:

1. Убедитесь, что у вас установлен Java 17 и Maven.
2. Склонируйте репозиторий на свою локальную машину:
   ```.bash
   git clone https://github.com/AndreySavu/groups-app.git
   cd groups-app
   ```
3. Создайте базу данный MySQL
    ```
    CREATE DATABASE university;
    ```
   Или настройте подключения к базе данных в файле `application.properties`, используя следующие параметры:
   
 ```
    spring.datasource.url=jdbc:mysql://localhost:3306/university
    spring.datasource.username=user
    spring.datasource.password=password
 ```
   
4. Запустите приложение с помощью Maven:
   
```.bash
   mvn clean install
   mvn spring-boot:run
```
## Документация

1. http://localhost:8080/groups - получение списка групп
2. http://localhost:8080/groups/{groupId}/students - получение списка студентов в определенной группе
