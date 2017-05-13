package rest.service.controllers;

import org.springframework.web.bind.annotation.*;
import rest.service.StatusCodes;
import rest.service.api.MySQLWorker;
import rest.service.api.models.Person;

import java.util.ArrayList;

/**
 * Created by Валентин Фалин on 25.04.2017.
 */
@RestController
@RequestMapping(value = "/api/persons")
public class PersonsController {
    private final String TABLE = "persons";

    /**
     * Контроллер для получения всех поминаний конкретной личности за указанный диапазон дат.
     */
    @RequestMapping(value = "{firstDate}/{lastDate}/{site_id}/{person_id}", method = RequestMethod.GET)
    public ArrayList<?> getPersonByDate(@PathVariable("firstDate") String firstDate,
                                        @PathVariable("lastDate") String lastDate,
                                        @PathVariable("site_id") int site_id,
                                        @PathVariable("person_id") int person_id) {
        return new MySQLWorker().getPersonByDate(site_id, person_id, firstDate, lastDate);
    }


    /**
     * Контроллер для получения всех личностей и общего количества их упоминаний из таблицы persons.
     */
    @RequestMapping(value = "{site_id}", method = RequestMethod.GET)
    public ArrayList<?> getPersons(@PathVariable("site_id") int site_id) {
        return new MySQLWorker().getPersons(site_id);
    }

    /**
     * Контроллер для добавления личности в таблицу persons.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String deleteFromPersons(@RequestBody Person person) {
        if (new MySQLWorker().addIntoTablePersons(person)) {
            return StatusCodes.DONE;
        }
        return StatusCodes.ERROR;
    }

    /**
     * Контроллер для редактирования имени личности в таблице persons по указанному id.
     */
    @RequestMapping(method = RequestMethod.PUT)
    public String updateTablePersons(@RequestBody Person person) {
        if (new MySQLWorker().updateTablePersons(person)) {
            return StatusCodes.DONE;
        }
        return StatusCodes.ERROR;
    }

    /**
     * Контроллер для удаления элемента из таблицы sites по указанному id.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deleteFromTable(@PathVariable("id") int id) {
        if (new MySQLWorker().deleteFromTable(TABLE, id)) {
            return StatusCodes.DONE;
        }
        return StatusCodes.ERROR;
    }

    /**
     * Контроллер для получения всех личностей из таблицы persons.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<?> getAllPersons() {
        return new MySQLWorker().getAllPersons();
    }
}
