package rest.service.controllers;

import org.springframework.web.bind.annotation.*;
import rest.service.StatusCodes;
import rest.service.api.MySQLWorker;
import rest.service.api.models.Keyword;

import java.util.ArrayList;

/**
 * Created by Валентин Фалин on 25.04.2017.
 */
@RestController
@RequestMapping(value = "/api/keywords")
public class KeywordsController {
    private final String TABLE = "keywords";

    /**
     * Контроллер для добавления ключа в таблицу keywords.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addIntoTableKeywords(@RequestBody Keyword keyword) {
        if (new MySQLWorker().addIntoTableKeywords(keyword)) {
            return StatusCodes.DONE;
        }
        return StatusCodes.ERROR;
    }

    /**
     * Контроллер для редактирования значений в таблице keywords.
     */
    @RequestMapping(method = RequestMethod.PUT)
    public String updateTableKeywords(@RequestBody Keyword keyword) {
        if (new MySQLWorker().updateTableKeywords(keyword)) {
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
     * Контроллер для получения всех ключевых слов из таблицы keywords.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<?> getAllKeywords() {
        return new MySQLWorker().getAllKeywords();
    }

    /**
     * Контроллер для получения ключевых слов из таблицы keywords по указанному person_id.
     */
    @RequestMapping(value = "{person_id}", method = RequestMethod.GET)
    public ArrayList<?> getAllKeywordsByPersonId(@PathVariable("person_id") int person_id) {
        return new MySQLWorker().getAllKeywordsByPersonId(person_id);
    }
}
