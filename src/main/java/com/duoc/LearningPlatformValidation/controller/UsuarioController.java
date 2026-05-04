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
        // GET: Obtener un usuario por ID, devuelve 200 OK con el usuario
        return ResponseEntity.ok(service.obtenerPorId(id));
    }
    @PostMapping public ResponseEntity<UsuarioResponse> create(@RequestBody UsuarioRequest request) {
        // POST: Crear un nuevo usuario, devuelve 201 Created con el usuario creado
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(request));
    }
    @PutMapping("/{id}") public ResponseEntity<UsuarioResponse> update(@PathVariable Long id, @RequestBody UsuarioRequest request) {
        // PUT: Actualizar un usuario por ID, devuelve 200 OK con el usuario actualizado
        return ResponseEntity.ok(service.actualizar(id, request));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        // DELETE: Eliminar un usuario por ID, devuelve 204 No Content si se elimino
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}