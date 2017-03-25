package braincode.com.smartsearch.Model;

/**
 * Created by kkoza on 25.03.2017.
 */

public class Location {
    private String city;

    public Location(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                '}';
    }
}
