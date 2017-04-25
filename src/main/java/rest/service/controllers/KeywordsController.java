package rest.service.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.service.api.MySQLWorker;

/**
 * Created by Валентин Фалин on 25.04.2017.
 */
@RestController
public class KeywordsController {
    private final String ERROR = "ERROR";
    private final String DONE = "DONE";

    /**
     * Контроллер для добавления ключа в таблицу keywords.
     */
    @RequestMapping(value = "/api/put/tables/keywords/{name}/{person_id}", method = RequestMethod.GET)
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
    @RequestMapping(value = "/api/post/tables/keywords/{id}/{name}/{person_id}", method = RequestMethod.GET)
    public String updateTableKeywords(@PathVariable("id") int id,
                                      @PathVariable("name") String name,
                                      @PathVariable("person_id") int person_id) {
        if (new MySQLWorker().updateTableKeywords(id, name, person_id)) {
            return DONE;
        }
        return ERROR;
    }
}
