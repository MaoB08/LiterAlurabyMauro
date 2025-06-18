# LiterAlurabyMauro

# literAlura 📚

Proyecto desarrollado como práctica para aprender el uso de **Spring Boot**, el consumo de **APIs externas** y el manejo de datos con **JPQL** y **Spring Data JPA**.

## 🎯 Objetivo

- Aprender a consumir APIs externas desde una aplicación Spring Boot.
- Implementar una arquitectura MVC sencilla.
- Practicar consultas personalizadas utilizando JPQL.
- Guardar y consultar datos usando JPA y Spring Data.

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- PostgreSQL
- Maven
- API externa (Gutendex)

## 🛠️ Estructura del proyecto

```
literAlura/
├── src/
│   ├── main/
│   │   ├── java/com/alura/literAlura/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── LiterAluraApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
├── pom.xml
└── README.md
```

## ⚙️ Configuración

1. Clona el repositorio:
   ```bash
   git clone https://github.com/MaoB08/LiterAlurabyMauro.git
   ```
2. Entra al directorio del proyecto:
   ```bash
   cd literAlura
   ```
3. Compila y ejecuta el proyecto con Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Cuando lo ejecutes ten en cuenta tener tu usuario y contrasena de PostgreSQL como variables locales

## 📦 API Externa

Este proyecto consume datos de una API de libros (como Gutendex) para registrar información relevante como título, autor, idioma, etc.

## 🧠 Funcionalidades destacadas

- Buscar libros por título.
- Guardar libros favoritos en la base de datos.
- Consultar por autor o genero usando JPQL.
- Uso de `RestTemplate` o `WebClient` para llamadas externas.
- Validaciones básicas.

## 👨‍💻 Autor

Mauricio Becerra – [GitHub](https://github.com/MaoB08)

---
