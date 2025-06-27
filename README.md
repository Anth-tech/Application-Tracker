# Job Application Tracker API

A secure and scalable Spring Boot REST API for managing and tracking job applications across various job boards and companies. This backend system is designed to allow users to register, log in, and manage their job application data in a personalized and protected environment.

---

##  Features

- ✅ **User Registration & Authentication** with JWT
- ✅ **Role-Based Access Control** using Spring Security
- ✅ **Secure Password Hashing** (BCrypt)
- ✅ **Personalized Application Management** (users can only access their own data)
- ✅ **Company Entities Linked to Applications**
- ✅ **Pagination Support** for listing applications
- ✅ **User Deletion with Cascade Cleanup**
- ✅ **Exception Handling and Authorization Checks**
- 🔒 **Protected API Endpoints**
- 🛠️ **PostgreSQL Database Integration**

---

##  Technologies Used

- Java 21+
- Spring Boot 3
- Spring Security
- JWT (JSON Web Tokens)
- Spring Data JPA (Hibernate)
- PostgreSQL
- Gradle

---

## Endpoints Overview

| Endpoint                      | Method | Description                              | Auth Required |
|------------------------------|--------|------------------------------------------|---------------|
| `/api/auth/signup`           | POST   | Register a new user                      | ❌            |
| `/api/auth/signin`           | POST   | Authenticate user, return JWT            | ❌            |
| `/api/applications`          | GET    | List applications (paginated)            | ✅            |
| `/api/applications/{id}`     | GET    | Get a specific application (by ID)       | ✅            |
| `/api/applications`          | POST   | Create a new application                 | ✅            |
| `/api/applications/{id}`     | PUT    | Update a user's own application          | ✅            |
| `/api/applications/{id}`     | DELETE | Delete a user's own application          | ✅            |
| `/api/account`               | DELETE | Delete logged-in user + related data     | ✅            |

> ⚠️ All authenticated routes require a valid JWT via `Authorization: Bearer <token>`

---

##  Setup Instructions

### 1. Clone the Repo

```bash
git clone https://github.com/yourusername/job-application-tracker-api.git
cd job-application-tracker-api
```

### 2. Configure PostgreSQL
Create a database and update your `application.properties` or `application.yml`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/jobtracker
spring.datasource.username=youruser
spring.datasource.password=yourpass
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build & Run
```bash
./gradlew bootRun
```

### 4. Test the API
```bash
curl -X POST http://localhost:8080/api/auth/signin
```

---

##  Authentication & Security

- JWT-based stateless authentication

- Passwords are stored securely using BCrypt

- All routes are secured by default and require valid tokens

- Users can only CRUD their own application data

---

##  Roadmap

-  Add email verification on signup

-  Implement logout and token revocation (blacklist or refresh tokens)

-  Add DTOs for clean API responses

-  Integrate Swagger/OpenAPI documentation

-  Build a frontend in React/Svelte for public use

-  Deploy to Render or Railway

---

##  License

This project is open-source and available under the MIT License.

---

##  About the Developer

This project was created by Anthony Chapman as a practical solution for managing personal job applications. It serves as a full-featured backend designed with best practices in mind and is intended to grow into a full-stack application.