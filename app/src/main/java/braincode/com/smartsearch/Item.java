package braincode.com.smartsearch;

/**
 * Created by Little on 2017-03-24.
 */
public class Item {
    private String smallImageURL;
    private String mediumImageURL;
    private String Title;
    private String Description;
    private String Price;

    public Item(String smallImageURL, String mediumImageURL, String title, String description, String price) {
        this.smallImageURL = smallImageURL;
        this.mediumImageURL = mediumImageURL;
        Title = title;
        Description = description;
        Price = price;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public void setSmallImageURL(String smallImageURL) {
        this.smallImageURL = smallImageURL;
    }

    public String getMediumImageURL() {
        return mediumImageURL;
    }

    public void setMediumImageURL(String mediumImageURL) {
        this.mediumImageURL = mediumImageURL;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "smallImageURL='" + smallImageURL + '\'' +
                ", mediumImageURL='" + mediumImageURL + '\'' +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Price='" + Price + '\'' +
                '}';
    }
}
