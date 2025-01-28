package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.Factory;
import com.devsuperior.dscatalog.entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    private long existingId;
    private long countTotalProducts;

    @BeforeEach
    void setUp() {
        existingId = 1L;
        countTotalProducts = 25L;
    }

    @Test
    void deleteShouldDeleteObjectWhenIdExists() {
        // Act
        repository.deleteById(existingId);

        // Assert
        Optional<Product> result = repository.findById(existingId);
        assertFalse(result.isPresent());
    }

    @Test
    void saveShouldPersistWithAutoincrementWhenIsNull() {
        // Arrange
        Product product = Factory.createProduct();
        product.setId(null);

        // Act
        Product result = repository.save(product);

        // Assert
        assertNotNull(result.getId());
        assertEquals(countTotalProducts + 1, product.getId());
    }


}