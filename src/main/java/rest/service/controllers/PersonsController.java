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
@RequestMapping(value = "/api/persons")
public class PersonsController {
    private final String ERROR = "ERROR";
    private final String DONE = "DONE";

    /**
     * Контроллер для добавления личности в таблицу persons.
     */
    @RequestMapping(value = "/put/{name}", method = RequestMethod.GET)
    public String addIntoTablePersons(@PathVariable("name") String name) {
        if (new MySQLWorker().addIntoTablePersons(name)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для редактирования имени личности в таблице persons по указанному id.
     */
    @RequestMapping(value = "/post/{id}/{name}", method = RequestMethod.GET)
    public String updateTablePersons(@PathVariable("id") int id,
                                     @PathVariable("name") String name) {
        if (new MySQLWorker().updateTablePersons(id, name)) {
            return DONE;
        }
        return ERROR;
    }
}