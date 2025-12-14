Introduction to Programming – Final Project

Student Name: Ryan Kung
Student ID: 2541660

Project Overview

This project demonstrates a simple student-course management system. The system includes:

Address – Represents a student’s address with postal code validation.

Department – Departments with auto-generated IDs and name validation.

Student – Students with auto-generated IDs, gender, address, department, and course registration.

Course – Courses with auto-generated IDs, assignments, registered students, and score management.

Assignment – Assignments with auto-generated IDs, weight, scores, and average calculation.

Util – Helper class for formatting names in title case.

Features

Auto-generated IDs for Students, Departments, Courses, and Assignments.

Validation for department names and postal codes.

Register and drop courses for students.

Add assignments to courses and generate random scores.

Calculate weighted assignment averages.

Demonstrates use of Lombok for simple getter/setter/toString methods.

Repository Structure
src/
 └── org/ryank/
     ├── Address.java
     ├── Department.java
     ├── Student.java
     ├── Course.java
     ├── Assignment.java
     ├── Util.java
     └── Main.java
class-diagram.png
README.md

How to Run

Open the project in IntelliJ IDEA.

Build the project and run Main.java to see example usage of classes.

Observe student registration, assignment score generation, and course management in the console.
