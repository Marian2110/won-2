package ro.fasttrackit.session1.homework.ex1;

import java.util.ArrayList;
import java.util.List;

public final class Product {
    private final String name;
    private final int price;
    private final List<Category> categories;

    public Product(String name, int price, List<Category> categories) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (categories == null || categories.isEmpty()) {
            throw new IllegalArgumentException("Categories cannot be null or empty");
        }
        this.name = name;
        this.price = price;
        this.categories = new ArrayList<>(categories);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }


}

