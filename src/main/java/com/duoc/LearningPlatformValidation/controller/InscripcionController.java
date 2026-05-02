package com.duoc.LearningPlatformValidation.controller;
import com.duoc.LearningPlatformValidation.dto.inscripcion.*;
import com.duoc.LearningPlatformValidation.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {
    @Autowired private InscripcionService service;

    @GetMapping("/curso/{cursoId}") public ResponseEntity<List<InscripcionResponse>> getByCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(service.listarPorCurso(cursoId));
    }
    @PostMapping public ResponseEntity<InscripcionResponse> create(@RequestBody InscripcionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(request));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}