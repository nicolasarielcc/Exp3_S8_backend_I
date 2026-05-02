package com.duoc.LearningPlatformValidation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.LearningPlatformValidation.model.CursoEntity;
import com.duoc.LearningPlatformValidation.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired private CursoRepository repository;
    public List<CursoEntity> obtenerTodos() { return repository.findAll(); }
    public Optional<CursoEntity> obtenerPorId(Long id) { return repository.findById(id); }
    public CursoEntity crear(CursoEntity curso) { return repository.save(curso); }
    public Optional<CursoEntity> actualizar(Long id, CursoEntity d) {
        return repository.findById(id).map(c -> {
            c.setNombre(d.getNombre());
            c.setDescripcion(d.getDescripcion());
            c.setProfesorId(d.getProfesorId());
            return repository.save(c);
        });
    }
    public boolean eliminar(Long id) {
        if (repository.existsById(id)) { repository.deleteById(id); return true; }
        return false;
    }
}