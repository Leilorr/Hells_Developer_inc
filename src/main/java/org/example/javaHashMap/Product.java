package org.example.javaHashMap;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String category;
}

class Main {
    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Coffee Maker", "Kitchen"));
        products.add(new Product(3, "Notebook", "Stationery"));
        products.add(new Product(4, "Smartphone", "Electronics"));
        products.add(new Product(5, "Blender", "Kitchen"));

        Map<String, List<Product>> productsByCategory = groupProductsByCategory(products);

        displayGroupedProducts(productsByCategory);
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for (Product product : products) {
            String category = product.getCategory();
            if (!groupedProducts.containsKey(category)) {
                groupedProducts.put(category, new ArrayList<>());
            }
            groupedProducts.get(category).add(product);
        }
        return groupedProducts;
    }

    public static void displayGroupedProducts(Map<String, List<Product>> productsByCategory) {
        for (Map.Entry<String, List<Product>> entry : productsByCategory.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("  " + product);
            }
        }
    }
}
