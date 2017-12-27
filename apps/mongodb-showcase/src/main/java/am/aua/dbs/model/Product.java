package am.aua.dbs.model;

import com.google.gson.annotations.Expose;

/**
 * @author Vahe Pezeshkian
 *         November 16, 2017
 */
public class Product {
    private String id;
    private String name;
    private String category;
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
