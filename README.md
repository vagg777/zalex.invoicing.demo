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
  - [API Endpoints](#api-endpoints)
    - [Customer Endpoints](#customer-endpoints)
    - [Product Endpoints](#product-endpoints)
    - [Invoice Endpoints](#invoice-endpoints)
    - [Invoice Details Endpoints](#invoice-details-endpoints)
  - [Example SQL Data](#example-sql-data)
  - [Running Tests](#running-tests)
  - [License](#license)

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
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```

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
