package rest.service;

/**
 * Created by Валентин Фалин on 14.04.2017.
 */

/**
 * Класс для возвращения значений из БД.
 */
public class Content {

    private final long id;
    private final int coincidences;
    private final String person;

    public Content(long id, int coincidences, String person) {
        this.id = id;
        this.coincidences = coincidences;
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public int getCoincidences() {
        return coincidences;
    }

    public String getPerson() {
        return person;
    }
}
