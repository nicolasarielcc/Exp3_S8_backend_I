package com.duoc.LearningPlatformValidation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.LearningPlatformValidation.model.EvaluacionEntity;
import com.duoc.LearningPlatformValidation.service.EvaluacionService;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {
    @Autowired private EvaluacionService service;
    @GetMapping public List<EvaluacionEntity> getAll() { return service.obtenerTodas(); }
    @GetMapping("/curso/{cursoId}") public List<EvaluacionEntity> getByCurso(@PathVariable Long cursoId) {
        return service.listarPorCurso(cursoId);
    }
    @PostMapping public ResponseEntity<EvaluacionEntity> create(@RequestBody EvaluacionEntity e) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(e));
    }
    @PutMapping("/{id}") public ResponseEntity<EvaluacionEntity> update(@PathVariable Long id, @RequestBody EvaluacionEntity e) {
        return service.actualizar(id, e).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}