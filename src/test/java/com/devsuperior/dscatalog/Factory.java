package com.devsuperior.dscatalog;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;

import java.time.Instant;

public class Factory {

    private static final Category category = new Category(2L, "Electronics");

    public static Product createProduct() {
        Product product = new Product(1L, "Phone", "Good Phone", 800.0, "url...", Instant.parse("2025-01-28T19:10:10Z"));
        product.getCategories().add(category);
        return product;
    }

    public static ProductDTO createProductDTO() {
        Product product = createProduct();
        return new ProductDTO(product, product.getCategories());
    }

    public static Category createCategory() {
        return category;
    }

    public static CategoryDTO createCategoryDTO() {
        return new CategoryDTO(category);
    }
}
