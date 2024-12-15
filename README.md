# Product-Category Management API

## Overview

This is a **Spring Boot application** designed to manage a **Product-Category relationship**. There is a **One-to-Many relationship** (i.e., one `Category` can have multiple `Products`) and this
project uses **Oracle RDB**.
It implements basic **CRUD operations** for both products and categories while showcasing server-side pagination, validation, and a one-to-many relationship between categories and products. 

The application was developed as part of an assessment evaluation task and demonstrates the ability to build RESTful APIs using Spring Boot.  

---

## Features

### 1. **Category Management**
- Create a new category
- Retrieve a category by ID
- Update category details
- Delete a category
- List all categories with server-side pagination

### 2. **Product Management**
- Create a new product linked to a category
- Retrieve a product by ID (including its category details)
- Update product details
- Delete a product
- List all products with server-side pagination

### 3. **One-to-Many Relationship**
- Each category can have multiple products.

---

## Requirements

### Functional Requirements
1. **Category CRUD APIs**:
   - GET `/api/categories?page={pageNumber}`: Retrieve paginated categories.
   - POST `/api/categories`: Create a new category.
   - GET `/api/categories/{id}`: Retrieve category by ID.
   - PUT `/api/categories/{id}`: Update category details by ID.
   - DELETE `/api/categories/{id}`: Delete a category by ID.

2. **Product CRUD APIs**:
   - GET `/api/products?page={pageNumber}`: Retrieve paginated products.
   - POST `/api/products`: Create a new product linked to a category.
   - GET `/api/products/{id}`: Retrieve product by ID (response populated with category details).
   - PUT `/api/products/{id}`: Update product details by ID.
   - DELETE `/api/products/{id}`: Delete a product by ID.

3. **Server-Side Pagination**:
   - APIs include pagination support using Spring Data's `Pageable`.

---

## Technologies Used

- **Java**: Primary programming language.
- **Spring Boot**: Framework for RESTful API development.
- **Spring Data JPA**: ORM and database interaction.
- **Oracle RDB**: Embedded database for development and testing.
- **Maven**: Build and dependency management.

---
