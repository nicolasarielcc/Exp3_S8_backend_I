package com.duoc.LearningPlatformValidation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.LearningPlatformValidation.model.InscripcionEntity;
import com.duoc.LearningPlatformValidation.repository.InscripcionRepository;

@Service
public class InscripcionService {
    @Autowired private InscripcionRepository repository;
    public List<InscripcionEntity> listarPorCurso(Long cursoId) { return repository.findByCursoId(cursoId); }
    public InscripcionEntity registrar(InscripcionEntity i) { return repository.save(i); }
    public boolean eliminar(Long id) {
        if (repository.existsById(id)) { repository.deleteById(id); return true; }
        return false;
    }
}