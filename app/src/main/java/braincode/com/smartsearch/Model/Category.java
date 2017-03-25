package braincode.com.smartsearch.Model;

/**
 * Created by kkoza on 25.03.2017.
 */


public class Category {
    private int id;
    private boolean hasChildren;
    private String name;

    public Category(int id, boolean hasChildren, String name) {
        this.id = id;
        this.hasChildren = hasChildren;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public String getName() {
        return name;
    }
}
