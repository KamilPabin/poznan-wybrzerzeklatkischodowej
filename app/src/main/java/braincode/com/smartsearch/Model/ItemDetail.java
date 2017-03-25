package braincode.com.smartsearch.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kkoza on 25.03.2017.
 */

public class ItemDetail implements Serializable {
    @SerializedName("gallery")
    private List<Gallery> gallery;
    @SerializedName("attributes")
    private List<Attribute> attributes;
    @SerializedName("location")
    private Location location;
    @SerializedName("mainImage")
    private Gallery mainImage;
    @SerializedName("name")
    private String name;
    @SerializedName("buyNow")
    private boolean buyNow;
    @SerializedName("auction")
    private boolean auction;
    @SerializedName("prices")
    braincode.com.smartsearch.Prices prices;

    @SerializedName("quantities")
    private Quantities quantities;

    public ItemDetail(List<Gallery> gallery, List<Attribute> attributes, Location location, Gallery mainImage, String name, boolean buyNow, boolean auction, braincode.com.smartsearch.Prices prices) {
        this.gallery = gallery;
        this.attributes = attributes;
        this.location = location;
        this.mainImage = mainImage;
        this.name = name;
        this.buyNow = buyNow;
        this.auction = auction;
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "ItemDetail{" +
                "gallery=" + gallery +
                ", attributes=" + attributes +
                ", location=" + location +
                ", mainImage=" + mainImage +
                ", name='" + name + '\'' +
                ", buyNow=" + buyNow +
                ", auction=" + auction +
                ", prices=" + prices +
                ", quantities=" + quantities +
                '}';
    }


    public Quantities getQuantities() {
        return quantities;
    }

    public List<Gallery> getGallery() {
        return gallery;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public Location getLocation() {
        return location;
    }

    public Gallery getMainImage() {
        return mainImage;
    }

    public String getName() {
        return name;
    }

    public boolean isBuyNow() {
        return buyNow;
    }

    public boolean isAuction() {
        return auction;
    }

    public braincode.com.smartsearch.Prices getPrices() {
        return prices;
    }
}
