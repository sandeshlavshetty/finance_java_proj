#  Java Finance Project

## Overview

This project is a Java-based finance management application. It allows users to manage transactions, categories, and savings goals.
The application supports operations such as adding, viewing, updating, and deleting transactions, categories, and savings goals.


## Table of Contents

Overview
Features
Setup Instructions
Design
Models
DAOs
Services
Controllers
Assumptions
Usage


## Features

- **User Management**: Register and login functionality.
- **Transaction Management**: Add, view, update, and delete transactions.
- **Category Management**: Add, view, and delete categories.
- **Savings Goal Management**: Add, view, update, and delete savings goals.


## Setup Instructions
- Prerequisites
- Java Development Kit (JDK) 8 or higher
- Git
- An IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VS Code)

## Steps

- 1.Clone the Repository:

- git clone https://github.com/your-username/java-finance-project.git
- cd java-finance-project
- Open the Project in Your IDE:

- 2. Open your IDE and import the project as a Maven or Gradle project.
- Run the Application:

- 3.Locate the Main.java file in the src directory.
Run the Main class.


## Design

## Models

- User: Represents a user with attributes like username and password.
- Transaction: Represents a financial transaction with attributes like id, amount, date, category, description, and username.
- Category: Represents a transaction category with attributes like name and username.
- SavingsGoal: Represents a savings goal with attributes like name, target amount, target date, current amount, and username.

## DAOs

- UserDao: Interface for user-related database operations.
- TransactionDao: Interface for transaction-related database operations.
- CategoryDao: Interface for category-related database operations.
- SavingsGoalDao: Interface for savings goal-related database operations.


## Services

- UserService: Contains business logic related to user operations.
- TransactionService: Contains business logic related to transaction operations.
- CategoryService: Contains business logic related to category operations.
- SavingsGoalService: Contains business logic related to savings goal operations.


## Controllers
- UserController: Handles user-related actions like registration and login.
- TransactionController: Handles transaction-related actions.
- CategoryController: Handles category-related actions.
- SavingsGoalController: Handles savings goal-related actions.


## Assumptions
- The application does not include any persistent storage (like a database); it uses in-memory storage for simplicity.
- The user interface is command-line-based for simplicity.
- Each user is uniquely identified by their username.



# Usage

- 1.Register:
  - Create a new user account.
- 2.Login:
  - Log into the application using your username.
- 3.Manage Transactions:
  - Add a new transaction.
  - View existing transactions.
  - Update an existing transaction.
  - Delete a transaction.
- 4.Manage Categories:
  - Add a new category.
  - View existing categories.
  - Delete a category.
- 5.Manage Savings Goals:
  - Add a new savings goal.
  - View existing savings goals.
  - Update an existing savings goal.
  - Delete a savings goal.
- 6.Logout: Exit the application.
