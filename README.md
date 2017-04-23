# TestRESTfull_Web_Service
Стажировка GeekBrains. REST WEB-Service.

Собираем проект, запускаем main-класс Application

# - Синтаксисы запроса общие для всех таблиц:
<pre><b><li> 1. Удаление элемента из указанной таблицы по указанному id</li></b></pre>
<pre><b>           САЙТ/api/delete/tables/"нужная таблица"/"нужное id"</b>

   Пример: САЙТ/api/delete/tables/persons/23
   Результат: DONE - если удаление прошло удачно
              ERROR - если произошла ошибка</pre>

# - Синтаксисы запроса к конкретным таблицам:
# -             1. Таблица Persons
<pre><b><li> 1.1 Добавление личности в таблицу persons</li></b></pre>
<pre><b>           САЙТ/api/post/tables/persons/"Новый элемент"</b>

   Пример: САЙТ/api/post/tables/persons/Дональд Трамп
   Результат: DONE - если добавление прошло удачно
              ERROR - если произошла ошибка</pre>
              
<pre><b><li> 1.2 Редактирование личности в таблице persons</li></b></pre>
<pre><b>           САЙТ/api/put/tables/persons/"нужный id"/"Новое имя элемента"</b>

   Пример: САЙТ/api/put/tables/persons/4/Барак Обама
   Результат: DONE - если добавление прошло удачно
              ERROR - если произошла ошибка</pre>
# -             2. Таблица Sites
<pre><b><li> 2.1 Добавление нового сайта в таблицу sites</li></b></pre>
<pre><b>           САЙТ/api/post/tables/sites/"Название сайта"/?base_url="Ссылка на сайт"</b>

   Пример: САЙТ/api/post/tables/sites/VK/?base_url=http://vk.com
   Результат: DONE - если добавление прошло удачно
              ERROR - если произошла ошибка</pre>
              
<pre><b><li> 2.2 Редактирование данных в таблице sites</li></b></pre>
<pre><b>           САЙТ/api/put/tables/sites/"id сайта"/"Новое название сайта"/?base_url="Новая ссылка на сайт"</b>

   Пример: САЙТ/api/put/tables/sites/2/VKontakte/?base_url=http://vkontakte.ru
   Результат: DONE - если добавление прошло удачно
              ERROR - если произошла ошибка</pre>
# -             2. Таблица Keywords
<pre><b><li> 2.1 Добавление нового ключа в таблицу keywords</li></b></pre>
<pre><b>           САЙТ/api/post/tables/keywords/"Новый ключ"/"id личности к которой привязать ключ"</b>

   Пример: САЙТ/api/post/tables/keywords/Медвед/3
   Результат: DONE - если добавление прошло удачно
              ERROR - если произошла ошибка</pre>
              
<pre><b><li> 2.2 Редактирование данных в таблице keywords</li></b></pre>
<pre><b>           САЙТ/api/put/tables/keywords/"id ключа"/"Новое имя ключа"/"новое id личности к которой привязать ключ"</b>

   Пример: САЙТ/api/put/tables/keywords/2/Димон/3
   Результат: DONE - если добавление прошло удачно
              ERROR - если произошла ошибка</pre>


