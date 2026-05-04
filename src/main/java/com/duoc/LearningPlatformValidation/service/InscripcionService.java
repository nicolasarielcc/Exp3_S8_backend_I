package com.duoc.LearningPlatformValidation.service;
import com.duoc.LearningPlatformValidation.dto.inscripcion.*;
import com.duoc.LearningPlatformValidation.exception.ResourceNotFoundException;
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
        // GET: Obtener todas las inscripciones de un curso y mapear a respuestas
        return repository.findByCursoId(cursoId).stream().map(mapper::toResponse).collect(Collectors.toList());
    }
    // POST: Crear una nueva inscripción, devuelve la inscripción creada con ID
    public InscripcionResponse registrar(InscripcionRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }
    // DELETE: Eliminar una inscripción por ID, devuelve true si se eliminó, false si no existe
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Inscripcion no encontrada: " + id);
        }
        repository.deleteById(id);
    }
}