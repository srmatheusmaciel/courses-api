# Spring Boot Courses  

This is an example project developed with **Spring Boot**, featuring CRUD (Create, Read, Update, Delete) functionalities for course management.  

## Features  

- **Create Course**: Add new courses with details such as name, category, and status (active/inactive).  
- **List Courses**: Retrieve all registered courses with optional filters by name or category.  
- **Update Course**: Partially or fully update the details of a specific course.  
- **Delete Course**: Remove a course by its ID.  
- **Toggle Status**: Switch between active and inactive for registered courses.  

## Technologies Used  

- **Java 17**  
- **Spring Boot**  
- **PostgreSQL 16**  
- **JPA/Hibernate**  
- **Lombok**  

## Setup Instructions  

1. Clone the repository:  
   ```bash
   git clone https://github.com/srmatheusmaciel/springboot-courses.git
   cd springboot-courses

## Database Structure  

The course table includes the following fields:  

| Field         | Type          | Description                              |  
|---------------|---------------|------------------------------------------|  
| `id`          | `UUID`        | Unique identifier for the course.         |  
| `name`        | `String`      | Course name.                              |  
| `category`    | `String`      | Course category.                          |  
| `active`      | `Enum`        | Course status (ACTIVE or INACTIVE).       |  
| `created_at`  | `Timestamp`   | Course creation date.                     |  
| `updated_at`  | `Timestamp`   | Last update date of the course.           |  

## Configure the Database  

Set up the database configuration in the `application.properties` or `application.yml` file:  

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/courses
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.application.name=api-cursos

server.port=8080
```

## Contribution  

Feel free to open issues or pull requests to improve the project.  
