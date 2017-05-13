package rest.service.controllers;

import org.springframework.web.bind.annotation.*;
import rest.service.StatusCodes;
import rest.service.api.MySQLWorker;
import rest.service.api.models.Site;

import java.util.ArrayList;

/**
 * Created by Валентин Фалин on 25.04.2017.
 */
@RestController
@RequestMapping(value = "/api/sites")
public class SitesController {
    private final String TABLE = "sites";

    /**
     * Контроллер для добавления сайта в таблицу sites.
     */
    //curl -H "Content-Type: application/json" -X PUT -d "name=VK&base_url=http://vk.com" "http://localhost:8080/api/sites/"
    @RequestMapping(method = RequestMethod.POST)
    public String addIntoTableSites(@RequestBody Site site) {
        if (new MySQLWorker().addIntoTableSites(site)) {
            return StatusCodes.DONE;
        }
        return StatusCodes.ERROR;
    }

    /**
     * Контроллер для редактирования значений из таблицы sites.
     */
    //curl -H "Content-Type: application/json" -X POST -d "id=2&name=VK&base_url=http://vk.com" "http://localhost:8080/api/sites/"
    @RequestMapping(method = RequestMethod.PUT)
    public String updateTableSites(@RequestBody Site site) {
        if (new MySQLWorker().updateTableSites(site)) {
            return StatusCodes.DONE;
        }
        return StatusCodes.ERROR;
    }

    /**
     * Контроллер для удаления элемента из таблицы sites по указанному id.
     */
    //curl -X DELETE "http://localhost:8080/api/sites/2"
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deleteFromTable(@PathVariable("id") int id) {
        if (new MySQLWorker().deleteFromTable(TABLE, id)) {
            return StatusCodes.DONE;
        }
        return StatusCodes.ERROR;
    }

    /**
     * Контроллер для получения сайтов из таблицы sites.
     */
    //curl -X GET "http://localhost:8085/api/sites" 
    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<?> getAllSites() {
        return new MySQLWorker().getAllSites();
    }
}
