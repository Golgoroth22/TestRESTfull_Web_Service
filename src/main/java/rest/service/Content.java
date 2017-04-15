package rest.service;

/**
 * Created by Валентин Фалин on 14.04.2017.
 */

public class Content {

    private final long id;
    private final String content;

    public Content(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
