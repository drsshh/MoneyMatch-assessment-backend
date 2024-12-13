# MoneyMatch Backend

## Project Overview
This project is a task list application with a Spring Boot backend, designed to work with an Angular frontend.

## Prerequisites
- Java 17 or higher
- Maven
- MySQL

## Technologies Used
- Spring Boot
- Spring Data JPA
- MySQL

## Setup and Installation

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/moneymatch-backend.git
cd moneymatch-backend
```

### 2. Configure Database
Update `application.properties` with your database credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/moneymatch
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Build the Project
```bash
mvn clean install
```

### 4. Run the Application
```bash
mvn spring-boot:run
```
