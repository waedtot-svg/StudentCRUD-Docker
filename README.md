# 👩🏻‍💻 StudentCRUD – Spring Boot Student Management System

## 🧾 Project Overview

StudentCRUD is a Student Management System developed using **Spring Boot, Java 21, Spring Data JPA, and MySQL**.

The application provides REST APIs to manage student records and perform CRUD operations.

🐳 Docker and Docker Compose are used to simplify deployment and provide a consistent environment across different machines.

## 💫 Technologies Used

- ☕ Java 21
- 🍃 Spring Boot 4.0.6
- 🌐 Spring Web MVC
- 🗄️ Spring Data JPA
- 🐬 MySQL 8.4
- 📦 Maven
- 🐳 Docker & Docker Compose
- 🌿 Git & GitHub

## ✨ Features

- ➕ Add new students
- 📋 View all students
- 🔍 Search for students by ID
- ✏️ Update student information
- 🗑️ Delete student records
- 🗄️ Store student data in MySQL
- 🌐 REST API Support
- 🐳 Run the application using Docker

## 📚 Project Structure

```text
StudentCRUD-Docker/
├── .mvn/
├── src/
├── docs/
│   ├── screenshots/
│   └── notes.md
├── .dockerignore
├── .gitignore
├── docker-compose.yml
├── Dockerfile
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## ⚙️ Prerequisites

To run the application using Docker, install:

- 🐳 Docker Desktop
- Docker Compose (included with Docker Desktop)
- Git (optional, for cloning the repository)

**Note:** Java, Maven, and MySQL do not need to be installed locally when running the application using Docker.

## 🔐 Environment Configuration

Create a `.env` file in the project root directory.

Add the following variables:

```env
DB_PASSWORD=replace_with_your_database_password
DB_ROOT_PASSWORD=replace_with_your_root_password
```

Replace the example values with two different, secure passwords.

**Important:** Do not upload the `.env` file to GitHub.

## 🐳 Build and Run with Docker

### 1️⃣ Open the Project

Open PowerShell or the VS Code terminal inside the project directory.

### 2️⃣ Check Docker Compose Configuration

```bash
docker compose config --quiet
```

### 3️⃣ Build and Start Containers

```bash
docker compose up --build -d
```

This command builds the Spring Boot application and starts the application and MySQL containers.

### 4️⃣ Check Running Containers

```bash
docker compose ps
```

The application and database containers should be running.

### 5️⃣ Access the Application

Open your browser and visit:

http://localhost:9090/students

The API returns the student records in JSON format.

## 🌐 REST API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/students` | View all students |
| GET | `/students/{id}` | Get student by ID |
| POST | `/students` | Add a new student |
| PUT | `/students/{id}` | Update student information |
| DELETE | `/students/{id}` | Delete a student |

## ➕ Example: Add a Student

Send a POST request to:

`http://localhost:9090/students`

Using the following JSON body:

```json
{
  "name": "waed",
  "major": "Computer Science",
  "grade": 90
}
```

The application stores the student information in MySQL and returns the saved student data with an automatically generated ID.

## 🛑 Stop the Application

To stop the running containers:

```bash
docker compose down
```

The MySQL named volume preserves stored data when the containers are stopped.

## 🛠️ Troubleshooting

### ❌ Docker Engine Is Not Running

Start Docker Desktop and check the connection:

```bash
docker info
```

### ❌ Application Is Not Responding

Check the containers and application logs:

```bash
docker compose ps
docker compose logs app
```

### ❌ Database Connection Problem

Check the MySQL logs:

```bash
docker compose logs db
```

Make sure the database credentials in `.env` are configured correctly.

## 📸 Screenshots and Testing

The project was tested using Docker and PowerShell.

The following REST API operations were successfully tested:

- ✅ CREATE – Add Student
- ✅ READ – View Students
- ✅ UPDATE – Update Student
- ✅ DELETE – Delete Student

Screenshots of the Docker build, running containers, and REST API tests are available in:

`docs/screenshots/`

## 📝 Technical Notes

Additional information about the Docker implementation, commands, and troubleshooting is available in:

`docs/notes.md`

## 🌟 Project Origin

This project was adapted from my original StudentCRUD application:

https://github.com/waedtot-svg/StudentCRUD

The original project also includes a JavaFX interface. This Docker configuration runs the Spring Boot REST API and MySQL database.

Docker configuration and documentation were added for **OS Lab Assignment #2 – Docker & GitHub**.

---

### 💻 Developed and documented for OS Lab Assignment #2
