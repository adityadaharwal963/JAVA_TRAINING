# Project Documentation

This project is a Java-based command-line application designed for dynamic database management. It allows users to define table structures, modify them, perform CRUD operations, and handle data backup (import/export) functionalities.

## Project Structure

The project consists of several classes, each with specific responsibilities:

### 1. Main Entry Point
- **[Main.java](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/Main.java#L9)**: The entry point of the application. It instantiates the `Application` class and calls its `run()` method.

### 2. Application Logic
- **[Application.java](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/Application.java#L6)**: Contains the main application loop and menu system. It directs user choices to the appropriate handlers for table management, CRUD operations, or backup tasks.
    - `run()`: [Line 7](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/Application.java#L7)

### 3. Database Connection
- **[DBConnection.java](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/DBConnection.java#L6)**: Manages the connection to the PostgreSQL database using JDBC.
    - Configuration: [Lines 9-11](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/DBConnection.java#L9-L11)

### 4. Dynamic Table Management
- **[DynamicTable.java](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/DynamicTable.java#L9)**: Handles the creation and modification of database tables.
    - `createTable()`: [Line 37](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/DynamicTable.java#L37)
    - `modifyTable()`: [Line 14](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/DynamicTable.java#L14)

### 5. CRUD Operations
- **[CURD.java](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/CURD.java#L12)**: Handles Create, Read, Update, and Delete operations for a specific table.
    - `insert()`: [Line 44](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/CURD.java#L44)
    - `update()`: [Line 93](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/CURD.java#L93)
    - `delete()`: [Line 135](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/CURD.java#L135)
    - `read()`: [Line 155](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/CURD.java#L155)

### 6. Backup Operations
- **[BackupOperation.java](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/BackupOperation.java#L11)**: Manages importing data from files to the database and exporting table data to files.
    - `importData()`: [Line 12](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/BackupOperation.java#L12)
    - `exportData()`: [Line 79](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/BackupOperation.java#L79)

### 7. Utilities
- **[Utils.java](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/Utils.java#L9)**: Provides utility methods to retrieve database schema information.
    - `columns()`: [Line 10](https://github.com/adityadaharwal963/JAVA_TRAINING/blob/82f769bb89856323d673dbab36e44f9948e627bf/src/week5/Problem1/src/main/java/org/example/Utils.java#L10)
