# TestRESTfull_Web_Service
Стажировка GeekBrains. REST WEB-Service.

Собираем проект, запускаем main-класс Application.

# Запросы для администратора:
Запросы шлем в json формате на указанный url c указанными параметрами.


					
	     URL     Входные параметры	 HTTP операция	Описание
		 
	api/sites/	 "name"         POST        Добавление нового элемента в таблицу sites из json формата
                     "base_url"	
		         "open_tag"
		         "close_tag"
				
    api/sites/       "id"           PUT         Обновление элемента в таблице sites по данным из json формата
                     "name"
                     "base_url"	
				
	api/sites/1       -	        DELETE	    Удаление элемента из таблицы sites по указанному id параметром в конце формы http запроса	
	
	api/sites/        -             GET         Получение всех элеметов из таблицы sites
	
	api/persons/     "name"	        POST        Добавление нового элемента в таблицу persons из json формата
	
	api/persons/     "id"           PUT 	    Обновление элемента в таблице persons по данным из json формата
                     "name"        
				 
	api/persons/1     -	        DELETE	    Удаление элемента из таблицы persons по указанному id параметром в конце формы http запроса		
	
	api/persons/      -             GET         Получение всех элеметов из таблицы persons
					  
	api/keywords/    "name"         POST	    Добавление нового элемента в таблицу keywords из json формата
                     "person_id"
				  
	api/keywords/    "id"           PUT	    Обновление элемента в таблице keywords по данным из json формата
                     "name"
                     "person_id"	
				  
	api/keywords/1	   -	        DELETE	    Удаление элемента из таблицы keywords по указанному id параметром в конце формы http запроса	
	
	api/keywords/1    -             GET         Получение всех элеметов из таблицы keywords по указанному persons_id
	
	api/keywords/     -             GET         Получение всех элеметов из таблицы keywords
					
# Запросы для пользователя:
# 1.
<pre>
 <b>URL:                api/persons/id сайта из таблицы sites</b>
 
 Выходные параметры: "name" и "coincidences" для каждой личности
 
 HTTP операция:      GET
 
 Описание:           Получение списка всех личностей из таблицы persons и количества их упоминаний на выбранном сайте</pre>
 
 <pre><b>Пример:
 api/persons/1 </b>
 [
  {
    "name": "Владимир Путин",
    "coincidences": 3
  },
  {
    "name": "Дмитрий Медведев",
    "coincidences": 5
  }
]</pre>
# 2.
<pre>
 <b>URL:                api/persons/начальная дата/конечная дата/id сайта из таблицы sites/id личности из таблицы persons</b>
 
 Выходные параметры: "date" и "coincidences" для каждой даты
 
 HTTP операция:      GET
 
 Описание:           Получения всех упоминаний выбранной личности из таблицы persons по id за указанный диапазон дат.</pre>
 
 <pre><b>Пример:
 api/persons/2017-01-10/2017-04-11/1/1</b>
 [
  {
    "date": "2017-01-11 17:00:00.0",
    "coincidences": 2
  },
  {
    "date": "2017-02-12 00:19:00.0",
    "coincidences": 1
  },
  {
    "date": "2017-03-12 03:17:00.0",
    "coincidences": 2
  }
]</pre>
 
                        
