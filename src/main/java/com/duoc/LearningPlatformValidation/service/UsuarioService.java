package com.duoc.LearningPlatformValidation.service;
import com.duoc.LearningPlatformValidation.dto.usuario.*;
import com.duoc.LearningPlatformValidation.exception.ResourceNotFoundException;
import com.duoc.LearningPlatformValidation.mapper.UsuarioMapper;
import com.duoc.LearningPlatformValidation.model.UsuarioEntity;
import com.duoc.LearningPlatformValidation.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired private UsuarioRepository repository;
    @Autowired private UsuarioMapper mapper;

    public List<UsuarioResponse> obtenerTodos() {
        // GET: Obtener todos los usuarios y mapear a respuestas
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    // GET: Obtener un usuario por ID, devuelve Optional.empty() si no existe
    public UsuarioResponse obtenerPorId(Long id) {
        UsuarioEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + id));
        return mapper.toResponse(entity);
    }

    // POST: Crear un nuevo usuario, devuelve el usuario creado con ID
    public UsuarioResponse crear(UsuarioRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    // PUT: Actualizar un usuario por ID, devuelve Optional.empty() si no existe
    public UsuarioResponse actualizar(Long id, UsuarioRequest request) {
        UsuarioEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + id));
        entity.setNombre(request.getNombre());
        entity.setCorreo(request.getCorreo());
        if (request.getContrasena() != null && !request.getContrasena().isEmpty()) {
            entity.setContrasena(request.getContrasena());
        }
        entity.setRol(request.getRol());
        return mapper.toResponse(repository.save(entity));
    }
    // DELETE: Eliminar un usuario por ID, devuelve true si se eliminó, false si no existe
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado: " + id);
        }
        repository.deleteById(id);
    }
}