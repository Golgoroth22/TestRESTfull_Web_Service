package rest.service.api.models;

/**
 * Created by Валентин Фалин on 06.05.2017.
 */
public class PersonCoincidencesByDate {
    private String date;
    private int coincidences;

    public PersonCoincidencesByDate(String date, int coincidences) {
        this.date = date;
        this.coincidences = coincidences;
    }

    public String getDate() {
        return date;
    }

    public int getCoincidences() {
        return coincidences;
    }
}
