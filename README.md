# Foro Hub

Foro Hub es una API REST desarrollada en **Spring Boot** que permite gestionar foros de discusión. Los usuarios pueden crear, leer, actualizar y eliminar tópicos dentro del foro.

## 🚀 Características

- 📌 CRUD de Tópicos (Crear, Leer, Actualizar, Eliminar)
- 🛡️ Validaciones según reglas de negocio
- 🗄️ Persistencia de datos con **Spring Data JPA** y **MySQL**
- 🔐 Autenticación y encriptación de contraseñas con **BCrypt**
- 📄 Documentación con **Swagger/OpenAPI**
- 📦 Manejo de dependencias con **Maven**

---

## 🛠️ Tecnologías utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- Lombok
- Maven

---

## 📂 Estructura del proyecto

```
Foro_Hub/
├── src/
│   ├── main/
│   │   ├── java/com/foro_hub/
│   │   │   ├── config/         # Configuraciones del proyecto
│   │   │   ├── domain/         # Entidades y lógica de negocio
│   │   │   ├── controller/     # Controladores REST
│   │   │   ├── infra/          # Documentacion y seguridad del proyecto
│   │   ├── resources/
│   │   │   ├── application.properties # Configuración de la BD y Spring Boot
│   │   │   ├── db.migrations          # Creacion de la BD
├── pom.xml  # Gestión de dependencias con Maven
```

---

## 📌 Instalación y configuración

### 1️⃣ Clonar el repositorio
```bash
git clone https://github.com/jose2806/ForoHub.git
cd ForoHub
```

### 2️⃣ Configurar la base de datos

En el archivo `src/main/resources/application.properties`, configura la conexión a MySQL:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

La API estará disponible en `http://localhost:8080`

---

## 📖 Endpoints principales

### 🔹 Crear un nuevo tópico
```http
POST /topicos
```
**Body JSON:**
```json
{
  "titulo": "Mi primer tópico",
  "mensaje": "¿Cómo funciona Spring Boot?",
  "autor": 1,
  "curso": 2
}
```

### 🔹 Obtener todos los tópicos
```http
GET /topicos
```

### 🔹 Obtener un tópico por ID
```http
GET /topicos/{id}
```

### 🔹 Actualizar un tópico
```http
PUT /topicos/{id}
```

### 🔹 Eliminar un tópico
```http
DELETE /topicos/{id}
```

---

## 🛡️ Seguridad

Las contraseñas de los usuarios se almacenan de forma segura utilizando **BCrypt**.

## 📌 Autor

👤 **Jose Rodriguez Cruz**  
💻 [GitHub](https://github.com/jose2806)  
---

¡Contribuciones y sugerencias son bienvenidas! 🚀

