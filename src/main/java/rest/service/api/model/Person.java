package rest.service.api.model;

/**
 * Created by Валентин Фалин on 29.04.2017.
 */
public class Person {
    private String name;
    private int coincidences;

    public Person(String name, int coincidences) {
        this.coincidences = coincidences;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCoincidences() {
        return coincidences;
    }
}