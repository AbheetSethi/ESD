package com.abheet.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        return productRepository.findTop2ByPriceBetweenOrderByPriceAsc(minPrice, maxPrice);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}