package rest.service;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Валентин Фалин on 14.04.2017.
 */

/**
 * Класс для управления и навигации по методам в сервисе.
 */
@RestController
public class ContentController {
    private final String ERROR = "ERROR";
    private final String DONE = "DONE";

    /**
     * Контроллер для добавления личности в таблицу persons.
     */
    @RequestMapping(value = "/api/post/tables/persons/{name}", method = RequestMethod.GET)
    public String addIntoTablePersons(@PathVariable("name") String name) {
        if (new MySQLWorker().addIntoTablePersons(name)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для редактирования имени личности в таблице persons по указанному id.
     */
    @RequestMapping(value = "/api/put/tables/persons/{id}/{name}", method = RequestMethod.GET)
    public String updateTablePersons(@PathVariable("id") int id,
                                     @PathVariable("name") String name) {
        if (new MySQLWorker().updateTablePersons(id, name)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для удаления элемента из указаной таблицы по указанному id.
     */
    @RequestMapping(value = "/api/delete/tables/{table}/{id}", method = RequestMethod.GET)
    public String deleteFromTable(@PathVariable("table") String table,
                                  @PathVariable("id") int id) {
        if (new MySQLWorker().deleteFromTable(table, id)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для добавления сайта в таблицу sites.
     */
    @RequestMapping(value = "/api/post/tables/sites/{name}/", method = RequestMethod.GET)
    public String addIntoTableSites(@PathVariable("name") String name,
                                    @RequestParam("base_url") String base_url) {
        if (new MySQLWorker().addIntoTableSites(name, base_url)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для редактирования значений из таблицы sites.
     */
    @RequestMapping(value = "/api/put/tables/sites/{id}/{name}/", method = RequestMethod.GET)
    public String updateTableSites(@PathVariable("id") int id,
                                   @PathVariable("name") String name,
                                   @RequestParam("base_url") String base_url) {
        if (new MySQLWorker().updateTableSites(id, name, base_url)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для добавления ключа в таблицу keywords.
     */
    @RequestMapping(value = "/api/post/tables/keywords/{name}/{person_id}", method = RequestMethod.GET)
    public String addIntoTableKeywords(@PathVariable("name") String name,
                                       @PathVariable("person_id") int person_id) {
        if (new MySQLWorker().addIntoTableKeywords(name, person_id)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для редактирования значений в таблице keywords.
     */
    @RequestMapping(value = "/api/put/tables/keywords/{id}/{name}/{person_id}", method = RequestMethod.GET)
    public String updateTableKeywords(@PathVariable("id") int id,
                                      @PathVariable("name") String name,
                                      @PathVariable("person_id") int person_id) {
        if (new MySQLWorker().updateTableKeywords(id, name, person_id)) {
            return DONE;
        }
        return ERROR;
    }
}
