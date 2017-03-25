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

    @Override
    public String toString() {
        return "ItemDetail{" +
                "gallery=" + gallery +
                ", attributes=" + attributes +
                ", location=" + location +
                ", mainImage=" + mainImage +
                ", name='" + name + '\'' +
                '}';
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
}
