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
        return service.obtenerPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public ResponseEntity<CursoResponse> create(@RequestBody CursoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(request));
    }
    @PutMapping("/{id}") public ResponseEntity<CursoResponse> update(@PathVariable Long id, @RequestBody CursoRequest request) {
        return service.actualizar(id, request).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}