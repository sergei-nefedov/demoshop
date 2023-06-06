# demoshop
Demo application (RESTful shop service)<br>
Демонстрационное приложение на базе Spring Boot, выполненное в соответствии с заданием (см. внизу страницы), реализующее функционал магазина. 
Реализовано с использованием H2 database, Spring JPA, Spring Web, Spring Validation, Lombok.

Инструкция по запуску и примеры запросов:

Запуск производится через метод main класса DemoshopApplication, находящегося в пакете pers/nefedov/demoshop (путь от корневого каталога - src/main/java/pers/nefedov/demoshop).

Примеры GET-запросов для получения информации о всех товаров в категории:<br>
http://localhost:8080/desktops/all      - для настольных компьютеров;<br>
http://localhost:8080/monitors/all      - для мониторов;<br>
http://localhost:8080/notebooks/all     - для ноутбуков;<br>
http://localhost:8080/harddrives/all    - для жестких дисков.<br>

Примеры GET-запросов для получения информации о товаре определенной категории по его идентификационному номеру (в примерах id = 1):<br>
http://localhost:8080/desktops/1        - для настольных компьютеров;<br>
http://localhost:8080/monitors/1        - для мониторов;<br>
http://localhost:8080/notebooks/1       - для ноутбуков;<br>
http://localhost:8080/harddrives/1      - для жестких дисков.<br>

Примеры POST-запросов для добавления товара определенной категории:<br>
http://localhost:8080/desktops/add      - для настольных компьютеров;<br>
{<br>
    "formFactor": "DESKTOP",<br>
    "serialNumber": 91,<br>
    "manufacturer": "No name",<br>
    "price": 11000,<br>
    "quantity": 3<br>
}<br>
http://localhost:8080/notebooks/add     - для ноутбуков;<br>
{<br>
    "size": 15,<br>
    "serialNumber": 22222222,<br>
    "manufacturer": "Notebook Manufacturer",<br>
    "price": 10000,<br>
    "quantity": 1<br>
}<br>
http://localhost:8080/harddrives/add    - для жестких дисков;<br>
{<br>
    "capacity": 4000,<br>
    "serialNumber": 8989,<br>
    "manufacturer": "Hard Disk Manufacturer",<br>
    "price": 7500,<br>
    "quantity": 20<br>
}<br>
http://localhost:8080/monitors/add      - для мониторов.<br>
{<br>
    "diagonalSize": 19,<br>
    "serialNumber": 1000,<br>
    "manufacturer": "Monitor Manufacturer",<br>
    "price": 9000,<br>
    "quantity": 10<br>
}<br>

Примеры POST-запросов для редактирования товара определенной категории по его идентификационному номеру (в примерах id = 1):<br>
http://localhost:8080/desktops/update     - для настольных компьютеров;<br>
{<br>
    "formFactor": "DESKTOP",<br>
    "serialNumber": 20002,<br>
    "manufacturer": "Desktop Manufacturer",<br>
    "price": 182000,<br>
    "quantity": 9,<br>
    "id": 1<br>
}<br>
http://localhost:8080/notebooks/update    - для ноутбуков;<br>
{<br>
    "size": "17",<br>
    "serialNumber": 22222222,<br>
    "manufacturer": "Notebook Manufacturer",<br>
    "price": 10000,<br>
    "quantity": 1,<br>
    "id": 1<br>
}<br>
http://localhost:8080/harddrives/update   - для жестких дисков;<br>
{<br>
    "capacity": "1000",<br>
    "serialNumber": 101010,<br>
    "manufacturer": "Hard Disk Manufacturer",<br>
    "price": 3500,<br>
    "quantity": 2,<br>
    "id": 1<br>
}<br>
http://localhost:8080/monitors/update     - для мониторов.<br>
{<br>
    "diagonalSize": "24",<br>
    "serialNumber": 55555,<br>
    "manufacturer": "Monitor Manufacturer",<br>
    "price": 10000,<br>
    "quantity": 3,<br>
    "id": 1<br>
}

___________________________________________________________________________________________________________________________________________________________________________
Цель:<br>
Cоздать небольшое приложение на базе Spring Boot.<br>
Задание:<br>
Магазин, торгующий компьютерами и комплектующими со следующим типом товаров:<br>
<ul>
● Настольные компьютеры<br>
● Ноутбуки<br>
● Мониторы<br>
● Жесткие диски<br>
</ul>
Каждый товар имеет следующие свойства:<br>
<ul>
● номер серии<br>
● производитель<br>
● цена<br>
● количество единиц продукции на складе<br>
</ul>
Дополнительные свойства:<br>
<ul>
● Настольные компьютеры имеют форм-фактор: десктопы, неттопы, моноблоки<br>
● Ноутбуки подразделяются по размеру: 13, 14, 15, 17 дюймовые<br>
● Мониторы имеют диагональ<br>
● Жесткие диски имеют объем<br>
</ul>
Необходимо реализовать back-end приложение, которое имеет RESTful HTTP методы выполняющие:<br>
<ol>
1. Добавление товара<br>
2. Редактирование товара<br>
3. Просмотр всех существующих товаров по типу<br>
4. Просмотр товара по идентификатору<br>
</ol>
В качестве базы данных использовать in memory database, например H2<br>
В README.md файле репозитория должна быть подробная инструкция по запуску приложения.
