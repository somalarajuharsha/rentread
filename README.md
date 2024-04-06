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
- POST /api/login
  - Log in with email and password to obtain authentication token.
### Private Endpoints (Require Authentication)
- GET /api/books
  - Get all available books.
- POST /api/books
  - Create a new book (ADMIN only).
  - Request body should contain book title, author, genre, and availability status.
- PUT /api/books/{bookId}
  - Update book details (ADMIN only) by providing book ID.
  - Request body should contain updated book information.
- DELETE /api/books/{bookId}
  - Delete a book (ADMIN only) by providing book ID.
- POST /api/books/{bookId}/rent
  - Rent a book by providing book ID (USER only).
  - Checks if the user has less than two active rentals.
- POST /api/books/{bookId}/return
  - Return a rented book by providing book ID (USER only).
## Postman Collection
You can find the Postman Collection for this project to call api's and test [Postman Collection Link](https://elements.getpostman.com/redirect?entityId=32824438-7b57b247-c631-47b7-856d-6f04166f6341&entityType=collection).

## Usage
1. Run the application locally.
2. Use Postman or any API testing tool to interact with the endpoints.
3. Refer to the Postman Collection provided in the repository for API requests.

## Testing
- Basic JUnit test cases are provided to verify the functionality.

## To Contribute
1. Fork the repository.
2. Create a new branch.
3. Make your changes and commit them with meaningful messages.
4. Push your changes to your forked repository.
5. Submit a pull request to the main repository.
