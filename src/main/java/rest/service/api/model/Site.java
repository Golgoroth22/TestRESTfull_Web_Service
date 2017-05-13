package rest.service.api.model;

/**
 * Created by Валентин Фалин on 10.05.2017.
 */
public class Site {
    private int id;
    private String name;
    private String base_url;
    private String open_tag;
    private String close_tag;

    public Site() {
    }

    public Site(String name, String base_url, String open_tag, String close_tag) {
        this.name = name;
        this.base_url = base_url;
        this.open_tag = open_tag;
        this.close_tag = close_tag;
    }

    public Site(int id, String name, String base_url, String open_tag, String close_tag) {
        this.id = id;
        this.name = name;
        this.base_url = base_url;
        this.open_tag = open_tag;
        this.close_tag = close_tag;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBase_url() {
        return base_url;
    }

    public String getOpen_tag() {
        return open_tag;
    }

    public String getClose_tag() {
        return close_tag;
    }
}
