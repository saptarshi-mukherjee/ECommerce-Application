# 🛍️ E-Commerce Application – Backend (Spring Boot)

A RESTful backend API for an e-commerce application developed using Java, Spring Boot, JPA, and MySQL. It supports product browsing, user registration, cart operations, and order processing, with role-based access control for customers and admins.

---

## 🔧 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Maven

---

## 📦 Features

- User registration and authentication
- Role-based access control (Customer/Admin)
- Product management (CRUD for admins)
- Cart functionality for users
- Order creation and viewing

---

## 📘 API Endpoints

### 👤 UserController

- `POST /register`: Register a new user
- `GET /user`: Retrieve all users
- `GET /user/{id}`: Get user by ID
- `DELETE /user/{id}`: Delete a user

### 📦 ProductController

- `GET /product`: Get all products
- `GET /product/{id}`: Get product by ID
- `GET /product/category/{category}`: Get products by category
- `POST /product`: Add a new product (Admin only)
- `PUT /product/{id}`: Update a product (Admin only)
- `DELETE /product/{id}`: Delete a product (Admin only)

### 🛒 CartController

- `POST /cart/add`: Add item to cart
- `GET /cart`: View all cart items
- `DELETE /cart/delete/{id}`: Remove item from cart

### 📦 OrderController

- `POST /order`: Place a new order
- `GET /order`: View all orders
- `GET /order/{id}`: View order by ID

### 🧪 TestController

- `GET /hello`: Health check/test endpoint

---

## 🗃️ Models

- **User**: id, username, email, password, role
- **Product**: id, name, price, description, category
- **Cart**: id, product, quantity, user
- **Order**: id, user, product list, order date

---

## 🚀 Getting Started

1. Clone the repository:


git clone https://github.com/saptarshi-mukherjee/ECommerce-Application.git


2. Configure your database settings in `application.properties`.

3. Run the application:


./mvnw spring-boot:run


4. Access API endpoints at `http://localhost:8080`.

---

