package rest.service;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Валентин Фалин on 14.04.2017.
 */

/**
 * Класс для управления и навигации по методам в сервисе.
 */
@RestController
@RequestMapping(value = "/api/table/")
public class ContentController {
    private final String ERROR = "ERROR";
    private final String DONE = "DONE";

    /**
     * Контроллер для получения информции о персоне.
     * GET: /api/table/persons/{id}
     */
    @RequestMapping(value = "persons/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getPerson(
            @PathVariable("id") Integer id
    ) {
        return ERROR + id;

    }

    /**
     * Контроллер для получения информции о персоне.
     * GET: /api/table/persons/
     */
    @RequestMapping(value = "persons/", method = RequestMethod.GET, produces = "application/json")
    public String getAllPerson(
    ) {
        return ERROR;
    }

    /**
     * Контроллер для обновления имени личности в таблице persons.
     * POST: /api/table/persons/
     * <form action="/api/table/persons/" method="POST">
     * <input type="text" name="id" value="1"/>
     * <input type="text" name="name" value="test123"/>
     * <button type="submit">Отправить</button>
     * </form>
     * curl -X POST -H "Content-Type: multipart/form-data;" -F "id=1" -F "name="test123" "http://localhost:8080/api/table/persons/"
     */
    @RequestMapping(value = "persons/", method = RequestMethod.POST, produces = "application/json")
    public String updatePersons(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "name") String name
    ) {
        if (new MySQLWorker().updateTablePersons(id, name)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для удаления элемента из таблицы persons
     * curl -X DELETE "http://localhost:8080/api/table/persons/1"
     */
    @RequestMapping(value = "persons/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteFromPersons(
            @PathVariable("id") Integer id
    ) {
        if (new MySQLWorker().deleteFromTable("persons", id)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для добавления сайта в таблицу sites.
     */
    @RequestMapping("/api/post/tables/sites")
    public String addIntoTableSites(@RequestParam(value = "name") String name,
                                    @RequestParam(value = "base_url") String base_url) {
        if (new MySQLWorker().addIntoTableSites(name, base_url)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для редактирования значений из таблицы sites.
     */
    @RequestMapping("/api/put/tables/sites")
    public String updateTableSites(@RequestParam(value = "id") int id,
                                   @RequestParam(value = "name") String name,
                                   @RequestParam(value = "base_url") String base_url) {
        if (new MySQLWorker().updateTableSites(id, name, base_url)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для добавления ключа в таблицу keywords.
     */
    @RequestMapping("/api/post/tables/keywords")
    public String addIntoTableKeywords(@RequestParam(value = "name") String name,
                                       @RequestParam(value = "person_id") int person_id) {
        if (new MySQLWorker().addIntoTableKeywords(name, person_id)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для редактирования значений в таблице keywords.
     */
    @RequestMapping("/api/put/tables/keywords")
    public String updateTableKeywords(@RequestParam(value = "id") int id,
                                      @RequestParam(value = "name") String name,
                                      @RequestParam(value = "person_id") int person_id) {
        if (new MySQLWorker().updateTableKeywords(id, name, person_id)) {
            return DONE;
        }
        return ERROR;
    }
}
