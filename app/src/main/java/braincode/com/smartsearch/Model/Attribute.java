package braincode.com.smartsearch.Model;

import java.util.List;

/**
 * Created by kkoza on 25.03.2017.
 */

public class Attribute {
    private String name;
    private List<String> values;

    public Attribute(String name, List<String> values) {
        this.name = name;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public List<String> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + name + '\'' +
                ", values=" + values +
                '}';
    }
}
