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

    /**
     * Контроллер для получения конкретной личности из таблицы persons по id.
     */
    @RequestMapping("/api/GET/person_page_rank/")
    public Content get(@RequestParam(value = "id", defaultValue = "0") int id) {
        return new Content(id, new MySQLWorker().getPersonPageRank(id), new MySQLWorker().getPerson(id));
    }

    /**
     * Контроллер для добавления личности в таблицу persons.
     */
    @RequestMapping("/api/POST/persons/")
    public String put(@RequestParam(value = "name", defaultValue = "NULL") String name) {
        if (new MySQLWorker().addPerson(name)) {
            return "DONE";
        }
        return "ERROR";
    }
}
