package rest.service.controllers;

import org.springframework.web.bind.annotation.*;
import rest.service.api.MySQLWorker;

/**
 * Created by Валентин Фалин on 25.04.2017.
 */
@RestController
public class SitesController {
    private final String ERROR = "ERROR";
    private final String DONE = "DONE";

    /**
     * Контроллер для добавления сайта в таблицу sites.
     */
    @RequestMapping(value = "/api/put/tables/sites/{name}/", method = RequestMethod.GET)
    public String addIntoTableSites(@PathVariable("name") String name,
                                    @RequestParam("base_url") String base_url) {
        if (new MySQLWorker().addIntoTableSites(name, base_url)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для редактирования значений из таблицы sites.
     */
    @RequestMapping(value = "/api/post/tables/sites/{id}/{name}/", method = RequestMethod.GET)
    public String updateTableSites(@PathVariable("id") int id,
                                   @PathVariable("name") String name,
                                   @RequestParam("base_url") String base_url) {
        if (new MySQLWorker().updateTableSites(id, name, base_url)) {
            return DONE;
        }
        return ERROR;
    }
}
