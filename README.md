# TestRESTfull_Web_Service
Стажировка GeekBrains. REST WEB-Service.

Собираем проект, запускаем main-класс Application

# - Синтаксисы запроса общие:
<pre><b><li> 1. Получение общей статистики для одной конкретной личности по id из таблицы persons</li></b></pre>
<pre><b>           САЙТ/api/GET/person_page_rank/?id="нужный id"</b>

   Пример: САЙТ/api/GET/person_page_rank/?id=1
   Результат: {"id":1,"coincidences":3,"person":"Алексей Навальный"}
</pre>
<pre><b><li> 2. Удаление из указанной таблицы по указанному id</li></b></pre>
<pre><b>           САЙТ/api/delete/tables?table="нужная таблица"&id="нужное id"</b>

   Пример: САЙТ/api/delete/tables?table=persons&id=23
   Результат: DONE - если удаление прошло удачно
              ERROR - если произошла ошибка</pre>

# - Синтаксисы запроса к конкретным таблицам:
# -             1. Таблица Persons
<pre><b><li> 1.1 Добавление личности в таблицу persons</li></b></pre>
<pre><b>           САЙТ/api/post/tables/persons/?name="Личность"</b>

   Пример: САЙТ/api/post/tables/persons?name=Дональд Трамп
   Результат: DONE - если добавление прошло удачно
              ERROR - если произошла ошибка</pre>
              
<pre><b><li> 1.2 Редактирование личности в таблице persons</li></b></pre>
<pre><b>           САЙТ/api/put/tables/persons?id="нужный id"&name="Новое имя"</b>

   Пример: САЙТ/api/put/tables/persons?id=4&name=Барак Обама
   Результат: Результат: DONE - если добавление прошло удачно
              ERROR - если произошла ошибка</pre>


