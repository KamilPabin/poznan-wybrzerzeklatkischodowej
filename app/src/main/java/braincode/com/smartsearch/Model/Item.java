package braincode.com.smartsearch.Model;

/**
 * Created by Little on 2017-03-24.
 */
public class Item {
    private long id;
    private String url;
    private int bidsCount;
    private boolean auction;
    private boolean advert;
    private boolean buyNew;
    private String Name;
    private boolean cartAbailable;
    private Prices prices;
    private Image image;

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
                ", Name='" + Name + '\'' +
                ", cartAbailable=" + cartAbailable +
                ", prices=" + prices +
                ", image=" + image +
                '}';
    }
}
