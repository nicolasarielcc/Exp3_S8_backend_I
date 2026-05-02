package com.duoc.LearningPlatformValidation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.LearningPlatformValidation.model.InscripcionEntity;
import com.duoc.LearningPlatformValidation.service.InscripcionService;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {
    @Autowired private InscripcionService service;
    @GetMapping("/curso/{cursoId}") public List<InscripcionEntity> getByCurso(@PathVariable Long cursoId) {
        return service.listarPorCurso(cursoId);
    }
    @PostMapping public ResponseEntity<InscripcionEntity> create(@RequestBody InscripcionEntity i) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(i));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}