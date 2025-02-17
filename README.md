# 🚀 **Spring Boot ControllerAdvice - Esqueleto para Entrevistas**

📌 **Repositorio diseñado para entrevistas técnicas y proyectos rápidos.**  
✅ **Incluye un CRUD con manejo de errores centralizado con `@ControllerAdvice`.**  
✅ **Código bien documentado, preparado para ampliaciones.**

---

## 📌 **Tecnologías Utilizadas**

- ☕ **Java 17**
- 🌱 **Spring Boot 3.4.0**
- 🏗️ **Spring Web** (API REST)
- 💾 **Spring Data JPA** (Persistencia de datos)
- 🛢️ **H2 Database** (Base de datos en memoria)
- 🛠️ **Lombok** (Reducción de boilerplate code)
- 📦 **Maven** (Gestión de dependencias)

---

## ⚡ **Inicialización del Proyecto**

### 🏗️ **1️⃣ Clonar el Repositorio**

```sh
    git clone https://github.com/tu-usuario/controlleradvice-spring.git
    cd controlleradvice-spring
```
---

## 🚀 2️⃣ Construir y Ejecutar con Maven
```sh
    mvn clean install
    mvn spring-boot:run
```
⚠️ Asegúrate de tener Maven y Java 17 instalados.
---

## 📂 3️⃣ Base de Datos en Memoria (H2 Console)

Accede a H2 Database desde:
🔗 http://localhost:8080/h2-console
Usa la siguiente configuración:

    JDBC URL: jdbc:h2:mem:testdb
    Usuario: sa
    Contraseña: (vacío)
---

## 🔥 Ejemplo de Peticiones (cURL)
➕ Crear un Item
````sh
    curl -X POST http://localhost:8080/items \
    -H "Content-Type: application/json" \
    -d '{"name": "Item 1", "description": "Descripción del item"}'
````
📖 Obtener un Item por ID
````sh
  curl -X GET http://localhost:8080/items/1
````
✏️ Actualizar un Item
````sh
    curl -X PUT http://localhost:8080/items/1 \
         -H "Content-Type: application/json" \
         -d '{"name": "Nuevo Nombre", "description": "Nueva descripción"}'
````
❌ Eliminar un Item
````sh
  curl -X DELETE http://localhost:8080/items/1
````
---

## 🎯 Gestión de Errores con @ControllerAdvice

Este proyecto centraliza el manejo de errores con @ControllerAdvice, lo que:

✅ Evita duplicar código en los controladores.
✅ Facilita la gestión de errores en un solo lugar.
✅ Retorna respuestas estructuradas y claras.

Ejemplo de error al enviar un id inválido en una operación UPDATE o DELETE:

````json
    {
        "timestamp": "2025-02-17T11:22:35.3327121",
        "status": 500,
        "error": "Internal Server Error",
        "path": "/items/1"
    }
````

💡 Enfoque de ControllerAdvice

El @ControllerAdvice se utiliza para interceptar y gestionar excepciones lanzadas en los controladores.
En este proyecto, se ha usado para manejar errores comunes como:

   - No encontrado (404): Si no se encuentra el Item solicitado.
   - Errores internos del servidor (500): Para errores inesperados.
---

## 📝 Entrevista Técnica: Preguntas y Respuestas sobre @ControllerAdvice
1. ¿Qué es @ControllerAdvice y para qué se utiliza?

    @ControllerAdvice es una especialización de @Component que permite manejar excepciones a nivel global, aplicar lógica de validación a los controladores y agregar configuraciones comunes. Funciona de manera global para todos los controladores que se encuentren dentro del contexto de la aplicación.
2. ¿Cómo se gestionan los errores con @ControllerAdvice?

    Se puede definir un único punto de control para manejar excepciones, lo que mejora la consistencia de las respuestas de error. Esto permite que errores como 404 o 500 sean gestionados de manera uniforme y personalizada para todos los controladores.
3. ¿Cuál es la ventaja de utilizar @ControllerAdvice?

   - Centralización de errores: Centraliza el manejo de errores en una sola clase, evitando la repetición de código en cada controlador.
   - Facilidad de mantenimiento: Permite que los cambios en la gestión de errores se realicen en un solo lugar.
   - Manejo consistente de errores: Se puede ofrecer una respuesta estandarizada y personalizada para los errores.

4. ¿Qué desventajas puede tener el uso de @ControllerAdvice?

   - Exceso de abstracción: En proyectos pequeños, podría ser innecesario y agregar complejidad.
   - Control limitado: Si no se configura adecuadamente, puede interferir con el comportamiento específico de algunos controladores.

5. ¿Por qué es bueno utilizar @ControllerAdvice?

   - Reducción de código repetido: Evita tener que gestionar errores en cada controlador individualmente.
   - Control centralizado: Toda la lógica de manejo de excepciones está en un solo lugar, facilitando la modificación y el monitoreo.
   - Mejor experiencia para el usuario final: Proporciona respuestas de error claras y estructuradas.

6. ¿Cuándo no es recomendable usar @ControllerAdvice?

    En aplicaciones muy simples o con pocos controladores, el uso de @ControllerAdvice podría ser innecesario. En casos donde se necesite un manejo de errores específico por controlador, utilizarlo podría ser excesivo.
---

## 📝 Conclusión

Este proyecto es un esqueleto básico para entrevistas técnicas, ofreciendo una implementación simple de Spring Boot con gestión centralizada de errores mediante @ControllerAdvice. Está diseñado para ser fácilmente extendido o modificado según las necesidades de cada usuario.

Es un repositorio abierto para todos, ideal para aquellos que necesiten un ejemplo de implementación o deseen obtener una base para proyectos relacionados. ¡Si encuentras útil este código, no dudes en hacer un fork o contribución!