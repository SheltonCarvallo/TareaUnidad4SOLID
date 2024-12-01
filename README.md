# Sistema de Gestión de Medios (Documentales, Películas y Series de TV)

---

## Descripción del Proyecto

Este proyecto es un sistema de gestión de medios que permite realizar operaciones sobre **documentales**, **películas** y **series de TV**. El objetivo es simular la administración de estos medios, brindando al usuario la capacidad de añadir, listar, modificar y eliminar cada tipo de medio. Este proyecto fue desarrollado en **Java**, aplicando principios de **arquitectura limpia** y **principios SOLID**, y está diseñado para ser fácilmente extensible.

---

## Características Principales

- **Gestión de Documentales**:  
   El usuario puede agregar, listar, modificar y eliminar documentales. Cada documental contiene información como título, año y director.

- **Gestión de Películas y Series de TV**:  
   De manera similar a los documentales, el sistema permite realizar las mismas operaciones sobre películas y series de TV. Cada medio tiene su propia representación a través de clases específicas.

- **Simulación de Persistencia**:  
   El sistema actualmente simula la persistencia de datos utilizando listas en memoria. Sin embargo, la arquitectura permite fácilmente sustituir esta capa por una base de datos real en el futuro.

---

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

1. **Modelo**:  
   Define las clases `DocumentalModel`, `PeliculaModel` y `SerieTvModel`, que representan los medios (documentales, películas y series de TV) con atributos relevantes como título, año, director, etc.

2. **Controlador**:  
   El controlador gestiona la lógica de negocio para cada tipo de medio. Las clases `DocumentalController`, `PeliculaController` y `SerieTvController` contienen métodos para agregar, listar, modificar y eliminar cada uno de estos medios.

3. **Persistencia de Datos**:  
   Se define una interfaz `IPersistenciaDatos`, que es implementada por la clase `PersistenciaSimulada` para manejar la simulación de almacenamiento de los datos en listas de memoria.

---

## Principios SOLID Aplicados

El proyecto sigue los principios SOLID para asegurar que sea escalable, flexible y mantenible:

- **Single Responsibility Principle (SRP)**:  
   Cada clase tiene una única responsabilidad. Por ejemplo, `DocumentalModel` representa un documental, y `DocumentalController` gestiona las operaciones relacionadas con los documentales.
   
- **Open/Closed Principle (OCP)**:  
   Las clases están diseñadas para ser abiertas a la extensión pero cerradas a la modificación. Por ejemplo, podemos agregar nuevos tipos de medios (como libros o videojuegos) sin modificar las clases existentes.
   
- **Liskov Substitution Principle (LSP)**:  
   Las clases derivadas (`DocumentalModel`, `PeliculaModel`, `SerieTvModel`) pueden ser usadas en lugar de sus clases base, sin alterar el comportamiento del programa.

- **Interface Segregation Principle (ISP)**:  
   La interfaz `IPersistenciaDatos` está diseñada para definir únicamente las operaciones necesarias para la persistencia de datos, lo que facilita la implementación de diferentes formas de persistencia.

- **Dependency Inversion Principle (DIP)**:  
   Las clases controladoras dependen de abstracciones (interfaces) en lugar de implementaciones concretas, lo que facilita el cambio de la implementación de la persistencia en el futuro.

---

## Instalación

Para ejecutar este proyecto en tu entorno local, sigue los siguientes pasos:

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu_usuario/nombre_del_repositorio.git

