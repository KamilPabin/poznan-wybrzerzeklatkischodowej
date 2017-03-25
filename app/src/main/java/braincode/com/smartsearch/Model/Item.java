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

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public int getBidsCount() {
        return bidsCount;
    }

    public boolean isAuction() {
        return auction;
    }

    public boolean isAdvert() {
        return advert;
    }

    public boolean isBuyNew() {
        return buyNew;
    }

    public String getName() {
        return name;
    }

    public boolean isCartAbailable() {
        return cartAbailable;
    }

    public Prices getPrices() {
        return prices;
    }

    public List<Image> getImages() {
        return images;
    }
}
