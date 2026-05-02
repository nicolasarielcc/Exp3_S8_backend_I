package com.duoc.LearningPlatformValidation.controller;
import com.duoc.LearningPlatformValidation.dto.evaluacion.*;
import com.duoc.LearningPlatformValidation.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {
    @Autowired private EvaluacionService service;

    @GetMapping public ResponseEntity<List<EvaluacionResponse>> getAll() { return ResponseEntity.ok(service.obtenerTodas()); }
    // GET: Obtener una evaluación por ID, devuelve 200 OK con el curso o 404 Not Found si no existe
    @GetMapping("/curso/{cursoId}") public ResponseEntity<List<EvaluacionResponse>> getByCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(service.listarPorCurso(cursoId));
    }
    // POST: Crear una nueva evaluación, devuelve 201 Created con la evaluación creada
    @PostMapping public ResponseEntity<EvaluacionResponse> create(@RequestBody EvaluacionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(request));
    }
    // PUT: Actualizar una evaluación por ID, devuelve 200 OK con la evaluación actualizada o 404 Not Found si no existe
    @PutMapping("/{id}") public ResponseEntity<EvaluacionResponse> update(@PathVariable Long id, @RequestBody EvaluacionRequest request) {
        return service.actualizar(id, request).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}