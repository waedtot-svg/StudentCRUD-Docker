
# Technical Notes – StudentCRUD

## Project Overview
StudentCRUD is a Spring Boot application for managing student records using REST APIs.

## Technologies
- Java 21
- Spring Boot 4.0.6
- Maven
- Spring Data JPA
- MySQL 8.4
- Docker and Docker Compose

## Docker Implementation
A multi-stage Dockerfile was created to build and run the Spring Boot application.

Docker Compose is used to run the application and MySQL together.

## Commands Used
- docker compose config --quiet
- docker compose up --build -d
- docker compose ps

## Testing
The Docker image was built successfully.

Both Spring Boot and MySQL containers started successfully.

The following REST API operations were tested:
- GET /students
- GET /students/1
- POST /students
- PUT /students/1
- DELETE /students/1

All five API requests returned the expected results.

The Maven package build succeeded with tests skipped.

## Problems and Solutions
Problem: Docker Engine was not running.

Solution: Started Docker Desktop and verified the connection using docker info.

Problem: MySQL connection originally used localhost.

Solution: Configured the application to connect to the MySQL service using the Docker Compose service name db.

## Security
Database passwords are stored in a local .env file.

The .env file is excluded from Git and the Docker build context.
