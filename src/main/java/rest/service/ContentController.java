package rest.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * Контроллер для получения конкретной личности из таблицы persons по id.
     */
    @RequestMapping("/api/get/person_page_rank/")
    public Content get(@RequestParam(value = "id") int id) {
        return new Content(id, new MySQLWorker().getPersonPageRank(id), new MySQLWorker().getPerson(id));
    }

    /**
     * Контроллер для добавления личности в таблицу persons.
     */
    @RequestMapping("/api/post/tables/persons")
    public String post(@RequestParam(value = "name") String name) {
        if (new MySQLWorker().addIntoTablePersons(name)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для редактирования имени личности в таблице persons по указанному id.
     */
    @RequestMapping("/api/put/tables/persons")
    public String put(@RequestParam(value = "id") int id,
                      @RequestParam(value = "value") String value) {
        if (new MySQLWorker().updateTablePersons(id, value)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для удаления элемента из указаной таблицы по указанному id.
     */
    @RequestMapping("/api/delete/tables")
    public String delete(@RequestParam(value = "table") String table,
                         @RequestParam(value = "id") int id) {
        if (new MySQLWorker().deleteFromTable(table, id)) {
            return DONE;
        }
        return ERROR;
    }

}
