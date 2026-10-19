# Personality-Based Career Suggestion System

## Project Overview
The Personality-Based Career Suggestion System is a web application that helps users explore career options based on their personality traits and preferences.

Users answer personality assessment questions and receive career suggestions, including information about required skills, education, and job outlook.

## Technologies Used
- Java
- Spring Boot
- MySQL
- HTML
- CSS
- JavaScript
- Maven

## Key Features
- User registration and login
- Personality assessment questionnaire
- Personality-based career recommendations
- Career information and required skills
- User authentication and admin functionality

## Project Structure
- `src/main/java` — Java backend code
- `src/main/resources/static` — frontend HTML, CSS, and JavaScript files
- `pom.xml` — Maven dependencies and project configuration

## How to Run

### Prerequisites
- Java JDK compatible with the project
- MySQL Server
- Maven (or use the Maven Wrapper if included)

### Setup Instructions
1. Clone or download this repository.
2. Create the MySQL database and import `src/main/resources/data.sql` if the script is compatible with your database setup.
3. Update the database URL, username, and password in `src/main/resources/application.properties`.
4. Set the `JWT_SECRET` environment variable to a strong, randomly generated secret of at least 32 bytes.
5. Build and run the Spring Boot application using Maven.
6. Open `http://localhost:8080` in your browser.

## Note
This project was developed for learning and demonstration purposes. Database and authentication settings may need to be configured for your environment.
