# Car Garage Billing System

A Java-based console application for managing car garage services and generating invoices for customers.

## Overview

The Car Garage Billing System is designed for "Bharti Car Service Center" to manage customer information, track car services, and generate billing invoices. The system provides a simple console interface for garage staff to add customers and create service invoices.

## Features

- **Customer Management**: Add new customers with their contact details and car information
- **Service Catalog**: Pre-defined services with pricing
- **Invoice Generation**: Create detailed invoices with multiple services
- **Car Tracking**: Track services by car number
- **Interactive Console Interface**: Easy-to-use menu-driven system

## Available Services

The system includes the following pre-configured services:

| Service | Price (₹) |
|---------|-----------|
| Car Wash | 500 |
| Oil Change | 700 |
| Wheel Alignment | 300 |
| Tyre Replacement | 3000 |
| Puncture | 50 |

## Project Structure

```
CarGarageBilling/
├── src/
│   ├── GarageBillingApp.java    # Main application entry point
│   ├── GarageService.java       # Core business logic
│   ├── Customer.java            # Customer data model
│   ├── Car.java                 # Car data model
│   ├── Service.java             # Service data model
│   └── Invoice.java             # Invoice generation and printing
├── CarGarageBilling.iml         # IntelliJ IDEA module file
└── README.md                    # This file
```

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

## How to Run

### Using Command Line

1. **Navigate to the project directory:**
   ```bash
   cd "D:\CarGarageBilling"
   ```

2. **Compile the Java files:**
   ```bash
   javac src/*.java
   ```

3. **Run the application:**
   ```bash
   java -cp src GarageBillingApp
   ```

### Using IntelliJ IDEA

1. Open IntelliJ IDEA
2. Open the project folder: `D:\CarGarageBilling`
3. Right-click on `GarageBillingApp.java` in the src folder
4. Select "Run 'GarageBillingApp.main()'"

### Using Eclipse

1. Open Eclipse
2. Import the project: File → Import → General → Existing Projects into Workspace
3. Select the project folder: `D:\CarGarageBilling`
4. Right-click on `GarageBillingApp.java`
5. Select "Run As" → "Java Application"

## Usage Guide

### Main Menu Options

When you run the application, you'll see the main menu:

```
------------------Bharti Car Service Center------------------
1. Add Customer
2. Display Services
3. Exit
Enter your Choice:
```

### Adding a Customer

1. Select option `1` from the main menu
2. Enter the required information:
   - Customer Name
   - Phone Number
   - Car Number (unique identifier)
   - Car Model

**Example:**
```
Enter Customer Name: John Doe
Enter Phone number: 9876543210
Enter Car Number: MH01AB1234
Enter car Model: Honda City
```

### Creating an Invoice

1. Select option `2` from the main menu
2. Enter the car number for the customer
3. Choose services from the available list:
   - Enter the service number to add it to the invoice
   - Enter `0` when finished selecting services
4. The system will generate and display the invoice

**Example:**
```
Enter car number: MH01AB1234
Available Services:
1. Car Wash - ₹500
2. Oil Change - ₹700
3. Wheel Alignment - ₹300
4. Tyre Replacement - ₹3000
5. Puncture - ₹50

Enter Service number to add or 0 to finish: 1
Service Done.
Enter Service number to add or 0 to finish: 2
Service Done.
Enter Service number to add or 0 to finish: 0
```

### Sample Invoice Output

```
---------------Invoice---------------

Customer: John Doe | Phone: 9876543210 | Car: Honda City | Number: MH01AB1234
Services:
1 Car Wash: ₹500
2 Oil Change: ₹700
Total Amount: ₹1200

-------------Thank You---------------
```

## Class Descriptions

### GarageBillingApp
- **Purpose**: Main application class with user interface
- **Key Methods**: `main()` - handles user input and menu navigation

### GarageService
- **Purpose**: Core business logic for managing customers and services
- **Key Methods**: 
  - `addCustomer()` - adds new customer to the system
  - `createInvoice()` - generates invoice for a customer
  - `loadServices()` - initializes available services

### Customer
- **Purpose**: Data model for customer information
- **Properties**: name, phone, car object

### Car
- **Purpose**: Data model for car information
- **Properties**: carNumber, model

### Service
- **Purpose**: Data model for garage services
- **Properties**: name, price

### Invoice
- **Purpose**: Handles invoice creation and printing
- **Key Methods**:
  - `addService()` - adds service to invoice
  - `printInvoice()` - displays formatted invoice

## Data Storage

- Customer data is stored in memory using a HashMap with car number as the key
- Services are pre-loaded into an ArrayList
- Data is not persistent between application runs

## Future Enhancements

- **Database Integration**: Store customer and invoice data persistently
- **Service Management**: Add/edit/remove services dynamically
- **Customer Search**: Search customers by name or phone number
- **Invoice History**: Track and display past invoices
- **Reporting**: Generate daily/monthly revenue reports
- **GUI Interface**: Replace console interface with graphical user interface

## Troubleshooting

### Common Issues

1. **"No Customer Found" Error**: 
   - Ensure the car number is entered exactly as it was added
   - Car numbers are case-sensitive

2. **Compilation Errors**:
   - Ensure all Java files are in the src directory
   - Check that JDK is properly installed and configured

3. **Runtime Errors**:
   - Make sure to run from the correct directory
   - Verify classpath includes the src directory

## License

This project is created for educational purposes.

## Author

Created for  Car Service Center billing system.
Created By Dipanshu pandey
