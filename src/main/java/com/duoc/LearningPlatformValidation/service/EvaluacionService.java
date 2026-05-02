package com.duoc.LearningPlatformValidation.service;
import com.duoc.LearningPlatformValidation.dto.evaluacion.*;
import com.duoc.LearningPlatformValidation.mapper.EvaluacionMapper;
import com.duoc.LearningPlatformValidation.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EvaluacionService {
    @Autowired private EvaluacionRepository repository;
    @Autowired private EvaluacionMapper mapper;

    public List<EvaluacionResponse> obtenerTodas() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }
    public List<EvaluacionResponse> listarPorCurso(Long cursoId) {
        return repository.findByCursoId(cursoId).stream().map(mapper::toResponse).collect(Collectors.toList());
    }
    public EvaluacionResponse registrar(EvaluacionRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }
    public Optional<EvaluacionResponse> actualizar(Long id, EvaluacionRequest request) {
        return repository.findById(id).map(e -> {
            e.setNombre(request.getNombre());
            e.setPuntajeMaximo(request.getPuntajeMaximo());
            e.setFechaAplicacion(request.getFechaAplicacion());
            return mapper.toResponse(repository.save(e));
        });
    }
}