# Project README

File: `README.md`

## Overview
Small Spring Boot service exposing product-related REST endpoints. Controller: `com.hsbc.controller.ProductController`. Service interface used: `com.hsbc.service.ProductService`. Entity: `com.hsbc.entity.Product`.

## Requirements
- Java (JDK 17+ recommended)
- Spring Boot
- Maven
- Run with: `mvn spring-boot:run`

## REST Endpoints

Base path: `/products` (configured in `ProductController`)

- `GET /products`
    - Description: Fetch all products.
    - Response: `200 OK` with JSON array of `Product`.
    - Example response:
      ```json
      [
        {
          "id": 1,
          "name": "Example Product",
          "price": 9.99,
          "description": "Short description"
        }
      ]
      ```

- `POST /products`
    - Description: Save a new product.
    - Request body: JSON representation of `Product`.
    - Response: `200 OK` (or `201 Created` if adjusted) with the saved `Product`.
    - Example request:
      ```json
      {
        "name": "New Product",
        "price": 19.95,
        "description": "Product details"
      }
      ```

## Entity Structure

Entity class location: `com.hsbc.entity.Product`

Suggested fields (typical structure used by the controller):
- `Long id` — primary identifier
- `String name` — product name
- `BigDecimal price` — product price
- `String description` — optional description

Example Java-like model (for reference):
```java
public class Product {
    private Long id;
    private String name;
    private java.math.BigDecimal price;
    private String description;
    // getters/setters, constructors, equals/hashCode
}
