# 🚀 Fault Ticketing System (FTS)

[![Angular](https://img.shields.io/badge/Frontend-Angular-red?logo=angular&logoColor=white)](https://angular.io/)  
[![Spring Boot](https://img.shields.io/badge/Backend-Spring%20Boot-green?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)  
[![MySQL](https://img.shields.io/badge/Database-MySQL-blue?logo=mysql&logoColor=white)](https://www.mysql.com/)  
[![Java](https://img.shields.io/badge/Language-Java-orange?logo=openjdk&logoColor=white)](https://www.java.com/)  
[![License](https://img.shields.io/badge/License-MIT-purple)](LICENSE)

---

## 📸 Project Preview

> *(Replace the placeholder image with a screenshot of your app UI)*

![![alt text](image.png)](https://via.placeholder.com/900x400.png?text=Fault+Ticketing+System+Preview)

---

## 🛠️ Tech Stack

- **Frontend:** Angular 16+, TypeScript, Bootstrap, RxJS, ngx-pagination  
- **Backend:** Java 17+, Spring Boot 3, REST API, JPA, Hibernate  
- **Database:** MySQL (or your configured DB)  
- **Build Tools:** Maven, npm  
- **Version Control:** Git & GitHub

---

## 📂 Project Structure

```
FullStack-FTS/
 ├── backend/         # Spring Boot REST API
 │   ├── src/
 │   ├── pom.xml
 │
 ├── frontend/        # Angular UI Application
 │   ├── src/
 │   ├── angular.json
 │
 ├── README.md
 └── .gitignore
```

---

## ✅ Features

### 🚀 Implemented
- ✔ Create new fault tickets  
- ✔ View tickets with **pagination**  
- ✔ Filter tickets by type, status, and date  
- ✔ Delete tickets (single and bulk delete)  
- ✔ Basic authentication (login simulation)  

### 🔄 Under Development
- **Update Ticket Feature:**  
  - Backend API is implemented (`PUT /fault-ticket/tickets/{id}`)  
  - Frontend integration is in progress  

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository
```bash
git clone https://github.com/your-username/FullStack-FTS.git
cd FullStack-FTS
```

### 2️⃣ Run Backend (Spring Boot)
```bash
cd backend
mvn clean install
mvn spring-boot:run
```
- Server will start at **`http://localhost:9090`**

---

### 3️⃣ Run Frontend (Angular)
```bash
cd frontend
npm install
ng serve --open
```
- App will start at **`http://localhost:4200`**

---

## 🧑‍💻 API Endpoints

| Method | Endpoint                     | Description              |
|--------|-----------------------------|--------------------------|
| GET    | `/fault-ticket/tickets`      | Fetch all tickets        |
| POST   | `/fault-ticket/tickets`      | Create a new ticket      |
| DELETE | `/fault-ticket/tickets/{id}` | Delete a ticket          |
| PUT    | `/fault-ticket/tickets/{id}` | Update a ticket *(Backend only)* |

---

## 🚧 Roadmap

- [ ] Frontend UI for update ticket feature  
- [ ] Role-based authentication with JWT  
- [ ] Advanced ticket filtering and reporting  
- [ ] Dockerized deployment (Backend + Frontend)  
- [ ] CI/CD pipeline with GitHub Actions  

---

## 🤝 Contributing

Contributions are welcome!  
1. Fork the project  
2. Create a feature branch (`git checkout -b feature/new-feature`)  
3. Commit your changes (`git commit -m "Added new feature"`)  
4. Push to branch (`git push origin feature/new-feature`)  
5. Open a Pull Request  

---

## 📜 License

This project is licensed under the **MIT License** – you are free to use and modify it.

---

✅ **Tip:**  
- To add your **UI screenshot**, take a screenshot of your running frontend (`http://localhost:4200/view-tickets`), save it as `screenshot.png` in your repo root, and update this line in README:
```markdown
![Project Screenshot](screenshot.png)
```
