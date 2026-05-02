package com.duoc.LearningPlatformValidation.service;
import com.duoc.LearningPlatformValidation.dto.inscripcion.*;
import com.duoc.LearningPlatformValidation.mapper.InscripcionMapper;
import com.duoc.LearningPlatformValidation.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscripcionService {
    @Autowired private InscripcionRepository repository;
    @Autowired private InscripcionMapper mapper;

    public List<InscripcionResponse> listarPorCurso(Long cursoId) {
        return repository.findByCursoId(cursoId).stream().map(mapper::toResponse).collect(Collectors.toList());
    }
    public InscripcionResponse registrar(InscripcionRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }
    public boolean eliminar(Long id) {
        if (repository.existsById(id)) { repository.deleteById(id); return true; }
        return false;
    }
}