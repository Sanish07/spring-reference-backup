## Spring Reference Manual
<hr/>

1. <strong>Spring Core</strong><br>
1.1. Tight and Loose Coupling <br>
1.2. XML Configuration for IoC and DI <br>
1.3. Java Configuration for IoC and DI<br>
1.4. Annotations and Hybrid configurations for IoC and DI<br>
1.5. Bean Scopes and Scope Combinations<br>
1.6. Lazy Initialization<br>
1.7. Properties<br>
1.8. XML value injection(Primitives and Non-primitives)<br>
1.9. Spring Profiles<br>

<br>

2. <strong>Spring JDBC</strong><br>
2.1. Spring JDBC Introduction <br>
2.2. Configuring XML for database connection <br>
2.3. Configuring Java config File for database connection(Alternative to XML config, with pre-defined classes bean initialization) <br>
2.4. Insert, Update and Delete operations with JdbcTemplate <br>
2.5. Configuring RowMapper implementation class for Select opearations <br>
2.6. Single-object Select queries and Multi-Object Select Queries implementation with JdbcTemplate and RowMapper<br>

<br>

3. <strong>Spring Boot</strong><br><br>
3.1. <strong>Introduction to Spring Boot</strong> <br>
&nbsp; &nbsp; &nbsp; 3.1.1. Understanding Spring Boot project structure<br>
&nbsp; &nbsp; &nbsp; 3.1.2. Customizing Application Banner <br>
&nbsp; &nbsp; &nbsp; 3.1.3. Testing Spring Core features in Spring Boot application <br>
&nbsp; &nbsp; &nbsp; 3.1.4. Reading System and Custom Properties with Environment interface <br>
<br>
3.2. <strong>Introduction to Spring REST Architecture</strong> <br>
&nbsp; &nbsp; &nbsp; 3.2.1. Working with Controller Layer and HTTP Requests+Responses <br>
&nbsp; &nbsp; &nbsp; 3.2.2. Path Parameters and Query Parameters in Routing <br>
<br>
3.3. <strong>Spring Data JPA Introduction</strong><br>
&nbsp; &nbsp; &nbsp; 3.3.1. Defining application properties with YAML data serialization file <br>
&nbsp; &nbsp; &nbsp; 3.3.2. Configuring PostgreSQL for database operations <br>
&nbsp; &nbsp; &nbsp; 3.3.3. Creating Entity class and mapping class fields with database schema using Spring Hibernate <br>
&nbsp; &nbsp; &nbsp; 3.3.4. Using JpaRepository for availing persistence layer methods to service layer <br>
&nbsp; &nbsp; &nbsp; 3.3.5. Performing CRUD operations with JPA <br>
&nbsp; &nbsp; &nbsp; 3.3.6. Defining custom search functions in Repository file with JPA Query Methods <br>
&nbsp; &nbsp; &nbsp; 3.3.7. Defining Relationships between entities using Hibernate Mappings <br>
&nbsp; &nbsp; &nbsp; 3.3.8. Assigning secondary/child entity to primary/parent entity with API requests <br>
&nbsp; &nbsp; &nbsp; 3.3.9. Resolving infinite loop of parent-child serialization-deserialization on Child's GET<br>
<br>
3.4. <strong>Spring DTO Pattern, Data Validation and Unit Testing</strong><br>
&nbsp; &nbsp; &nbsp; 3.4.1. Customizing REST API Server Requests & Responses through DTO pattern<br>
&nbsp; &nbsp; &nbsp; 3.4.2. Replacing POJOs with Java Records(jdk 14+) for DTO files creation for all entities<br>
&nbsp; &nbsp; &nbsp; 3.4.3. Refactoring the code to move all the business logic to service layer<br>
&nbsp; &nbsp; &nbsp; 3.4.4. Basic Data Validation for Objects requested from API Request Body<br>
&nbsp; &nbsp; &nbsp; 3.4.5. Handling bad request exceptions raised after data validation<br>
&nbsp; &nbsp; &nbsp; 3.4.6. Introduction to Spring Testing with JUnit5<br>
&nbsp; &nbsp; &nbsp; 3.4.7. Unit Testing basic methods of Mapper classes having no external dependencies/beans<br>
&nbsp; &nbsp; &nbsp; 3.4.8. Achieving test isolation through Mockito framework by mocking and opening external beans<br>
&nbsp; &nbsp; &nbsp; 3.4.9. Testing Service layer methods with Mockito framework and mocking method calls<br>