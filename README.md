# 📦 Inventory Management System

## 📌 Estado del proyecto

**Estado:** ✅ Finalizado

---

## 📖 Descripción

Aplicación de consola desarrollada en Java para gestionar un inventario de productos.

Este proyecto forma parte de mi portfolio de Java Backend y representa una evolución respecto a mi proyecto anterior, incorporando una arquitectura organizada, validación de datos, operaciones CRUD completas y persistencia de datos mediante MySQL y JDBC.

---

## 🚀 Funcionalidades

- Agregar productos al inventario.
- Buscar productos por ID.
- Listar todos los productos registrados.
- Actualizar información de un producto.
- Eliminar productos.
- Actualizar nombre, precio, cantidad y categoría.
- Persistencia de datos en MySQL.
- Acceso a la base de datos mediante JDBC.

---

## 🛠️ Tecnologías utilizadas

- Java
- JDBC
- MySQL
- Maven
- IntelliJ IDEA
- Git
- GitHub

---

## 📚 Conceptos aplicados

Durante el desarrollo de este proyecto se aplicaron los siguientes conceptos:

- Programación Orientada a Objetos.
- Encapsulamiento.
- Constructores, métodos, getters y setters.
- CRUD (Create, Read, Update, Delete).
- Validación de datos.
- JDBC.
- Connection y DriverManager.
- PreparedStatement.
- ResultSet.
- executeQuery() y executeUpdate().
- Manejo de SQLException.
- try-with-resources.
- Parámetros mediante `?` en consultas SQL.
- Persistencia de datos con MySQL.
- Organización del proyecto por paquetes.

---

## 🗄️ Base de datos

El proyecto utiliza una base de datos MySQL llamada `inventory_db`.

Tabla principal:

```sql
CREATE TABLE productos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    precio DECIMAL(10,2),
    cantidad INT,
    categoria VARCHAR(100)
);

```

---

## 📂 Estructura del proyecto

```text
src
├── app
│   └── Main.java
├── database
│   └── Conexion.java
├── model
│   └── Producto.java
└── service
    └── GestorProductos.java
```

---

## ▶️ Cómo ejecutar

1.Clonar el repositorio:
git clone https://github.com/FerZuliani39/inventory-management-system.git

2.Abrir el proyecto en IntelliJ IDEA.

3.Tener MySQL instalado y crear la base de datos inventory_db.

4.Crear la tabla productos utilizando el script indicado en la sección Base de datos.

5.Configurar las credenciales de MySQL mediante variables de entorno.

6.Ejecutar:
src/app/Main.java

---

## 🎯 Objetivos de aprendizaje

Con este proyecto desarrollé conocimientos sobre:

*Diseño y organización de aplicaciones Java.
*Programación Orientada a Objetos.
*Implementación de operaciones CRUD.
*Persistencia de datos con MySQL.
*Integración de Java con bases de datos mediante JDBC.
*Uso de consultas parametrizadas.
*Manejo de resultados mediante ResultSet.
*Gestión de conexiones y recursos.
*Organización del código para facilitar su evolución.

---

## 🔮 Próximas mejoras

*Transacciones con JDBC.
*Connection Pool.
*API REST con Spring Boot.
*Migración de la persistencia hacia JPA / Hibernate.
*Pruebas unitarias con JUnit.

---
## 📈 Progreso del portfolio

Este proyecto forma parte de mi roadmap de aprendizaje en Java Backend.

✅ Proyecto 1: Academic Management System
✅ Proyecto 2: Inventory Management System
🔄 Próximo proyecto: Spring Boot REST API

## 👨‍💻 Autor

**Fernando Zuliani**

- GitHub: https://github.com/FerZuliani39
- LinkedIn: https://linkedin.com/in/fernando-zuliani39
