package com.duoc.LearningPlatformValidation.controller;
import com.duoc.LearningPlatformValidation.dto.curso.*;
import com.duoc.LearningPlatformValidation.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired private CursoService service;

    @GetMapping public ResponseEntity<List<CursoResponse>> getAll() { return ResponseEntity.ok(service.obtenerTodos()); }
    @GetMapping("/{id}") public ResponseEntity<CursoResponse> getById(@PathVariable Long id) {
        // GET: Obtener un curso por ID, devuelve 200 OK con el curso
        return ResponseEntity.ok(service.obtenerPorId(id));
    }
    // POST: Crear un nuevo curso, devuelve 201 Created con el curso creado
    @PostMapping public ResponseEntity<CursoResponse> create(@RequestBody CursoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(request));
    }
    // PUT: Actualizar un curso por ID, devuelve 200 OK con el curso actualizado o 404 Not Found si no existe
    @PutMapping("/{id}") public ResponseEntity<CursoResponse> update(@PathVariable Long id, @RequestBody CursoRequest request) {
        return ResponseEntity.ok(service.actualizar(id, request));
    }
    // DELETE: Eliminar un curso por ID, devuelve 204 No Content si se eliminó o 404 Not Found si no existe
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}