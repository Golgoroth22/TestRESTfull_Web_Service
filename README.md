# TestRESTfull_Web_Service
Стажировка GeekBrains. REST WEB-Service.

Собираем проект, запускаем main-класс Application.

Запросы шлем в json формате на указанный url c указанными параметрами.


					
<pre>	     URL	 Параметры	HTTP операция	Описание
		 
	api/sites/	 "name"        PUT         Добавление нового элемента в таблицу sites из json формата	
                     "base_url"	
				
    api/sites/       "id"          POST        Обновление элемента в таблице sites по данным из json формата
                     "name"
                     "base_url"	
				
	api/sites/1       -	       DELETE	   Удаление элемента из таблицы sites по указанному id параметром в конце формы http запроса	
					
	api/persons/     "name"	       PUT	   Добавление нового элемента в таблицу persons из json формата	
	
	api/persons/     "id"          POST	   Обновление элемента в таблице persons по данным из json формата	
                     "name"        
				 
	api/persons/1     -	       DELETE	   Удаление элемента из таблицы persons по указанному id параметром в конце формы http запроса		
					
	api/keywords/    "name"        PUT	   Добавление нового элемента в таблицу keywords из json формата
                     "person_id"
				  
	api/keywords/    "id"          POST	   Обновление элемента в таблице keywords по данным из json формата	
                     "name"
                     "person_id"	
				  
	api/keywords/1	   -	       DELETE	   Удаление элемента из таблицы keywords по указанному id параметром в конце формы http запроса	<\pre>
					
