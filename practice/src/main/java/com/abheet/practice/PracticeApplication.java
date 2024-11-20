package com.abheet.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PracticeApplication implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Adding sample products
        productService.saveProduct(new Product(null, "Product A", 20.0));
        productService.saveProduct(new Product(null, "Product B", 25.0));
        productService.saveProduct(new Product(null, "Product C", 30.0));

        // Fetching top 2 products in price range 15 to 30
        List<Product> products = productService.getProductsByPriceRange(15.0, 30.0);
        products.forEach(product -> System.out.println(product.getName() + ": " + product.getPrice()));
    }
}