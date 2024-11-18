*Warning*: The PDF in Classroom is in Portuguese for better understanding. In addition, a large part of this translation was done by Google Translate!

Project – Online Library

This project’s main objective was to create a REST API using Spring Boot and a PostgreSQL Database. The project has five entities, both related to the chosen theme: Online Library. The system followed the best practices for development, applying solid concepts of data modeling, object-relational mapping and structure for REST Endpoint.
The system uses Spring Boot to implement the Online Library, as well as PostgreSQL to store the data. It has the “Model-View-Controller” pattern as its architecture.

Entity Modeling

The project consists of five main entities: Book, Author, Publisher, Customer and Loan. Each one plays a fundamental role in the system, having its own attributes that reflect its specific characteristics and functionalities...
The Book entity has seven attributes: Title (String), Genre (String), Number of Pages (Integer), Year of Publication (LocalDate), Price (Double) and Author (String). Furthermore, it is associated with the Loan entity, reinforcing its central position in the system. The Author entity is composed of five attributes: First Name (String), Last Name (String), Date of Birth (LocalDate), Date of Death (LocalDate) and Books Written (String). These attributes provide essential information about the authors. The Customer entity has six attributes: First Name (String), Last Name (String), Telephone (String), Country (String), State (String) and City (String). Like the Book entity, it is associated with the Loan entity, highlighting its importance in the system. The Loan entity has three attributes: Fee to Pay (Double), Book (association with the Book entity) and Customer (association with the Customer entity). It represents the direct relationship between the items loaned and the customers. Finally, the Publisher entity includes two main attributes: Name (String) and Published Books (String), characterizing the publishers and their role in literary production. 

REST Endpoint 

The Online Library API has some endpoints for manipulating entities in the database. Get All is used to show all entities present in the database, while Get is only used to search for a single entity in the database. To add new information to the system, use Post, which can create a new entity in the system. When it is necessary to update an existing entity, use Put. Finally, if there is a need to delete an existing item, use Delete. 

Database Configuration 

The system uses PostgreSQL as a database to store information. The settings for its operation, such as connection and SQL dialect, are found in the application.properties file. The methods are saved in the database through the JPA Framework, using Hibernate as the persistence provider. Each entity is linked to a table through annotations, such as @Entity, @Table and @Column. 

Exception Handling 

The API has mechanisms to handle exceptions correctly, delivering clear and informative results to the individual in case of failures. Exceptions are associated with the HTTP Status code, for example: 404 Not Found for non-existent resources or 400 Bad Request for incorrect requests... 

Validations 

When an individual sends a request to the API, the data will be automatically validated before being processed in the database. If any validation is not correct or appropriate, an exception will be generated, and the API will return a response with an appropriate error code and a message informing which questions did not meet the criteria...