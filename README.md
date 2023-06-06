# demoshop
Demo application (RESTful shop service)<br>
Демонстрационное приложение на базе Spring Boot, выполненное в соответствии с заданием (см. внизу страницы), реализующее функционал магазина.

Инструкция по запуску и примеры запросов:

Запуск производится через метод main класса DemoshopApplication, находящегося в пакете pers/nefedov/demoshop (путь от корневого каталога - src/main/java/pers/nefedov/demoshop).

Примеры GET-запросов для получения информации о всех товаров в категории:
http://localhost:8080/desktops/all      - для настольных компьютеров;
http://localhost:8080/monitors/all      - для мониторов;
http://localhost:8080/notebooks/all     - для ноутбуков;
http://localhost:8080/harddrives/all    - для жестких дисков.

Примеры GET-запросов для получения информации о товаре определенной категории по его идентификационному номеру (в примерах id = 1):
http://localhost:8080/desktops/1        - для настольных компьютеров;
http://localhost:8080/monitors/1        - для мониторов;
http://localhost:8080/notebooks/1       - для ноутбуков;
http://localhost:8080/harddrives/1      - для жестких дисков.

Примеры POST-запросов для добавления товара определенной категории:
http://localhost:8080/desktops/add      - для настольных компьютеров;
{
    "formFactor": "DESKTOP",            
    "serialNumber": 91,                 
    "manufacturer": "No name",          
    "price": 11000,
    "quantity": 3
}
http://localhost:8080/notebooks/add     - для ноутбуков;
{
    "size": 15,
    "serialNumber": 22222222,
    "manufacturer": "Dell",
    "price": 10000,
    "quantity": 1
}
http://localhost:8080/harddrives/add    - для жестких дисков;
{
    "capacity": 4000,
    "serialNumber": 8989,
    "manufacturer": "Toshiba",
    "price": 7500,
    "quantity": 20
}
http://localhost:8080/monitors/add      - для мониторов.
{
    "diagonalSize": 19,
    "serialNumber": 1000,
    "manufacturer": "Dell",
    "price": 9000,
    "quantity": 10
}

Примеры POST-запросов для редактирования товара определенной категории по его идентификационному номеру (в примерах id = 1)::
http://localhost:8080/desktops/update     - для настольных компьютеров;
{
    "formFactor": "DESKTOP",
    "serialNumber": 20002,
    "manufacturer": "Apple",
    "price": 182000,
    "quantity": 9,
    "id": 1
}
http://localhost:8080/notebooks/update    - для ноутбуков;
{
    "size": "17",
    "serialNumber": 22222222,
    "manufacturer": "Dell",
    "price": 10000,
    "quantity": 1,
    "id": 1
}
http://localhost:8080/harddrives/update   - для жестких дисков;
{
    "capacity": "1000",
    "serialNumber": 101010,
    "manufacturer": "Western Union",
    "price": 3500,
    "quantity": 2,
    "id": 1
}
http://localhost:8080/monitors/update     - для мониторов.
{
    "diagonalSize": "24",
    "serialNumber": 55555,
    "manufacturer": "Dell",
    "price": 10000,
    "quantity": 3,
    "id": 1
}

___________________________________________________________________________________________________________________________________________________________________________
Цель:
Cоздать небольшое приложение на базе Spring Boot.
Задание:
Магазин, торгующий компьютерами и комплектующими со следующим типом товаров:
● Настольные компьютеры
● Ноутбуки
● Мониторы
● Жесткие диски
Каждый товар имеет следующие свойства:
● номер серии
● производитель
● цена
● количество единиц продукции на складе
Дополнительные свойства:
● Настольные компьютеры имеют форм-фактор: десктопы, неттопы, моноблоки
● Ноутбуки подразделяются по размеру: 13, 14, 15, 17 дюймовые
● Мониторы имеют диагональ
● Жесткие диски имеют объем
Необходимо реализовать back-end приложение, которое имеет RESTful HTTP методы
выполняющие:
1. Добавление товара
2. Редактирование товара
3. Просмотр всех существующих товаров по типу
4. Просмотр товара по идентификатору
В качестве базы данных использовать in memory database, например H2
В README.md файле репозитория должна быть подробная
инструкция по запуску приложения.
