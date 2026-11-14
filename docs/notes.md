# 📝 My Technical Notes – StudentCRUD

## About My Work

For this assignment, I worked on my StudentCRUD project, which I had already developed using Java and Spring Boot.

My main goal was to run the project using Docker and connect it to MySQL.

I also worked with Git and GitHub to save my changes and document the steps I completed.

I had some problems while working on the assignment, but I was able to solve them and continue.

## 🐳 Working with Docker

I started by preparing a Dockerfile for my Spring Boot project.

I used a multi-stage Dockerfile, so Maven builds the project in one stage, and Java runs it in another stage.

After that, I created a `docker-compose.yml` file to run the application and MySQL together.

These are the main commands I used:

- `docker compose config --quiet`
- `docker compose up --build -d`
- `docker compose ps`
- `docker compose down`

I also used `docker info` when I needed to check Docker.

## ⚠️ Problems I Faced

### 1. Docker Engine Was Not Running

The first problem I faced was with Docker Desktop.

When I tried to run Docker commands, I got an error because Docker Engine was not running.

I opened Docker Desktop and checked Docker using `docker info`.

After Docker started correctly, I tried the commands again, and they worked.

### 2. MySQL Connection Problem

I also had a problem connecting my Spring Boot application to MySQL.

At first, the database connection used `localhost`.

I changed the configuration to use `db`, which is the MySQL service name in Docker Compose.

After that, the application was able to connect to the database.

### 3. PowerShell Scripts Problem

I created three scripts to make Docker commands easier.

When I first tried to run a script, PowerShell blocked it because of the execution policy.

I solved this by running the script with `powershell.exe` and the `-ExecutionPolicy RemoteSigned` option.

Then I tested the start, status, and stop scripts, and they worked.

### 4. GitHub Authentication Problem

I also had an issue when trying to authenticate with GitHub.

I checked my Git credentials and completed the sign-in through the browser.

After that, I was able to push my project changes to GitHub.

## ✅ Testing My Project

After fixing the Docker and database problems, I tested my REST API.

I tried adding a new student and checking that the information was saved.

Then I used the student ID to view the record and update its information.

I also tested deleting the student and checking the student list again.

I tested all five API operations:

- GET
- POST
- PUT
- DELETE
- GET by ID

The API requests worked as expected.

I also checked that both the application and MySQL containers were healthy.

My Maven package build succeeded, but I skipped the automated tests.

## ⭐ Bonus Tasks

I completed the following bonus tasks:

**Bonus A – Docker Compose**

I used Docker Compose to run my application and MySQL together.

**Bonus B – GitHub Actions**

I created a workflow to build my Docker image on GitHub.

I checked its result, and the build was successful.

**Bonus C – Multi-stage Build**

I used a multi-stage Dockerfile to separate building the project from running it.

**Bonus D – Healthcheck**

I added Spring Boot Actuator and tested the health endpoint.

The application returned `UP`, and the Docker containers were healthy.

**Bonus E – PowerShell Scripts**

I created and tested three scripts: `start.ps1`, `status.ps1`, and `stop.ps1`.

**Bonus G – Pull Request**

I created a new Git branch, made a change to the GitHub Actions workflow, and opened Pull Request #1.

I checked the workflow results before merging the Pull Request into `main`.

## 💡 What I Learned

### What was the biggest Docker problem?

For me, the biggest Docker problem was getting everything to run correctly at the beginning.

Docker Engine was not running, so I could not start my containers.

After fixing that, I also needed to correct the MySQL connection.

I learned that I should first check Docker Desktop and the container configuration when something does not work.

### What did I learn from Git and GitHub?

I learned more about organizing my project using Git.

I practiced making commits, pushing changes, creating a new branch, and opening a Pull Request.

I also saw how GitHub Actions can build my Docker image automatically.

One thing I liked was that I could check whether my changes worked before merging them into the main branch.

## 🔐 Security

I stored my database passwords in a local `.env` file instead of writing them directly in the project documentation.

I added `.env` to `.gitignore` so I would not upload my passwords to GitHub.

## 📸 Documentation

I took screenshots while testing the project and saved them in `docs/screenshots/`.

These screenshots show the Docker commands, API tests, health checks, PowerShell scripts, GitHub Actions, and Pull Request.