# 👩🏻‍💻 StudentCRUD – Student Management System

## 🧾 About the Project

StudentCRUD is a student management system that I developed using Java, Spring Boot, and MySQL.

The project provides REST APIs for managing student information. It allows me to add students, view their details, update their information, and delete records.

For **OS Lab Assignment #2**, I worked on running this project with Docker instead of setting up the application and database separately.

I also used Git and GitHub to organize my changes and keep track of my work.

## 💻 Technologies Used

- Java 21
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data JPA
- MySQL 8.4
- Maven
- Docker and Docker Compose
- Git and GitHub
- GitHub Actions
- PowerShell

## ✨ What the Project Can Do

The application supports these operations:

- Add a new student.
- View all students.
- Find a student by ID.
- Update student information.
- Delete a student.
- Store student records in MySQL.

I tested these operations through the REST API.

## 📂 Project Structure

```text
StudentCRUD-Docker/
├── .github/
│   └── workflows/
│       └── docker-build.yml
├── .mvn/
├── src/
├── scripts/
│   ├── start.ps1
│   ├── status.ps1
│   └── stop.ps1
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

The `docs/screenshots` folder contains screenshots of the steps I completed during the assignment.

I also added `docs/notes.md` to explain the problems I faced and what I learned.

## ⚙️ Before Running the Project

To run my project with Docker, I need:

- Docker Desktop
- Docker Compose, which comes with Docker Desktop
- Git, if I want to clone the project from GitHub

I do not need to install MySQL or Maven separately to run the Docker version.

## 🔐 Database Configuration

Before starting the containers, I create a `.env` file in the main project folder.

It contains the database passwords:

```env
DB_PASSWORD=your_database_password
DB_ROOT_PASSWORD=your_root_password
```

I replace these example values with two different passwords.

I keep this file private and do not upload it to GitHub.

## 🐳 How I Run the Project

### Step 1 – Open the project

I open the StudentCRUD-Docker folder in VS Code and use the PowerShell terminal.

### Step 2 – Check the Docker configuration

```powershell
docker compose config --quiet
```

I use this command to check the Docker Compose configuration before starting the containers.

### Step 3 – Build and start

```powershell
docker compose up --build -d
```

This builds the application image and starts Spring Boot and MySQL.

### Step 4 – Check the containers

```powershell
docker compose ps
```

I use this command to make sure the containers are running.

Both containers also have Docker Healthchecks.

### Step 5 – Open the API

After the application starts, I open:

http://localhost:9090/students

The page returns the student data in JSON format.

I can also check the application health using:

http://localhost:9090/actuator/health

When the application is healthy, the endpoint returns an `UP` status.

## 🌐 REST API Endpoints

| Method | Endpoint | What it does |
|---|---|---|
| GET | `/students` | Shows all students |
| GET | `/students/{id}` | Finds a student by ID |
| POST | `/students` | Adds a student |
| PUT | `/students/{id}` | Updates a student |
| DELETE | `/students/{id}` | Deletes a student |

### Example – Adding a Student

To add a student, I send a POST request to:

`http://localhost:9090/students`

Example JSON:

```json
{
  "name": "waed",
  "major": "Computer Science",
  "grade": 90
}
```

The application saves the student in MySQL and gives the new record an ID.

I tested the other CRUD operations as well.

## 🛑 Stopping the Containers

When I finish, I use:

```powershell
docker compose down
```

This stops and removes the containers.

I used a named Docker volume for MySQL, so the saved data can remain available when I start the containers again.

## 🚀 PowerShell Scripts – Bonus E

I also created three PowerShell scripts to make Docker commands easier to run on Windows.

### Start the project

```powershell
powershell.exe -NoProfile -ExecutionPolicy RemoteSigned -File ".\scripts\start.ps1"
```

### Check container status

```powershell
powershell.exe -NoProfile -ExecutionPolicy RemoteSigned -File ".\scripts\status.ps1"
```

### Stop the project

```powershell
powershell.exe -NoProfile -ExecutionPolicy RemoteSigned -File ".\scripts\stop.ps1"
```

I tested all three scripts.

The execution policy option is applied to the PowerShell process started by the command.

## ⭐ Extra Tasks I Completed

Besides the main assignment, I completed the bonus tasks.

**Bonus A – Docker Compose**

I used Docker Compose to start the application and MySQL together.

**Bonus B – GitHub Actions**

I created a workflow called Docker Image CI. It builds the Docker image when changes are pushed to `main` or when a Pull Request is opened.

I checked the workflow results on GitHub, and the Docker build passed.

**Bonus C – Multi-stage Dockerfile**

My Dockerfile has two stages. The first uses Maven to build the project, and the second uses Java to run the application.

**Bonus D – Healthcheck**

I added Spring Boot Actuator and Docker Healthchecks. I tested the application health endpoint and checked the container statuses.

**Bonus E – PowerShell Scripts**

I created `start.ps1`, `status.ps1`, and `stop.ps1` and tested them.

**Bonus G – Pull Request**

I created a separate branch called `ci/update-github-actions` to update my GitHub Actions workflow.

I opened Pull Request #1, checked that the Docker build passed, and then merged it into `main`.

## 🛠️ Problems I Faced

I faced a few problems while preparing the project.

**Docker Engine was not running**

I opened Docker Desktop and checked the connection using:

```powershell
docker info
```

**The application could not connect to MySQL**

I changed the database host from `localhost` to the Docker Compose service name `db`.

**PowerShell blocked my scripts**

I ran the scripts using a PowerShell command with `-ExecutionPolicy RemoteSigned`.

I wrote more details about these problems in `docs/notes.md`.

## 🧪 Testing and Screenshots

During the assignment, I tested:

- Building the Docker image.
- Starting and stopping the containers.
- Connecting the application to MySQL.
- Adding, viewing, updating, and deleting students.
- Checking the application health.
- Running the PowerShell scripts.
- Building the Docker image through GitHub Actions.
- Creating and merging a Pull Request.

The Maven packaging build succeeded with automated tests skipped.

I saved screenshots of the main steps in:

`docs/screenshots/`

## 📝 My Technical Notes

I wrote about my work, the errors I faced, and the things I learned in:

`docs/notes.md`

## 🔗 GitHub Repositories

**My Docker assignment project:**

https://github.com/waedtot-svg/StudentCRUD-Docker

To clone it:

```bash
git clone https://github.com/waedtot-svg/StudentCRUD-Docker.git
```

**My original StudentCRUD project:**

https://github.com/waedtot-svg/StudentCRUD

My original project also has a JavaFX interface. For this assignment, I used the Spring Boot REST API with MySQL inside Docker.

---

*Developed and documented for OS Lab Assignment #2 – Docker & GitHub.*