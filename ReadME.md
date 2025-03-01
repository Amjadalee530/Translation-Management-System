# Translation Management Service
This is a Spring Boot application for managing translations. It uses JWT for authentication, Hibernate for ORM, and SQL Server as the database. The application also includes Swagger for API documentation.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Configuration](#configuration)
  - [Database Configuration](#database-configuration)
  - [JWT Configuration](#jwt-configuration)
  - [Swagger Configuration](#swagger-configuration)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Database Configuration](#database-configuration)
- [JWT Configuration](#jwt-configuration)

## Prerequisites
Before running the application, ensure you have the following installed:
- Java 17 or higher
- Maven
- SQL Server (or any compatible database)
- Postman or any API testing tool (optional)

## Setup
### Clone the repository:
```bash
git clone https://github.com/your-username/translation-management-service.git
cd translation-management-service
```

### Build the project using Maven:
```bash
mvn clean install
```

## Configuration
The application uses the `application.properties` file for configuration. Below are the key configurations:

### Database Configuration
#### SQL Server:
```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=Test;encrypt=true;trustServerCertificate=true
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
```
#### Hibernate:
```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.connection.characterEncoding=UTF-8
spring.jpa.properties.hibernate.connection.useUnicode=true
spring.jpa.properties.hibernate.connection.CharSet=utf8mb4
```

### JWT Configuration
#### Secret Key:
```properties
jwt.secret=Q1LPg47g/aQx52uUyNDC/pY4kuKi9LVSc3xDruomAaU=
```
#### Expiration Time:
```properties
jwt.expiration=86400000  # 24 hours in milliseconds
```

### Swagger Configuration
Swagger UI is enabled by default and can be accessed at:
```
http://localhost:8080/swagger-ui.html
```

## Running the Application
1. Start your SQL Server and ensure the database is running.
2. Update the `application.properties` file with your database credentials.
3. Run the application using Maven:
```bash
mvn spring-boot:run
```
The application will start on port `8080`.

## API Documentation
The application uses Swagger for API documentation. After starting the application, access the Swagger UI at:
```
http://localhost:8080/swagger-ui.html
```

### Authentication
Use the `/api/auth/login` endpoint to authenticate and retrieve a JWT token.

Copy the token and authorize Swagger UI by clicking the **Authorize** button and entering the token in the format:
```
Bearer <your-token>
```

## Database Configuration
### SQL Server
- Ensure the SQL Server is running and accessible.
- Update the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` properties in `application.properties`.

### Hibernate
- Hibernate is configured to automatically update the database schema (`spring.jpa.hibernate.ddl-auto=update`).

## JWT Configuration
- The JWT secret key and expiration time are configured in `application.properties`.
- The token is used for authenticating API requests.