package com.duoc.LearningPlatformValidation.service;

import com.duoc.LearningPlatformValidation.model.UsuarioEntity;
import com.duoc.LearningPlatformValidation.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // GET: Consultar todos los usuarios
    public List<UsuarioEntity> obtenerTodos() {
        return repository.findAll();
    }

    // GET: Buscar usuario por ID
    public Optional<UsuarioEntity> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    // POST: Registrar usuario
    public UsuarioEntity crear(UsuarioEntity usuario) {
        return repository.save(usuario);
    }

    // PUT: Actualizar usuario
    public Optional<UsuarioEntity> actualizar(Long id, UsuarioEntity detallesActualizados) {
        return repository.findById(id).map(usuarioExistente -> {
            usuarioExistente.setNombre(detallesActualizados.getNombre());
            usuarioExistente.setCorreo(detallesActualizados.getCorreo());
            usuarioExistente.setContrasena(detallesActualizados.getContrasena());
            usuarioExistente.setRol(detallesActualizados.getRol());
            return repository.save(usuarioExistente);
        });
    }

    // DELETE: Eliminar usuario
    public boolean eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}