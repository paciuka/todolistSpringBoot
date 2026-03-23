# Todo List REST API (Spring Boot)

A modern, secure backend application for managing tasks, built with **Java 21** and **Spring Boot**. This project focuses on data security, relational database design, and RESTful best practices.

---

## Features

- **User Authentication:** Implemented via `Spring Security` (Basic Auth).
- **Password Security:** Uses the `BCrypt` hashing algorithm to protect user credentials.
- **Relational Mapping:** Established a One-to-Many (`@ManyToOne`) relationship between Users and their Tasks.
- **Automated Ownership:** The server identifies the authenticated user via the security context and automatically assigns created tasks to them.
- **Task Filtering:** Ability to retrieve tasks based on their status (completed/pending).
- **In-memory Database:** Powered by `H2` for rapid development and zero-configuration testing.

---

## Tech Stack

- **Language:** Java 21
- **Framework:** Spring Boot 3+
- **Security:** Spring Security
- **Database:** H2 (SQL)
- **ORM:** Spring Data JPA (Hibernate)
- **Build Tool:** Maven

---

## API Usage (Endpoints)

### 1. User Registration
**POST** `/auth/register`
```json
{
    "username": "pac1uk",
    "password": "123123"
}
