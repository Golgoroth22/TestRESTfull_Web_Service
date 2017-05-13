package rest.service.api.model;

/**
 * Created by Валентин Фалин on 10.05.2017.
 */
public class Keyword {
    private int id;
    private String name;
    private int person_id;

    public Keyword() {
    }

    public Keyword(String name, int person_id) {
        this.name = name;
        this.person_id = person_id;
    }

    public Keyword(int id, String name, int person_id) {
        this.id = id;
        this.name = name;
        this.person_id = person_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPerson_id() {
        return person_id;
    }
}
