package braincode.com.smartsearch.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Little on 2017-03-24.
 */
public class Item implements Serializable {
    private long id;
    private String url;
    private int bidsCount;
    private boolean auction;
    private boolean advert;
    private boolean buyNew;
    private String name;
    private boolean cartAbailable;
    private Prices prices;
    private List<Image> images;

    public Item(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", bidsCount=" + bidsCount +
                ", auction=" + auction +
                ", advert=" + advert +
                ", buyNew=" + buyNew +
                ", Name='" + name + '\'' +
                ", cartAbailable=" + cartAbailable +
                ", prices=" + prices +
                ", image=" + images +
                '}';
    }
}
