# Mini Banking System

A Java Object-Oriented Programming (OOP) project demonstrating basic banking operations.

## Description

This project implements a simple banking system using Java OOP principles. It provides fundamental banking functionalities including account creation, deposits, withdrawals, and balance inquiries.

## Features

- **Account Creation**: Create new bank accounts with unique account numbers
- **Deposit**: Add funds to an existing account
- **Withdraw**: Withdraw funds from an account (with balance validation)
- **Balance Inquiry**: Check current account balance

## Technologies Used

- Java
- Object-Oriented Programming (OOP) concepts
  - Classes and Objects
  - Encapsulation
  - Methods and Attributes

## Project Structure

```
mini-banking-system/
├── README.md
└── Bank.java
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java IDE (Eclipse, IntelliJ IDEA, or VS Code) or command line

### Running the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/shithel9360/mini-banking-system.git
   ```

2. Navigate to the project directory:
   ```bash
   cd mini-banking-system
   ```

3. Compile the Java file:
   ```bash
   javac Bank.java
   ```

4. Run the program:
   ```bash
   java Bank
   ```

## Usage Example

The Bank class provides methods to perform various banking operations:

```java
// Create a new account
BankAccount account = new BankAccount("John Doe", 1001);

// Deposit money
account.deposit(5000);

// Withdraw money
account.withdraw(2000);

// Check balance
account.checkBalance();
```

## Learning Objectives

- Understanding Java OOP concepts
- Implementing classes and objects
- Working with methods and attributes
- Basic error handling and validation

## Future Enhancements

- Add transaction history
- Implement multiple account types (Savings, Checking)
- Add interest calculation
- Create a user interface (GUI)
- Add database integration

## Author

shithel9360

## License

This project is open source and available for educational purposes.
