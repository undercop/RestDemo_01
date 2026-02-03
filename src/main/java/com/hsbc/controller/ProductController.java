package com.hsbc.controller;

import com.hsbc.entity.Product;
import com.hsbc.exception.InvalidIdException;
import com.hsbc.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// all requests submitted with '/students' endpoint should be handelled by this class
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {


    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts(){
        List<Product> products = productService.findAllProducts();
        return ResponseEntity.ok(products);
    }
    @PostMapping
    public Product saveProduct(Product products){
        Product product = productService.saveProduct(products);
        return products;
    }


    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Integer id) {
        try {
            return productService.findById(id);
        } catch (InvalidIdException e) {
            throw new RuntimeException(e);
        }


    }
    @PutMapping("/{id}")
    public Product editProducts(@PathVariable("id") int id, @RequestBody Product product) {
        try {
            return productService.editProducts(id, product);
        } catch (InvalidIdException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    /*

    findAll
    findById
    save
    update
    delete
     */

}
