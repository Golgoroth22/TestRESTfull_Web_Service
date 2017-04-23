package rest.service.api.sites;

import org.springframework.web.bind.annotation.*;
import rest.service.MySQLWorker;

/**
 * Created by favor1t on 23.04.2017.
 */
@RestController
@RequestMapping(value = "/api/sites/")
public class SitesController {

    private final String ERROR = "{\"status\" : ERROR}";
    private final String DONE = "{\"status\" : DONE}";

    /**
     * Контроллер для получения информции о персоне.
     * GET: /api/table/persons/{id}
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public String getById(
            @PathVariable("id") Integer id
    ) {
        return ERROR;

    }

    /**
     * Контроллер для получения информции о персоне.
     * GET: /api/table/persons/
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String getAll(
    ) {
        return ERROR;
    }

    /**
     * Контроллер для обновления имени личности в таблице persons.
     * POST: /api/table/persons/
     * <form action="/api/table/persons/" method="POST">
     * <input type="text" name="id" value="1"/>
     * <input type="text" name="name" value="yandex.ru"/>
     * <input type="text" name="base_url" value="http://yandex.ru"/>
     * <button type="submit">Отправить</button>
     * </form>
     * curl -X POST -H "Content-Type: multipart/form-data;" -F "id=1" -F "name=yandex.ru" -F "base_url=http://yandex.ru" "http://localhost:8080/api/sites/"
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String update(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "base_url") String base_url
    ) {
        if (new MySQLWorker().updateTableSites(id, name, base_url)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для удаления элемента из таблицы persons
     * curl -X DELETE "http://localhost:8080/api/sites/1"
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String delete(
            @PathVariable("id") Integer id
    ) {
        if (new MySQLWorker().deleteFromTable("sites", id)) {
            return DONE;
        }
        return ERROR;
    }

    /**
     * Контроллер для добавления элемента из таблицы persons
     * curl -X PUT -d "name=yandex.ru&base_url=http://yandex.ru" "http://localhost:8080/api/sites/"
     */
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public String deleteFromPersons(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "base_url") String base_url
    ) {
        if (new MySQLWorker().addIntoTableSites(name, base_url)) {
            return DONE;
        }
        return ERROR;
    }

}
