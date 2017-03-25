package braincode.com.smartsearch;

/**
 * Created by kkoza on 25.03.2017.
 */

public class Prices {
    private double buyNow;
    private double bid;

    public Prices(double buyNow, double bid) {
        this.buyNow = buyNow;
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Prices{" +
                "buyNow=" + buyNow +
                ", bid=" + bid +
                '}';
    }

    public double getBuyNow() {
        return buyNow;
    }

    public double getBid() {
        return bid;
    }
}
