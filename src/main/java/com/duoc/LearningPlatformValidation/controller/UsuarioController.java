package com.duoc.LearningPlatformValidation.controller;
import com.duoc.LearningPlatformValidation.dto.usuario.*;
import com.duoc.LearningPlatformValidation.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired private UsuarioService service;

    @GetMapping public ResponseEntity<List<UsuarioResponse>> getAll() { return ResponseEntity.ok(service.obtenerTodos()); }
    @GetMapping("/{id}") public ResponseEntity<UsuarioResponse> getById(@PathVariable Long id) {
        return service.obtenerPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public ResponseEntity<UsuarioResponse> create(@RequestBody UsuarioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(request));
    }
    @PutMapping("/{id}") public ResponseEntity<UsuarioResponse> update(@PathVariable Long id, @RequestBody UsuarioRequest request) {
        return service.actualizar(id, request).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}