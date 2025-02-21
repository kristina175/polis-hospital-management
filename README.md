Polis Healthy Hospital - Patient Management System

Project Description

This project is a hospital management system for Polis Healthy Hospital (PHH), developed using Java Spring Boot and a relational database (MySQL or PostgreSQL). The system is designed to manage patient admissions, discharges, department transfers, and clinical data.

Features

Manage Departments with patient tracking.

Handle Patient Admissions and Discharges.

Record and update Clinical Data.

Enforce business constraints, such as preventing the deletion of entities with active dependencies.

Implement exception handling to provide meaningful error messages for users.

Provide a RESTful API for interaction with the system.

Perform unit tests using JUnit for at least five services.

Technologies Used

Java 17

Spring Boot 3 (Spring MVC, Spring Data JPA, Spring Security)

MySQL/PostgreSQL (Choose one as the database)

Hibernate (ORM for database operations)

JUnit 5 (for unit testing)

Maven (for dependency management)

GitHub (version control)

Project Structure

polishospital-management/
│── src/
│   ├── main/
│   │   ├── java/com/polis/hospital/
│   │   │   ├── controller/       # REST Controllers
│   │   │   ├── service/          # Service Layer
│   │   │   ├── repository/       # Data Access Layer
│   │   │   ├── dto/              # Data Transfer Objects
│   │   │   ├── entities/         # JPA Entities
│   │   │   ├── exception/        # Custom Exceptions
│   │   ├── resources/
│   │       ├── application.properties # Configuration File
│   ├── test/java/com/polis/hospital/  # Unit Tests
│── pom.xml         # Maven Build File
│── README.md       # Project Documentation

Installation & Setup

Prerequisites

Install Java 17

Install Maven

Install MySQL or PostgreSQL

Install Git

Clone the Repository

git clone https://github.com/yourusername/polishospital-management.git
cd polishospital-management

Configure Database

Modify application.properties to match your database settings:

spring.datasource.url=jdbc:mysql://localhost:3306/polis_hospital
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

Run the Application

mvn spring-boot:run

The application will be available at http://localhost:8080

API Endpoints

HTTP Method

Endpoint

Description

GET

/departments

Get all departments

POST

/departments

Add a new department

DELETE

/departments/{id}

Delete a department (if empty)

GET

/patients

Get all patients

POST

/patients

Add a new patient

PUT

/patients/{id}

Update patient details

DELETE

/patients/{id}

Delete a patient record

POST

/admissions

Admit a patient

POST

/discharges

Discharge a patient

POST

/clinical-data

Add clinical data for a patient

Unit Testing

Run unit tests with:

mvn test

Tests are implemented for the following services:

DepartmentService

PatientService

AdmissionService

DischargeService

ClinicalDataService

Error Handling

If an entity cannot be deleted due to dependencies, a 400 Bad Request is returned.

All server-side exceptions are logged and translated into meaningful messages for the client.

Deployment

The application can be deployed on a cloud server like Heroku or AWS.

Docker support can be added for containerized deployment.

Contribution

To contribute:

Fork the repository.

Create a new branch (feature-xyz).

Commit and push your changes.

Open a pull request.

Project Presentation Requirements

List of RESTful services

Unit test descriptions

Screenshots of the application

Screenshots of test executions

UML diagrams for controllers, services, DTOs, and entities


GitHub User for Review: kristina175

License

This project is licensed under the MIT License.

