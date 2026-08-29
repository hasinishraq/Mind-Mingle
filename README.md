# 🧠 Mind-Mingle

> A collaborative learning platform built with JavaFX — bringing students together through real-time chat, screen sharing, interactive whiteboards, group study, and structured course management.

---

## ✨ Features

### 👤 Authentication & Profiles
- **Student Sign-up & Login** — Secure account creation and authentication backed by MySQL
- **Admin Login** — Separate admin portal for platform management
- **Profile Management** — View and update personal profile, change avatar

### 📚 Course Management
- **Browse Courses** — Students can explore available courses
- **Enrolled Courses** — Track and access ongoing courses
- **Course Designer** — Create and manage course content (lectures, books, pictures)
- **Content Viewer** — Rich content viewer for course materials

### 👥 Group Collaboration
- **Create Groups** — Form study groups with other students
- **Group Dashboard** — Central hub for all collaborative tools within a group
- **View Group Members** — See who's in your study group

### 💬 Real-time Chat
- **Live Messaging** — Socket-based real-time chat between students
- **Group Chat** — Communicate with your study group in real time

### 🖥️ Screen Sharing
- **Share Your Screen** — Broadcast your screen to peers using JavaFX Robot API
- **View Shared Screen** — Watch a peer's screen in real time

### 🎨 Collaborative Whiteboard
- **Interactive Drawing Canvas** — Draw, sketch, and annotate in real time
- **Brush Customization** — Adjustable brush size via JFX slider
- **Color Picker** — Full color palette support
- **Text Annotations** — Add custom text anywhere on the canvas
- **Annotation Toggle** — Easily switch between annotation mode and view mode
- **Whiteboard Sharing** — Share your whiteboard with group members

### 🎬 Animation Viewer
- Integrated animation/media viewer for educational content

### 🛡️ Admin Dashboard
- **Platform Overview** — Admin control panel for managing the platform

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| **Language** | Java 21 |
| **UI Framework** | JavaFX 21 (FXML) |
| **UI Components** | JFoenix 9.0.8 |
| **Database** | MySQL 8.0 (via mysql-connector-java) |
| **Networking** | Java Sockets (TCP) |
| **Build Tool** | Apache Maven |
| **Testing** | JUnit Jupiter 5.10.0 |

---

## 📁 Project Structure

```
Mind-Mingle/
├── src/
│   └── main/
│       ├── java/
│       │   ├── module-info.java
│       │   └── project/
│       │       ├── Launcher.java
│       │       ├── controllers/
│       │       ├── models/
│       │       ├── services/
│       │       ├── database/
│       │       ├── socket/
│       │       ├── middlewares/
│       │       ├── enums/
│       │       ├── DataInstances/
│       │       └── viewer/
│       └── resources/
│           └── views/
│               └── ui/
├── Dependencies/
└── pom.xml
```

---

## ⚙️ Prerequisites

- **Java 21** or higher
- **Apache Maven 3.8+**
- **MySQL 8.0** database server

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/hasinishraq/Mind-Mingle.git
cd Mind-Mingle
```

### 2. Configure the Database

Open `src/main/java/project/database/Configs.java` and update:

```java
protected String dbHost = "your-db-host";
protected String dbPort = "3306";
protected String dbUser = "your-username";
protected String dbPassword = "your-password";
protected String dbName = "mindmingle";
```

> ⚠️ Never commit real credentials to version control.

### 3. Build & Run

```bash
mvn clean javafx:run
```

---

## 🏗️ Architecture

Mind-Mingle follows an **MVC** pattern:

- **Models** — Domain entities (Student, Course, Group, etc.)
- **Views** — FXML layout files
- **Controllers** — JavaFX controllers for UI interaction
- **Services** — Database operation services
- **ViewManager** — Centralized scene navigation
- **Socket Layer** — TCP sockets for real-time features

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature`
3. Commit your changes: `git commit -m "feat: add your feature"`
4. Push to your branch: `git push origin feature/your-feature`
5. Open a Pull Request

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

## 👨‍💻 Author

**hasinishraq** — [GitHub Profile](https://github.com/hasinishraq)

---

<p align="center">Made with ❤️ and JavaFX</p>
