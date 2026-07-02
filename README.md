# Dart-App (Defense Asset Resource Tracker)

Dart-App is a full-stack management system designed to track defense-related assets and their operational capabilities. It provides a structured way to manage the lifecycle, status, and tactical utility of high-value defense hardware.

## 🚀 Features
- **Asset Management:** Create, track, and monitor assets (e.g., AIRCRAFT, SATELLITE, ROVER).
- **Capability Mapping:** Assign and query capabilities (e.g., STEALTH_OPERATIONS, CYBER_DEFENSE) to specific assets.
- **Data Integrity:** Enforced unique naming constraints and relationship mapping between assets and their capabilities.

## 🛠 Tech Stack
- **Backend:** Java, Spring Boot
- **Database:** PostgreSQL
- **ORM:** Hibernate/JPA
- **Testing:** JUnit 5, Spring Boot Test, MockMvc
- **API:** RESTful endpoints

## 📋 Prerequisites
Before you begin, ensure you have the following installed:
- [Java Development Kit (JDK) 17 or higher](https://adoptium.net/)
- [PostgreSQL](https://www.postgresql.org/)
- [Maven](https://maven.apache.org/)

## ⚙️ Configuration
To connect the application to your database, update your `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
