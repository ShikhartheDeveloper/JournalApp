# 📝 JournalApp - A Spring Boot & MongoDB REST API

> A secure journal management RESTful application built using **Spring Boot**, **MongoDB**, and **Spring Security**, allowing users to save, update, and delete personal journal entries.

---

## 📌 Features

* 🔐 User registration and login
* 📚 Create, read, update, and delete (CRUD) journal entries
* 🔗 Journal entries linked to specific users
* 📆 MongoDB database integration
* 📡 RESTful API endpoints
* 📁 Role-based user structure (optional for extension)
* 🚀 Easy integration with front-end frameworks

---

## 🛠️ Tech Stack

| Layer              | Technology           |
| ------------------ | -------------------- |
| Backend Framework  | Spring Boot          |
| Database           | MongoDB (with DBRef) |
| Dependency Tool    | Maven                |
| API Architecture   | REST                 |
| Java Version       | Java 17+             |
| Testing (Optional) | Postman / Swagger    |

---

## 📁 Project Structure

```
com.shikhar.JournalApp
🔹── controller          # REST API endpoints
🔹── entity              # MongoDB documents (User, Journal)
🔹── repository          # MongoRepository interfaces
🔹── service             # Business logic
└── JournalAppApplication.java
```

---


```

## 📓 Journal Entry Model

```json
{
  "title": "My First Entry",
  "content": "Today was productive!"
}
```

---

## 🚀 How to Run Locally

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/JournalApp.git
   cd JournalApp
   ```

2. Configure MongoDB URI in `application.properties`:

   ```properties
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>
   spring.data.mongodb.database=journaldb
   ```

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

4. Test APIs using Postman or Swagger.

---

## 🌐 REST API Endpoints

### 🔸 Users

| Method | Endpoint                           | Description             |
| ------ | ---------------------------------- | ----------------------- |
| POST   | `/users/save`                      | Register a new user     |
| GET    | `/users/find/all`                  | Get all users           |
| GET    | `/users/findbyusername/{username}` | Find user by username   |
| PUT    | `/users/update/{username}`         | Update user by username |

### 🔹 Journals

| Method | Endpoint                          | Description                 |
| ------ | --------------------------------- | --------------------------- |
| POST   | `/journal/{username}`             | Add journal entry for user  |
| GET    | `/journal/{username}`             | Get all journals for a user |
| GET    | `/journal/find/{id}`              | Find journal by ID          |
| PUT    | `/journal/update/{username}/{id}` | Update journal by ID        |
| DELETE | `/journal/delete/{username}/{id}` | Delete journal by ID        |

---

## 💼 Resume/Interview Description

> **JournalApp** is a REST-based Spring Boot application integrated with MongoDB. It implements user-based journal entry management, supporting full CRUD operations via secured endpoints. I used `@DBRef` to associate user entries, ensured data integrity through repository patterns, and enabled transactional safety with `MongoTransactionManager`. This project demonstrates my backend development skills and understanding of real-world API design.

---

## 📈 Future Enhancements

* 🔒 JWT-based authentication
* 🌐 Swagger/OpenAPI integration
* 🖼️ Frontend using React/Angular
* 📅 Calendar view for entries
* ✉️ Email notifications

---

## 📬 Contact

**Developer:** Shikhar Sharwalia
📧 Email: sharwaliashikhar@gmail.com
