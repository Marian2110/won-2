package ro.fasttrackit.session1.homework.ex2;

import ro.fasttrackit.session1.homework.ex1.Product;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Shop {
    private final Set<Product> products;
    private final Map<String, Integer> stock;

    public Shop() {
        this.products = new HashSet<>();
        this.stock = new HashMap<>();
    }

    public void add(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product is null");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity is negative");
        }
        if (products.contains(product)) {
            stock.put(product.getName(), stock.get(product.getName()) + quantity);
        } else {
            products.add(product);
            stock.put(product.getName(), quantity);
        }
    }

    public void buy(String name, int quantity) {
        if (name == null || !stock.containsKey(name)) {
            throw new IllegalArgumentException("Product is null or doesn't exist");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity is negative");
        }
        int currentQuantity = stock.get(name);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Not enough products in stock");
        }
        stock.put(name, currentQuantity - quantity);
    }

    public void printStock() {
        for (String name : stock.keySet()) {
            System.out.println(name + ": " + stock.get(name) + " left");
        }
    }
}

