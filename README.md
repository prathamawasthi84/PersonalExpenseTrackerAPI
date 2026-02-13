💰 Personal Expense Tracker API

A RESTful backend built with Spring Boot to manage user expenses.
Supports user registration, expense CRUD operations, category filtering, and user-specific expense tracking using a relational database model.

🚀 Tech Stack

Java

Spring Boot

Spring Data JPA (Hibernate)

H2 Database

Jakarta Validation

Maven

✨ Features

User registration with unique email

Create, update, delete expenses

Get all expenses / get by ID

Filter expenses by category

Create expenses for a specific user

Fetch all expenses of a user

Global exception handling & validation

🔗 Relationship

One User → Many Expenses
Implemented using @OneToMany and @ManyToOne with user_id as foreign key.

📥 Key Endpoints

POST /users/register
POST /users/{userId}/expenses
GET /users/{userId}/expenses
GET /expenses
GET /expenses/{id}
PUT /expenses/{id}
DELETE /expenses/{id}

📌 Future Improvements

Spring Security + JWT authentication

Pagination & sorting

PostgreSQL integration
