# TestRESTfull_Web_Service
Стажировка GeekBrains. REST WEB-Service.

Собираем проект, запускаем main-класс Application

# - Синтаксисы запроса:
<pre><b><li> 1. Получение общей статистики для одной конкретной личности по id из таблицы persons</li></b></pre>
<pre><b>           САЙТ/api/GET/person_page_rank/?id="нужный id"</b>

   Пример: САЙТ/api/GET/person_page_rank/?id=1
   Результат: {"id":1,"coincidences":3,"person":"Алексей Навальный"}
</pre>

<pre><b><li> 2. Добавление личности в таблицу persons</li></b></pre>
<pre><b>           САЙТ/api/POST/persons/?name="Личность"</b>

   Пример: САЙТ/api/POST/persons/?name=Дональд Трамп
   Результат: DONE - если добавление прошло удачно
              ERROR - если произошла ошибка</pre>
