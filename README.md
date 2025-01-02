# EquadisRJP

This is a **Customer and Bank Account System** designed to handle the creation of customers, bank accounts, and transactions. The system allows users to:
- Create a customer and link them to a bank account.
- Deposit and withdraw money from accounts.
- Track transactions related to each account.

The project is built with **Spring Boot**, **Java 21**, and **MySQL** for data persistence. I attempted to use Docker containers, but unfortunately, I couldn't get it to work. The issue occurred while trying to containerize the MySQL service, as I was unable to properly access the database inside the Docker container. I wasn't able to complete the task, but I feel like I was very close.

## Features
- **Create Customers**: API to create customers and associate them with bank accounts.
- **Create Accounts**: Allows users to create bank accounts linked to customers.
- **Deposit and Withdraw**: APIs to deposit or withdraw money from accounts while maintaining balance integrity.
- **Transaction History**: Track all deposits and withdrawals for an account.

## Technologies Used
- **Java 21**
- **Maven 3.8.6**
- **Spring Boot 3.x**
- **MySQL** (for data persistence)
- **Docker** (to containerize the application and database) (Not finished)

## Before Setup
This project has two branches: the `main` branch and the `dev` branch. The `main` branch contains a work-in-progress version from when I was trying to set up Docker containers. If you're interested in seeing how far I got, feel free to check it out, though I must apologize as it doesn’t run properly. The `dev` branch is the version without Docker containers, which can be run directly. I’ve shared my MySQL service, so it should work as expected."

## Setup Instructions (For `dev` branch only)

### 1. Clone the Repository
Clone this repository to your local machine:
```bash
cd your-repository
git clone https://github.com/DavidFranciscoZhuSun/EquadisRJP.git
```

### 2. Run/Debug Configurations
Please select **Run on:** local Machine
**Build and Run** Setting: Please select Java 21
If you find any 'Error', you can check your computer`s System environment variables, see if JAVA_HOME version is correct.

## API Endpoints
I have update an `Equadis backend test.postman_collection.json` file, you can import it into postman to check and test all the APIs.

### Customer Endpoints
- **GET** `/customer/{email}` — Search the customer by email.

- **POST** `/customers/create` — Create a new customer.
  - **Request Body**:
    ```json
    {
      "name": "John Doe",
      "email": "John@123.com"
    }
    ```

### Account Endpoints
- **GET** `/account/{id}` — Search the Account by id.

- **GET** `/account/check` — Check the account`s password.
  - **Request Params**:
    `key: id, value: 1, type: long`
    `key: password, value: 123456, type: string`
    
- **POST** `/account/create` — Create a new account with an initial balance.
  - **Request Body**:
    ```json
    {
      "email": 1,
      "password": "999999",
      "balance": 1000.0
    }
    ```

### Transaction Endpoints
- **GET** `/trans/{id}` — Get transaction by id.

- **GET** `/trans/all` — Get all transactions for an account by customerId.
  - **Request Params**:
    `key: accountId, value: 4, type: long`

- **POST** `/trans/create` — Create a new transaction.
  - **Request Body**:
    ```json
    {
      "accountId": 4,
      "amount": 100,
      "action": "deposit"
    } 
    ```

Let me know if you'd like to add or adjust anything!
