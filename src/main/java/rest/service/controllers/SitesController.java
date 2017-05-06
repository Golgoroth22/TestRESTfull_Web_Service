package rest.service.controllers;

import org.springframework.web.bind.annotation.*;
import rest.service.StatusCodes;
import rest.service.api.MySQLWorker;

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
    //curl -X PUT -d "name=VK&base_url=http://vk.com" "http://localhost:8080/api/sites/"
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String addIntoTableSites(@RequestParam("name") String name,
                                    @RequestParam("base_url") String base_url,
                                    @RequestParam("open_tag") String open_tag,
                                    @RequestParam("open_tag") String close_tag) {
        if (new MySQLWorker().addIntoTableSites(name, base_url, open_tag, close_tag)) {
            return StatusCodes.DONE;
        }
        return StatusCodes.ERROR;
    }

    /**
     * Контроллер для редактирования значений из таблицы sites.
     */
    //curl -X POST -d "id=2&name=VK&base_url=http://vk.com" "http://localhost:8080/api/sites/"
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public String updateTableSites(@RequestParam("id") int id,
                                   @RequestParam("name") String name,
                                   @RequestParam("base_url") String base_url) {
        if (new MySQLWorker().updateTableSites(id, name, base_url)) {
            return StatusCodes.DONE;
        }
        return StatusCodes.ERROR;
    }

    /**
     * Контроллер для удаления элемента из таблицы sites по указанному id.
     */
    //curl -X DELETE "http://localhost:8080/api/sites/2"
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteFromTable(@PathVariable("id") int id) {
        if (new MySQLWorker().deleteFromTable(TABLE, id)) {
            return StatusCodes.DONE;
        }
        return StatusCodes.ERROR;
    }
}
