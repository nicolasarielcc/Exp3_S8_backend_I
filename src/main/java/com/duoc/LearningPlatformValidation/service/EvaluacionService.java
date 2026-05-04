package com.duoc.LearningPlatformValidation.service;
import com.duoc.LearningPlatformValidation.dto.evaluacion.*;
import com.duoc.LearningPlatformValidation.exception.ResourceNotFoundException;
import com.duoc.LearningPlatformValidation.mapper.EvaluacionMapper;
import com.duoc.LearningPlatformValidation.model.EvaluacionEntity;
import com.duoc.LearningPlatformValidation.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluacionService {
    @Autowired private EvaluacionRepository repository;
    @Autowired private EvaluacionMapper mapper;

    public List<EvaluacionResponse> obtenerTodas() {
        // GET: Obtener todas las evaluaciones y mapear a respuestas
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }
    // GET: Obtener una evaluación por ID, devuelve Optional.empty() si no existe
    public List<EvaluacionResponse> listarPorCurso(Long cursoId) {
        return repository.findByCursoId(cursoId).stream().map(mapper::toResponse).collect(Collectors.toList());
    }
    // POST: Crear una nueva evaluación, devuelve la evaluación creada con ID
    public EvaluacionResponse registrar(EvaluacionRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }
    // PUT: Actualizar una evaluación por ID, devuelve Optional.empty() si no existe
    public EvaluacionResponse actualizar(Long id, EvaluacionRequest request) {
        EvaluacionEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evaluacion no encontrada: " + id));
        entity.setNombre(request.getNombre());
        entity.setPuntajeMaximo(request.getPuntajeMaximo());
        entity.setFechaAplicacion(request.getFechaAplicacion());
        return mapper.toResponse(repository.save(entity));
    }
}