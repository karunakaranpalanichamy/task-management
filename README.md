# Task Management REST API

A Spring Boot-based RESTful API for managing tasks. This application allows users to create, retrieve, update, delete, and mark tasks as completed through REST endpoints.

## Features

- Create a new task
- Retrieve all tasks
- Retrieve a task by ID
- Update an existing task
- Delete a task
- Mark a task as completed
- RESTful API design
- Built using Java and Spring Boot

## Technology Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- REST API
- Database (H2/MySQL/PostgreSQL depending on configuration)

## Project Structure

```
src
├── main
│   ├── java
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── model
│   │   └── exception
│   └── resources
│       ├── application.properties
│       └── data.sql (optional)
└── test
```

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.8+
- Database (if not using the default H2 database)

### Clone the Repository

```bash
git clone https://github.com/yourusername/task-management.git
cd task-management
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

Or run the generated JAR:

```bash
java -jar target/task-management.jar
```

The application will start on:

```
http://localhost:8080
```

## REST API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/tasks` | Create a new task |
| GET | `/api/tasks` | Get all tasks |
| GET | `/api/tasks/{id}` | Get task by ID |
| PUT | `/api/tasks/{id}` | Update an existing task |
| PATCH | `/api/tasks/{id}/complete` | Mark task as completed |
| DELETE | `/api/tasks/{id}` | Delete a task |

## Sample Request

### Create Task

**POST** `/api/tasks`

```json
{
  "title": "Complete README",
  "description": "Write project documentation",
  "completed": false
}
```

### Sample Response

```json
{
  "id": 1,
  "title": "Complete README",
  "description": "Write project documentation",
  "completed": false
}
```

### Complete Task

**PATCH** `/api/tasks/1/complete`

#### Response

```json
{
  "id": 1,
  "title": "Complete README",
  "description": "Write project documentation",
  "completed": true
}
```

## HTTP Status Codes

| Status Code | Description |
|--------------|-------------|
| 200 OK | Request processed successfully |
| 201 Created | Resource created successfully |
| 204 No Content | Resource deleted successfully |
| 400 Bad Request | Invalid request |
| 404 Not Found | Task not found |
| 500 Internal Server Error | Unexpected server error |

## Configuration

Update the database configuration in `application.properties`.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=root
spring.datasource.password=password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Testing

Run unit tests using Maven:

```bash
mvn test
```

## Future Enhancements

- User authentication and authorization
- Task priorities
- Due dates
- Categories and tags
- Pagination and sorting
- Filtering and searching
- Swagger/OpenAPI documentation
- Docker support
- CI/CD pipeline

## Contributing

Contributions are welcome.

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push the branch.
5. Open a Pull Request.

## License

This project is licensed under the MIT License.

## Author

Developed using Java and Spring Boot.
