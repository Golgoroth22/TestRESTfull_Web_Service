package rest.service.api.model;

/**
 * Created by Валентин Фалин on 06.05.2017.
 */
public class CoincidencesByDate {
    String date;
    int coincidences;

    public CoincidencesByDate(String date, int coincidences) {
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
