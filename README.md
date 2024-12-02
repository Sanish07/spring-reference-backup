# Spring Reference Manual

A walkthrough of all Spring Framework projects and concepts essential for developing the backend of enterprise web applications.

---

## Table of Contents

1. [Spring Core](#1-spring-core)  
2. [Spring JDBC](#2-spring-jdbc)  
3. [Spring Boot](#3-spring-boot)  
4. [Spring Data JPA - Deep Dive](#4-spring-data-jpa---deep-dive)  
5. [Spring Security](#5-spring-security)  

---

## 1. Spring Core

### 1.1. IoC and DI Basics
- **Tight and Loose Coupling**
- **XML Configuration** for IoC and DI
- **Java Configuration** for IoC and DI
- **Annotations and Hybrid Configurations** for IoC and DI
- **Bean Scopes** and Scope Combinations
- **Lazy Initialization**
- **Properties**
- **XML Value Injection** (Primitives and Non-primitives)
- **Spring Profiles**

---

## 2. Spring JDBC

### 2.1. Introduction
- **Spring JDBC Introduction**
- Configuring **XML for Database Connection**
- Configuring **Java Config File for Database Connection** (Alternative to XML Config)
- Insert, Update, and Delete Operations with **`JdbcTemplate`**
- Configuring **`RowMapper` Implementation Class** for Select Operations
- Single-Object Select Queries and Multi-Object Select Queries with **`JdbcTemplate`** and **`RowMapper`**

---

## 3. Spring Boot

### 3.1. Introduction to Spring Boot
- Understanding Spring Boot **Project Structure**
- Customizing the **Application Banner**
- Testing Spring Core Features in a **Spring Boot Application**
- Reading **System and Custom Properties** with the `Environment` Interface

### 3.2. Introduction to Spring REST Architecture
- Working with the **Controller Layer** and HTTP Requests/Responses
- Using **Path Parameters** and **Query Parameters** in Routing

### 3.3. Spring Data JPA Introduction
- Defining Application Properties with a **YAML Data Serialization File**
- Configuring **PostgreSQL** for Database Operations
- Creating **Entity Classes** and Mapping Fields with Database Schemas
- Using **`JpaRepository`** for Persistence Layer Methods
- Performing **CRUD Operations** with JPA
- Defining Custom Search Functions in the Repository with **JPA Query Methods**
- Defining **Entity Relationships** with Hibernate Mappings
- Assigning Secondary/Child Entities to Primary/Parent Entities via **API Requests**
- Resolving Parent-Child Serialization Issues on **Child's GET Requests**

### 3.4. Spring DTO Pattern, Data Validation, and Unit Testing
- Customizing REST API Requests and Responses with the **DTO Pattern**
- Using **Java Records (JDK 14+)** for DTO Files Creation
- Refactoring Code to Move Business Logic to the **Service Layer**
- Performing **Basic Data Validation** for API Request Objects
- Handling **Bad Request Exceptions** After Validation
- Introduction to Spring Testing with **JUnit 5**
- Unit Testing Basic Methods of **Mapper Classes**
- Achieving Test Isolation with **Mockito** by Mocking External Beans
- Testing **Service Layer Methods** with **Mockito**

---

## 4. Spring Data JPA - Deep Dive

### Advanced JPA Concepts
- Using **Lombok Annotations** to Reduce Boilerplate Code
- Understanding **Primary Key ID Generation Strategies**
- Exploring the **Hibernate Entity Lifecycle**
- Testing Repository Methods with the **`CommandLineRunner` Bean**
- Unidirectional vs. Bidirectional Entity Mappings
- Advanced **Hibernate Entity-Relationship Mappings**

### Inheritance and Embedded Entities
- Using **`@MappedSuperclass`** for Common Entities
- Exploring JPA-Hibernate **Entity Inheritance Strategies**
- Creating Composite Primary Keys with **`@Embeddable`** and **`@EmbeddedId`**
- Resolving Multiple Inheritance Issues with **Embedded Entities**

### Custom Queries and Specifications
- Defining Custom Queries with the **`@Query` Annotation**
- Creating Optimized Queries with **Named Queries**
- Implementing **Specifications** for Dynamic and Type-Safe Queries

---

## 5. Spring Security

### 5.1. Setting up
- Setting up a **Spring Boot Project** with Dependencies for Spring Security
- Understanding the **Basic Auth Header** and Its Encoding
- Creating an **In-Memory User** for Authentication

### 5.2. Managing Users
- Enabling User Authentication via **Database User Entries**
- Configuring **`UserDetails`**, **`UserDetailsService`**, and **`WebConfig` Classes** for Authentication
- Managing User Authorities with the **`GrantedAuthority` Interface**

### 5.3. Implementing Key-Based Custom Authentication 
- Defining **`SecurityFilterChain`** bean in configuration class
- Creating Custom Authentication Filter class as a part of Filter Chain
- Writing implementations of `AuthenticationManager` and `AuthenticationProvider` for our custom filter
- Understanding the workflow of **Authentication process inside Authentication Filter**
- Testing and Debugging the Key-based Custom Authentication application  

### 5.4. Multiple Authentication Providers
- Overview of **Chaining Default Filters with Custom Filters**
- Chaining multiple filters and **availing multiple authentication methods for an user**
- **`addFilterBefore()`** vs **`addFilterAfter()`** vs **`addFilterAt()`**

### 5.5. Endpoint Authorization
- **Understanding endpoint authorization** associated methods
- Testing the chain of different combinations of matcher methods with authorization rules
- Use of different **authorization rules**
- Introduction to **`requestMatchers()`** matcher method (Spring Security 5.8+)

### 5.6. More with Endpoint Authorization (Matcher method)
- Protecting various endpoints using **`requestMatchers()`**
- Securing endpoints under the **same route prefix group**
- Configuring matchers for the same endpoint with **different HTTP methods**


