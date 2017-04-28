package rest.service.controllers;

import org.springframework.web.bind.annotation.*;
import rest.service.Errors;
import rest.service.api.MySQLWorker;

/**
 * Created by Валентин Фалин on 25.04.2017.
 */
@RestController
@RequestMapping(value = "/api/persons")
public class PersonsController {
    private final String TABLE = "persons";

    /**
     * Контроллер для добавления личности в таблицу persons.
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String deleteFromPersons(@RequestParam("name") String name) {
        if (new MySQLWorker().addIntoTablePersons(name)) {
            return Errors.DONE;
        }
        return Errors.ERROR;
    }

    /**
     * Контроллер для редактирования имени личности в таблице persons по указанному id.
     */
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public String updateTablePersons(@RequestParam("id") int id,
                                     @RequestParam("name") String name) {
        if (new MySQLWorker().updateTablePersons(id, name)) {
            return Errors.DONE;
        }
        return Errors.ERROR;
    }

    /**
     * Контроллер для удаления элемента из таблицы sites по указанному id.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteFromTable(@PathVariable("id") int id) {
        if (new MySQLWorker().deleteFromTable(TABLE, id)) {
            return Errors.DONE;
        }
        return Errors.ERROR;
    }
}
