package rest.service.controllers;

import org.springframework.web.bind.annotation.*;
import rest.service.StatusCodes;
import rest.service.api.MySQLWorker;

import java.util.ArrayList;

/**
 * Created by Валентин Фалин on 25.04.2017.
 */
@RestController
@RequestMapping(value = "/api/persons")
public class PersonsController {
    private final String TABLE = "persons";

    /**
     * Контроллер для получения всех личностей и общего количества их упоминаний из таблицы persons.
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ArrayList<?> getPersons() {
        return new MySQLWorker().getPersons();
    }

    /**
     * Контроллер для добавления личности в таблицу persons.
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String deleteFromPersons(@RequestParam("name") String name) {
        if (new MySQLWorker().addIntoTablePersons(name)) {
            return StatusCodes.DONE;
        }
        return StatusCodes.ERROR;
    }

    /**
     * Контроллер для редактирования имени личности в таблице persons по указанному id.
     */
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public String updateTablePersons(@RequestParam("id") int id,
                                     @RequestParam("name") String name) {
        if (new MySQLWorker().updateTablePersons(id, name)) {
            return StatusCodes.DONE;
        }
        return StatusCodes.ERROR;
    }

    /**
     * Контроллер для удаления элемента из таблицы sites по указанному id.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteFromTable(@PathVariable("id") int id) {
        if (new MySQLWorker().deleteFromTable(TABLE, id)) {
            return StatusCodes.DONE;
        }
        return StatusCodes.ERROR;
    }
}
