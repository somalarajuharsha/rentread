# RentRead - Online Book Rental System

RentRead is a RESTful API service built with Spring Boot for managing an online book rental system. This service allows users to register, log in, browse available books, rent books, and manage book inventory. The API also supports authentication and authorization using Basic Auth with two roles: USER and ADMIN.

## Key Features

- User Registration and Login
- Book Management (CRUD operations for books)
- Rental Management (Renting and returning books)
- Basic authentication using Spring Security with roles (USER, ADMIN)
- Secure storage of passwords using BCrypt encryption
- Graceful error handling and appropriate HTTP status codes
- Logging of information and errors
- Unit testing with MockMvc and Mockito

## Technologies Used

- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- BCrypt for password encryption
- Lombok for reducing boilerplate code

## Setup

### Requirements

- Java JDK 8 or higher
- MySQL database
- Git
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/rent-read.git
2. Open the project in your IDE.
3. Configure application.properties file with your MySQL database settings:
    ```bash
    spring.application.name=rentread
    spring.datasource.url=jdbc:mysql://localhost:3306/readrent
    spring.datasource.username=root
    spring.datasource.password=rootpassword
    spring.jpa.hibernate.ddl-auto=update
    server.port=8081
4. Build and run the application using Gradle:
     ```bash
     ./gradlew build
    java -jar build/libs/rent-read.jar
5. Once the application is running, you can access the API endpoints using tools like Postman or cURL.
## API Endpoints

### Public Endpoints
- POST /api/register
  - Register a new user by providing email, password, first name, last name, and optional role.
