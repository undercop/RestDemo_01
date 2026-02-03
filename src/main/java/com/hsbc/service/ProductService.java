package com.hsbc.service;

import com.hsbc.entity.Product;
import com.hsbc.exception.*;
import com.hsbc.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    // Create
    public Product saveProduct(Product product) {
        try {
            return productRepo.save(product);
        } catch (Exception ex) {
            throw new ProductExceptions.ProductCreateException("Failed to create product", ex);
        }
    }

    // Read (internal)
    public Product findProduct(int id) {
        Optional<Product> optProduct = productRepo.findById(id);
        return optProduct.orElseThrow(
                () -> new ProductExceptions.ProductNotFoundException("Product not found: " + id)
        );
    }

    // Read (nullable id from controllers)
    public Product findById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid id, id must not be null");
        }
        return findProduct(id);
    }

    // Update (entity)
    public Product updateProduct(Product product) {
        // ensure exists
        findProduct(product.getId());
        try {
            return productRepo.save(product);
        } catch (Exception ex) {
            throw new ProductExceptions.ProductUpdateException("Failed to update product: " + product.getId(), ex);
        }
    }

    // Update (by id + payload)
    public Product editProducts(int id, Product product) {
        // Ensure the product with the given id exists
        findProduct(id);

        // enforce the id from the path variable
        product.setId(id);

        try {
            return productRepo.save(product);
        } catch (Exception ex) {
            throw new ProductExceptions.ProductUpdateException("Failed to update product: " + id, ex);
        }
    }

    // Delete
    public Product deleteProduct(int id) {
        Product product = findProduct(id);
        try {
            productRepo.deleteById(id);
            return product;
        } catch (Exception ex) {
            throw new ProductExceptions.ProductDeleteException("Failed to delete product: " + id, ex);
        }
    }

    // Other queries
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> findProductsByName(String name) {
        return productRepo.findByName(name);
    }

    public List<Product> findProductByPartialName(String name) {
        return productRepo.findByPartialName(name);
    }
}

