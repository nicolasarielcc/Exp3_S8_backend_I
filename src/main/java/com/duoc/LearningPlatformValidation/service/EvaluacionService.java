package com.duoc.LearningPlatformValidation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.LearningPlatformValidation.model.EvaluacionEntity;
import com.duoc.LearningPlatformValidation.repository.EvaluacionRepository;

@Service
public class EvaluacionService {
    @Autowired private EvaluacionRepository repository;
    public List<EvaluacionEntity> obtenerTodas() { return repository.findAll(); }
    public List<EvaluacionEntity> listarPorCurso(Long cursoId) { return repository.findByCursoId(cursoId); }
    public EvaluacionEntity registrar(EvaluacionEntity e) { return repository.save(e); }
    public Optional<EvaluacionEntity> actualizar(Long id, EvaluacionEntity d) {
        return repository.findById(id).map(e -> {
            e.setNombre(d.getNombre());
            e.setPuntajeMaximo(d.getPuntajeMaximo());
            e.setFechaAplicacion(d.getFechaAplicacion());
            return repository.save(e);
        });
    }
}