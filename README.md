# bank-account

## Запуск приложения
 1 Упаковать проект командой mvn clean package
 2 Во время упаковки приложения запустится скрипт Liquibase, создастся таблица wallet и в неё попадут тестовые данные
 3 Выполнить команду docker-compose up для сборки проекта в контейнер
 4 Можно запускать postman тесты из папки postman для проверки работоспособности эндпоинтов
