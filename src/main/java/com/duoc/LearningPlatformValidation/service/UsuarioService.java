package com.duoc.LearningPlatformValidation.service;
import com.duoc.LearningPlatformValidation.dto.usuario.*;
import com.duoc.LearningPlatformValidation.mapper.UsuarioMapper;
import com.duoc.LearningPlatformValidation.model.UsuarioEntity;
import com.duoc.LearningPlatformValidation.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired private UsuarioRepository repository;
    @Autowired private UsuarioMapper mapper;

    public List<UsuarioResponse> obtenerTodos() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }
    public Optional<UsuarioResponse> obtenerPorId(Long id) {
        return repository.findById(id).map(mapper::toResponse);
    }
    public UsuarioResponse crear(UsuarioRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }
    public Optional<UsuarioResponse> actualizar(Long id, UsuarioRequest request) {
        return repository.findById(id).map(u -> {
            u.setNombre(request.getNombre());
            u.setCorreo(request.getCorreo());
            if(request.getContrasena() != null && !request.getContrasena().isEmpty()) { u.setContrasena(request.getContrasena()); }
            u.setRol(request.getRol());
            return mapper.toResponse(repository.save(u));
        });
    }
    public boolean eliminar(Long id) {
        if (repository.existsById(id)) { repository.deleteById(id); return true; }
        return false;
    }
}