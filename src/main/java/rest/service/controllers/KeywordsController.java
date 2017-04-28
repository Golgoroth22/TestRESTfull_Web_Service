package rest.service.controllers;

import org.springframework.web.bind.annotation.*;
import rest.service.api.MySQLWorker;

/**
 * Created by Валентин Фалин on 25.04.2017.
 */
@RestController
@RequestMapping(value = "/api/keywords")
public class KeywordsController {
    private final String TABLE = "keywords";
    private final String ERROR = "ERROR ";
    private final String DONE = "DONE";

    /**
     * Контроллер для добавления ключа в таблицу keywords.
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String addIntoTableKeywords(@RequestParam("name") String name,
                                       @RequestParam("person_id") int person_id) {
        if (new MySQLWorker().addIntoTableKeywords(name, person_id)) {
            return DONE;
        }
        return ERROR + name;
    }

    /**
     * Контроллер для редактирования значений в таблице keywords.
     */
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public String updateTableKeywords(@RequestParam("id") int id,
                                      @RequestParam("name") String name,
                                      @RequestParam("person_id") int person_id) {
        if (new MySQLWorker().updateTableKeywords(id, name, person_id)) {
            return DONE;
        }
        return ERROR + name;
    }

    /**
     * Контроллер для удаления элемента из таблицы sites по указанному id.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteFromTable(@PathVariable("id") int id) {
        if (new MySQLWorker().deleteFromTable(TABLE, id)) {
            return DONE;
        }
        return ERROR;
    }
}
