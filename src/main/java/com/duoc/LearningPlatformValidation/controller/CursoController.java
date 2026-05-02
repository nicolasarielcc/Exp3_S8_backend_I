package com.duoc.LearningPlatformValidation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.LearningPlatformValidation.model.CursoEntity;
import com.duoc.LearningPlatformValidation.service.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired private CursoService service;
    @GetMapping public List<CursoEntity> getAll() { return service.obtenerTodos(); }
    @GetMapping("/{id}") public ResponseEntity<CursoEntity> getById(@PathVariable Long id) {
        return service.obtenerPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public ResponseEntity<CursoEntity> create(@RequestBody CursoEntity c) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(c));
    }
    @PutMapping("/{id}") public ResponseEntity<CursoEntity> update(@PathVariable Long id, @RequestBody CursoEntity c) {
        return service.actualizar(id, c).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}