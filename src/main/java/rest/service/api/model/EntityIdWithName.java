package rest.service.api.model;

/**
 * Created by Валентин Фалин on 10.05.2017.
 */
public class EntityIdWithName {
    private int id;
    private String name;

    public EntityIdWithName(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
