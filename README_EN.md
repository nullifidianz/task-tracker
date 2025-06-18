# Task Tracker

[![Português Brasileiro](https://img.shields.io/badge/vers%C3%A3o%20em%20portugu%C3%AAs-pt--br-green)](./README.md)

A simple task manager in Java that saves tasks to a JSON file with a colored terminal interface. Following [roadmap.sh projects guide](https://roadmap.sh/projects/task-tracker) as reference

## 🚀 Features

- ✅ Add tasks
- ✅ Update task descriptions
- ✅ Delete tasks
- ✅ Mark tasks as "in progress" or "completed"
- ✅ List all tasks
- ✅ List tasks by status
- 🎨 Colored terminal interface
- 📊 Formatted table with colors

## 🛠️ How to Use (with Maven)

### 1. Compile and package the project

Generate a "fat" JAR (with all dependencies) using:

```bash
mvn clean package
```

The generated file will be in `target/task-tracker.jar`.

### 2. Execute commands

Run the JAR using:

```bash
java -jar target/task-tracker.jar <command>
```

#### 📝 Usage examples:

- **Add task:**
  ```bash
  java -jar target/task-tracker.jar add "Task description"
  ```
- **Update task:**
  ```bash
  java -jar target/task-tracker.jar update <TASK_ID> "New description"
  ```
- **Delete task:**
  ```bash
  java -jar target/task-tracker.jar delete <TASK_ID>
  ```
- **Mark as in progress:**
  ```bash
  java -jar target/task-tracker.jar mark-in-progress <TASK_ID>
  ```
- **Mark as completed:**
  ```bash
  java -jar target/task-tracker.jar mark-done <TASK_ID>
  ```
- **List all tasks:**
  ```bash
  java -jar target/task-tracker.jar list
  ```
- **List tasks by status:**
  ```bash
  java -jar target/task-tracker.jar list todo
  java -jar target/task-tracker.jar list in-progress
  java -jar target/task-tracker.jar list done
  ```

## 📊 Available Status

- `TODO` - Pending task (yellow)
- `IN_PROGRESS` - Task in progress (blue)
- `COMPLETED` - Completed task (green)

## 🎨 Interface Colors

- ✅ **Green**: Success messages
- ❌ **Red**: Error messages
- ⚠️ **Yellow**: Warnings and pending tasks
- 📝 **Blue**: Information and tasks in progress
- 🎯 **Purple**: Titles and headers
- 💡 **Bright white**: Task IDs

## 💾 Data File

Tasks are saved in the `tasks.json` file in the project root.

## 🛠️ Technologies

- Java 24
- Maven
- Jackson (JSON parsing)
- JSR-310 (Java Time API)
- ANSI Escape Codes (terminal colors)

## 📋 Prerequisites

- Java 24 or higher
- Maven 3.6 or higher
- Terminal that supports ANSI colors (Windows 10+, Linux, macOS)

## 🚀 Quick Example

```bash
# Compile
mvn clean package

# Add tasks
java -jar target/task-tracker.jar add "Study Java"
java -jar target/task-tracker.jar add "Do exercises"
java -jar target/task-tracker.jar add "Review code"

# List all tasks
java -jar target/task-tracker.jar list

# Mark a task as completed
java -jar target/task-tracker.jar mark-done <TASK_ID>
```

## 📝 Command Reference

| Command            | Description              | Example                         |
| ------------------ | ------------------------ | ------------------------------- |
| `add`              | Add a new task           | `add "Task description"`        |
| `update`           | Update task description  | `update <ID> "New description"` |
| `delete`           | Delete a task            | `delete <ID>`                   |
| `mark-in-progress` | Mark task as in progress | `mark-in-progress <ID>`         |
| `mark-done`        | Mark task as completed   | `mark-done <ID>`                |
| `list`             | List all tasks           | `list`                          |
| `list todo`        | List pending tasks       | `list todo`                     |
| `list in-progress` | List tasks in progress   | `list in-progress`              |
| `list done`        | List completed tasks     | `list done`                     |

## 🎯 Project Structure

```
task-tracker/
├── src/main/java/com/nullifidianz/
│   ├── Main.java                 # Main application entry point
│   ├── enums/
│   │   └── Status.java          # Task status enumeration
│   ├── model/
│   │   └── Task.java            # Task entity
│   ├── repository/
│   │   └── TaskRepository.java  # Data persistence layer
│   ├── service/
│   │   └── TaskService.java     # Business logic layer
│   └── utils/
│       ├── ConsoleColors.java   # Terminal color utilities
│       ├── TaskJsonParser.java  # JSON serialization
│       └── TaskPrinter.java     # Table formatting
├── pom.xml                      # Maven configuration
├── README.md                    # English documentation
├── README.pt-br.md              # Portuguese documentation
└── tasks.json                   # Task data file (generated)
```
