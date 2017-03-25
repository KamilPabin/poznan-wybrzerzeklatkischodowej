package braincode.com.smartsearch.Model;

/**
 * Created by kkoza on 25.03.2017.
 */

public class Gallery {
    private String small;
    private String medium;
    private String large;

    @Override
    public String toString() {
        return "Gallery{" +
                "small='" + small + '\'' +
                ", medium='" + medium + '\'' +
                ", large='" + large + '\'' +
                '}';
    }

    public String getSmall() {
        return small;
    }

    public String getMedium() {
        return medium;
    }

    public String getLarge() {
        return large;
    }
}
