Online Library

This work aims to develop a REST API using Spring Boot and the PostgreSQL database. The system was designed with five entities, aligned with the chosen theme: Online Library. The implementation follows the best software development practices, employing solid data modeling concepts, object-relational mapping (ORM) and a structure suitable for REST Endpoints.
The project was developed using Spring Boot for the implementation of the API and PostgreSQL as the database. The system architecture follows the MVC (Model-View-Controller) standard, with JPA/Hibernate being used for data persistence.

Entity Modeling

The project is composed of five main entities: Book, Author, Publisher, Customer and Loan. Each one plays a fundamental role in the system, having its own attributes that reflect its specific characteristics and functionalities...
The Book entity has seven attributes: Title (String), Genre (String), Number of Pages (String), Year of Publication (LocalDate), Price (Double) and Author (String). Furthermore, it is associated with the Loan entity, reinforcing its central position in the system.
The Author entity is composed of five attributes: First Name (String), Last Name (String), Date of Birth (LocalDate), Date of Death (LocalDate) and Books Written (String). These attributes provide essential information about the authors.
The Customer entity has six attributes: First Name (String), Last Name (String), Telephone (String), Country (String), State (String) and City (String). Like the Book entity, it is associated with the Loan entity, highlighting its importance in the system.
The Loan entity has three attributes: Fee to Pay (Double), Book (associated with the Book entity) and Customer (associated with the Customer entity). It represents the direct relationship between the items loaned and the customers. Finally, the Publisher entity includes two main attributes: Name (String) and Published Books (String), characterizing the publishers and their role in literary production.

REST Endpoints

The API provides a series of endpoints for manipulating entities in the database. The Get All endpoint allows you to list all stored entities, while Get is used to obtain the details of a specific entity. To insert new information into the database, the Post endpoint is used, which creates a new entity. The Put endpoint is responsible for updating the data of an existing entity, and Delete allows you to remove previously registered entities. This structure offers flexibility and complete functionality for managing application data.

Database Configuration

The database used in the project is PostgreSQL. The necessary configurations for its integration, including connection details and the SQL dialect, are defined in the application.properties file. Entities are saved in the database through the JPA (Java Persistence API) framework, using Hibernate as the persistence provider. Each entity is linked to a table in the database through annotations such as @Entity, @Table and @Column, which specify its structure and the relationships between them.

Exception Handling

Error and exception handling is a fundamental aspect of ensuring the robustness and reliability of an API. In the context of this project, the API implements mechanisms to capture and handle exceptions in a structured manner, providing clear and informative responses to the client in case of failures. Each exception is associated with an appropriate HTTP status code, such as 404 Not Found for non-existent resources or 400 Bad Request for malformed requests. In addition, descriptive messages are included in the response, helping API consumers identify the cause of the problem and take the necessary steps to correct it.

Validations

When a request is sent to the API, the data is automatically validated before being processed or persisted to the database. If any validation fails, an exception is thrown, and the API returns a response with an appropriate error code (such as 400 Bad Request) and a message detailing the fields that did not meet the criteria...