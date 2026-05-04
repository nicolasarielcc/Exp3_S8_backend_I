# LearningPlatformValidation

Plataforma de aprendizaje en linea construida con Spring Boot. Incluye CRUD de usuarios y cursos, inscripciones por curso y registro de evaluaciones.

## Requisitos

- Java 17 o superior
- Maven Wrapper (incluido en el repositorio)
- Base de datos configurada en `application.properties`

## Configuracion

1) Crea un archivo `.env` con las variables necesarias para la conexion a la base de datos.
2) Verifica los valores en `src/main/resources/application.properties`.

## Ejecucion

En Git Bash:

```
set -a; source .env; set +a && ./mvnw spring-boot:run
```

## Estructura del Proyecto

Este proyecto implementa una plataforma de aprendizaje en línea utilizando Spring Boot, siguiendo buenas prácticas de arquitectura y separación de responsabilidades. La estructura de carpetas está diseñada para facilitar el mantenimiento, la escalabilidad y la claridad del código.

### Jerarquía de Archivos

```
src/
  main/
    java/
      com/
        duoc/
          LearningPlatformValidation/
            controller/
              UsuarioController.java
              CursoController.java
              InscripcionController.java
              EvaluacionController.java
            service/
              UsuarioService.java
              CursoService.java
              InscripcionService.java
              EvaluacionService.java
            repository/
              UsuarioRepository.java
              CursoRepository.java
              InscripcionRepository.java
              EvaluacionRepository.java
            model/
              Usuario.java
              Curso.java
              Inscripcion.java
              Evaluacion.java
            dto/
              usuario/
                UsuarioRequest.java
                UsuarioResponse.java
              curso/
                CursoRequest.java
                CursoResponse.java
              inscripcion/
                InscripcionRequest.java
                InscripcionResponse.java
              evaluacion/
                EvaluacionRequest.java
                EvaluacionResponse.java
            mapper/
              UsuarioMapper.java
              CursoMapper.java
              InscripcionMapper.java
              EvaluacionMapper.java
            exception/
              ApiExceptionHandler.java
              ResourceNotFoundException.java
    resources/
      application.properties
  test/
    java/
      com/
        duoc/
          LearningPlatformValidation/
            // Pruebas unitarias e integración
```

---

## Modelos Principales

- **Usuario:** ID, Nombre, Correo, Contraseña, Rol (estudiante/profesor)
- **Curso:** ID, Nombre, Descripción, ProfesorID
- **Inscripcion:** ID, CursoID, EstudianteID, FechaInscripcion
- **Evaluacion:** ID, CursoID, Nombre, PuntajeMaximo, FechaAplicacion

Cada modelo tiene su respectivo repositorio JPA, servicio para la lógica de negocio, DTOs para entrada/salida de datos, mappers para conversión entre entidades y DTOs, y controladores REST.

---

## Endpoints y Funcionalidades

- **Usuario:**  
  - GET /api/usuarios  
  - GET /api/usuarios/{ID}  
  - POST /api/usuarios  
  - PUT /api/usuarios/{ID}  
  - DELETE /api/usuarios/{ID}
- **Curso:**  
  - GET /api/cursos  
  - GET /api/cursos/{ID}  
  - POST /api/cursos  
  - PUT /api/cursos/{ID}  
  - DELETE /api/cursos/{ID}
- **Inscripcion:**  
  - GET /api/inscripciones/curso/{cursoID}  
  - POST /api/inscripciones  
  - DELETE /api/inscripciones/{ID}
- **Evaluacion:**  
  - GET /api/evaluaciones  
  - GET /api/evaluaciones/curso/{cursoID}  
  - POST /api/evaluaciones  
  - PUT /api/evaluaciones/{ID}

---

## Validación y Pruebas

- La conexión a la base de datos está configurada en `application.properties` (ajustada para Oracle).
- Todos los servicios CRUD se validan mediante pruebas en Postman, documentando los resultados de cada endpoint.
- Se recomienda capturar y documentar cada prueba para la presentación final.

### Coleccion de Postman

Se incluye una coleccion con los endpoints solicitados en:

- [postman/LearningPlatformValidation.postman_collection.json](postman/LearningPlatformValidation.postman_collection.json)

Variables sugeridas dentro de la coleccion:

- `baseUrl`: `http://localhost:8080`
- `usuarioId`: ID de un usuario existente
- `cursoId`: ID de un curso existente

---

## Ajustes y Mejoras según Retroalimentación

- **Separación de paquetes:**  
  Se ajustó la estructura para separar claramente controller, service, model, repository, dto, mapper y exception, facilitando la navegación y el mantenimiento.
- **DTOs y Mappers:**  
  Se crearon DTOs para cada entidad y mappers para convertir entre entidades y DTOs, siguiendo buenas prácticas y evitando exponer entidades directamente.
- **Validación y manejo de errores:**  
  Se incorporó validación de entrada con anotaciones de Bean Validation y manejo global de excepciones con `@ControllerAdvice` para respuestas de error uniformes.
- **Uso de ResponseEntity:**  
  Los controladores devuelven `ResponseEntity` con códigos HTTP apropiados.
- **Logger:**  
  Se reemplazaron los `System.out.println` por un logger para mejor trazabilidad.
- **Restricción de consola H2:**  
  (Si aplica) La consola H2 está restringida a entornos de desarrollo mediante perfiles.
- **Evidencias:**  
  Se documentan capturas de la estructura del proyecto, configuración y pruebas de los endpoints.

---

## Presentación

La presentación en video (Kaltura) debe mostrar:
- Pruebas de todos los endpoints principales en Postman.
- Evidencia de la estructura del proyecto en la IDE.
- Explicación de la arquitectura y las mejoras implementadas según la retroalimentación recibida.

---

**Este proyecto está alineado con los objetivos del curso y las mejores prácticas de desarrollo de microservicios con Spring Boot.**
