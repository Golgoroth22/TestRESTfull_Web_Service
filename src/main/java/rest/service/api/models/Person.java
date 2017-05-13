package rest.service.api.models;

/**
 * Created by Валентин Фалин on 10.05.2017.
 */
public class Person {
    private int id;
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
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
