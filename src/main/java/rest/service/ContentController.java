package rest.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Валентин Фалин on 14.04.2017.
 */

@RestController
public class ContentController {

    @RequestMapping("/api/get")
    public String greeting(@RequestParam(value = "id", defaultValue = "0") int id) {
        return (new MySQLWorker().get(id));
    }
}
