# TestRESTfull_Web_Service
Стажировка GeekBrains. REST WEB-Service.

Собираем проект, запускаем main-класс Application.

# Запросы для администратора:
Запросы шлем в json формате на указанный url c указанными параметрами.


					
	     URL     Входные параметры	 HTTP операция	Описание
		 
	api/sites/	 "name"         POST        Добавление нового элемента в таблицу sites из json формата
                     "base_url"	
				
    api/sites/       "id"           PUT         Обновление элемента в таблице sites по данным из json формата
                     "name"
                     "base_url"	
				
	api/sites/1       -	        DELETE	    Удаление элемента из таблицы sites по указанному id параметром в конце формы http запроса	
					
	api/persons/     "name"	        POST        Добавление нового элемента в таблицу persons из json формата
	
	api/persons/     "id"           PUT 	    Обновление элемента в таблице persons по данным из json формата
                     "name"        
				 
	api/persons/1     -	        DELETE	    Удаление элемента из таблицы persons по указанному id параметром в конце формы http запроса		
					  
	api/keywords/    "name"         POST	    Добавление нового элемента в таблицу keywords из json формата
                     "person_id"
				  
	api/keywords/    "id"           PUT	    Обновление элемента в таблице keywords по данным из json формата
                     "name"
                     "person_id"	
				  
	api/keywords/1	   -	        DELETE	    Удаление элемента из таблицы keywords по указанному id параметром в конце формы http запроса	
					
# Запросы для пользователя:
<pre>
 <b>URL:                api/persons/</b>
 
 Выходные параметры: "name" и "coincidences" для каждой личности
 
 HTTP операция:      GET
 
 Описание:           Получение списка всех личностей из таблицы persons и количества их упоминаний</pre>
 
 <pre><b>Пример:</b>
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
 
                        
