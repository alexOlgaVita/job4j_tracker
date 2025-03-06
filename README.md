# job4j_tracker

## О проекте

![CI GitHubAction](https://github.com/peterarsentev/job4j_tracker/actions/workflows/maven.yml/badge.svg)

Консольное приложение. Пользователю отображается меню с возможностями программы.
Программа может:
1. Добавлять заявку.
2. Заменять заявку на новую заявку по ID.
3. Удалять заявку по ID.
4. Отображать список всех заявок.
5. Производить поиск по имени заявки.

### Стек технологий
Java 17, JUnit 5, Liquibase 4.28.0, PostgreSQL 42, Hibernate 5.6.11.Final, H2 2.2.224, Mockito 5.2.0, Lombok 1.18.30, MapStruct 1.5.5.Final

### Требования к окружению
Java 17, Maven 3.4.0, PostgreSQL

### Запуск проекта

``` create database tracker;  ```
``` mvn clean install  `

### Взаимодействие с приложением

#### Скриншоты

##### *Старт*
![Старт](images/start.jpg)

##### *Все заявки - заявок нет*
![Все заявки - заявок нет](images/listEmpty.jpg)

##### *Создать заявку*
![Создать заявку](images/create.jpg)

##### *Все заявки*
![Все заявки](images/listNotEmpty.jpg)

##### *Изменить заявку - ошибка*
![Изменить заявку - ошибка](images/changeFail.jpg)

##### *Изменить заявку*
![Изменить заявку](images/change.jpg)

##### *Все заявки - после изменения*
![Все заявки - после изменения](images/listNotEmptyAfterChange.jpg)

##### *Показать заявку по id - ошибка*
![Показать заявку по id - ошибка](images/showByIdFail.jpg)

##### *Показать заявку по id*
![Показать заявку по id](images/showById.jpg)

##### *Показать заявку по имени - ошибка*
![Показать заявку по имени - ошибка](images/showByNameFail.jpg)

##### *Показать заявку по имени*
![Показать заявку по имени](images/showByName.jpg)

##### *Удалить заявку - ошибка*
![Удалить заявку - ошибка](images/deleteFail.jpg)

##### *Удалить заявку*
![Удалить заявку](images/delete.jpg)

##### *Все заявки - после удаления*
![Все заявки - после удаления](images/listAfterDelete.jpg)

##### *Создать несколько заявок*
![Создать несколько заявок](images/createMany.jpg)

##### *Удалить все заявки*
![Удалить все заявки](images/deleteAll.jpg)

##### *Выход*
![Выход](images/exit.jpg)

### Контакты

![Ильина Ольга](images/olga.jpg)

- Telegram: [@OlgaIlyina0312](https://t.me/OlgaIlyina0312)
- Email:    [oliljina@mail.ru](oliljina@mail.ru)