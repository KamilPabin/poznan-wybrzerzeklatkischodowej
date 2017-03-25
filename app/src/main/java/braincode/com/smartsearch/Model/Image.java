package braincode.com.smartsearch.Model;

/**
 * Created by kkoza on 25.03.2017.
 */

public class Image {
    private String url;

    public Image(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }
}
