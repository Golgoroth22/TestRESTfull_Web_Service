package rest.service.controllers;

import org.springframework.web.bind.annotation.*;
import rest.service.api.MySQLWorker;

/**
 * Created by Валентин Фалин on 14.04.2017.
 */

/**
 * Класс для управления и навигации по методам в сервисе.
 */
@RestController
@RequestMapping(value = "/api/delete")
public class ContentController {
    private final String ERROR = "ERROR";
    private final String DONE = "DONE";

    /**
     * Контроллер для удаления элемента из указаной таблицы по указанному id.
     */
    @RequestMapping(value = "/{table}/{id}", method = RequestMethod.GET)
    public String deleteFromTable(@PathVariable("table") String table,
                                  @PathVariable("id") int id) {
        if (new MySQLWorker().deleteFromTable(table, id)) {
            return DONE;
        }
        return ERROR;
    }
}
