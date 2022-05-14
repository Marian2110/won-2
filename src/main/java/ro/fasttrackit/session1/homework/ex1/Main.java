package ro.fasttrackit.session1.homework.ex1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String name = "John";
        int price = 100;
        var categories = new ArrayList<Category>();
        categories.add(Category.CLOTHES);
        var laptop = new Product(name, 200, categories);

        name = "Jane";
        price = 300;
        categories = new ArrayList<Category>();
        System.out.println(laptop.getName());
        System.out.println(laptop.getPrice());
        System.out.println(laptop.getCategories());

    }
}
