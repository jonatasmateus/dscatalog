package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository repository;

    @Test
    void deleteShouldDeleteObjectWhenIdExists() {
        // Arrange
        long existingId = 1L;

        // Act
        repository.deleteById(existingId);

        // Assert
        Optional<Product> result = repository.findById(existingId);
        assertFalse(result.isPresent());
    }
}