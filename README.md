# Zalex Invoicing Demo

This demo project is a Spring Boot application based on the MVC approach for managing customer products and customers, based on the provided requirements with basic CRUD operations for customers, products, invoices, and invoice details, based on RESTful API endpoints.

## Table of Contents

- [Zalex Invoicing Demo](#zalex-invoicing-demo)
  - [Table of Contents](#table-of-contents)
  - [Features](#features)
  - [Prerequisites](#requirements)
  - [Getting Started](#getting-started)
    - [Clone the Repository](#clone-the-repository)
    - [Set Up the Database](#set-up-the-database)
    - [Configure Application Properties](#configure-application-properties)
    - [Run the Application](#run-the-application)
  - [Project Structure](#project-structure)
    - [Controller](#controller)
    - [Dto](#dto)
    - [Entity](#entity)
    - [Mapper](#mapper)
    - [Persistence](#persistence)
    - [Service](#service)
  - [API Endpoints](#api-endpoints)
    - [Customer Endpoints](#customer-endpoints)
    - [Product Endpoints](#product-endpoints)
    - [Invoice Endpoints](#invoice-endpoints)
    - [Invoice Details Endpoints](#invoice-details-endpoints)
  - [Example SQL Data](#example-sql-data)
  - [Generated Classes](#generated-classes)

## Requirements

- Java 17 or higher (<em>developed using Java 21</em>)
- Maven
- MySQL
- IDE used: IntelliJ IDEA

## Getting Started

### Clone the Repository

```sh
git clone https://github.com/yourusername/zalex-invoicing-demo.git
cd zalex-invoicing-demo
```

### Set Up the Database
Install MySQL and start the MySQL server.
Create a new database:
```sh
CREATE DATABASE zalex_invoicing_db;
CREATE USER 'zalex'@'localhost' IDENTIFIED BY 'zalex';
GRANT ALL PRIVILEGES ON zalex_invoicing_db.* TO 'zalex'@'localhost';
FLUSH PRIVILEGES;
```

<em>This step is needed as Spring Boot can create/update/delete schemas but not databases, thus we need to create the database beforehand</em>.

### For MySQL Database
Add the following properties to src/main/resources/application.properties:

```sh
spring.application.name=zalex.invoicing.demo

# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/zalex?useSSL=false&serverTimezone=UTC
spring.datasource.username=zalex
spring.datasource.password=zalex
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA and Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Project Structure

### Controller
* CustomerController: Handles HTTP requests related to customer operations
* InvoiceController: Handles HTTP requests related to invoice operations
* ProductController: Handles HTTP requests concerning product operations

### Dto
* CustomerDto: Data Transfer Object for customer data
* InvoiceDetailsDto: Data Transfer Object for invoice detail data
* InvoiceDto: Data Transfer Object for invoice data
* ProductDto: Data Transfer Object for product data

### Entity
* Customer: Entity class representing the customer in the database
* Invoice: Entity class representing an invoice
* InvoiceDetails: Entity class for the details of an invoice
* Product: Entity class for products

### Mapper
* Mapper: Contains methods for mapping between entities and DTOs (bi-directional)

### Persistence
* CustomerRepository: Interface for customer database operations
* InvoiceRepository: Interface for invoice database operations
* ProductRepository: Interface for product database operations

### Service
* CustomerService: Interface for customer-related business logic
* CustomerServiceImpl: Implementation of customer-related business logic
* InvoiceService: Interface for invoice-related business logic
* InvoiceServiceImpl: Implementation of invoice-related business logic
* ProductService: Interface for product-related business logic
* ProductServiceImpl: Implementation of product-related business logic


## API Endpoints
### Customer Endpoints
1. Create a new customer

```sh
POST /api/customers
```
Request Body (in JSON format):
```sh
{
    "accountNo": 1,
    "firstName": "Evangelos",
    "middleName": "Athanasios",
    "lastName": "Michos",
    "address": "Georgiou Str",
    "phone": "+35799242276"
}
```

2. Get all customers

```sh
GET /api/customers
```

3. Get a customer by account number (<em>primary key</em>)

```sh
GET /api/customers/{accountNo}
```

4. Update a customer

```sh
PUT /api/customers/{accountNo}
```

Request Body (in JSON format):

```sh
{
    "firstName": "Evangelos",
    "middleName": "Athanasios",
    "lastName": "Michos",
    "address": "Lemesou 312 Avenue, Limassol",
    "phone": "+35799242276"
}
```
5. Delete a customer

```sh
DELETE /api/customers/{accountNo}
```


### Product Endpoints
1. Create a new product

```sh
POST /api/products
```

Request Body (in JSON format):

```sh
{
    "name": "Laptop",
    "modelNumber": "Lenovo Ideapad Gaming 3",
    "description": "A high-performance laptop",
    "price": 900.00
}
```

2. Get all products

```sh
GET /api/products
```

3. Get a product by ID


```sh
GET /api/products/{id}
```

4. Update a product

```sh
PUT /api/products/{id}
```

Request Body (in JSON format):

```sh
{
    "name": "Laptop",
    "modelNumber": "Lenovo Ideapad Gaming 3",
    "description": "A mid-range performance laptop",
    "price": 750.00
}
```

5. Delete a product

```sh
DELETE /api/products/{id}
```


### Invoice Endpoints
1. Create a new invoice

```sh
POST /api/invoices
```

Request Body (in JSON):

```sh
{
    "dateCreated": "2024-08-01",
    "customer_id": 1
}
```

2. Get all invoices

```sh
GET /api/invoices
```

3. Get an invoice by number

```sh
GET /api/invoices/{number}
```

4. Update an invoice

```sh
PUT /api/invoices/{number}
```

Request Body (in JSON):

```sh
{
    "dateCreated": "2024-08-01",
    "customer_id": 1
}
```

5. Delete an invoice

```sh
DELETE /api/invoices/{number}
```

### Invoice Details Endpoints
1. Add an invoice detail to an invoice

```sh
POST /api/invoices/{invoiceId}/details
```

Request Body (in JSON):

```sh
{
    "product_id": 1,
    "quantity": 1
}
```

2. Update an invoice detail

```sh
PUT /api/invoices/{invoiceId}/details/{detailId}
```

Request Body (in JSON):

```sh
{
    "product_id": 1,
    "quantity": 2
}
```

3. Delete an invoice detail

```sh
DELETE /api/invoices/{invoiceId}/details/{detailId}
```

## Example SQL Data
To ease the population of the MySQL database, the following insertions are provided to assist for testing purposes.

```sh
-- Insert data into Customer table
INSERT INTO Customer (account_no, first_name, middle_name, last_name, address, phone) VALUES
(1, 'Evangelos', 'Athanasios', 'Michos', 'Georgiou Str', '+35799242276'),
(2, 'Nikos', 'Georgiou', 'Nikolaou', 'Lordos Court, 8017', '+35799249754'),
(3, 'Jim', 'Nick', 'Galis', 'Artemidos 92, Nicosia', '+35799568791');

-- Correct insertions for the Product table assuming 'id' is auto-increment
INSERT INTO Product (name, model_number, description, price) VALUES
('Laptop', 'Lenovo Ideapad Gaming 3', 'A high-performance laptop', 900.00),
('Smartphone', 'Samsung Galaxy S40', 'A latest-gen smartphone', 1200.00),
('Tablet', 'Huawei Mediapad T10 Pro', 'A lightweight tablet', 200.00);

-- Insert data into Invoice table
INSERT INTO Invoice (number, date_created, customer_id) VALUES
(1, '2024-08-01', 1),
(2, '2024-08-02', 2),
(3, '2024-08-03', 3);

-- Insert data into InvoiceDetails table
INSERT INTO Invoice_details (id, product_id, quantity, invoice_id) VALUES
(1, 1, 1, 1),
(2, 2, 2, 1),
(3, 3, 1, 2),
(4, 1, 1, 3),
(5, 2, 1, 3),
(6, 3, 1, 3);
```

## Generated Classes
The generated classes are located under
```sh 
target/classes/com
```
folder
