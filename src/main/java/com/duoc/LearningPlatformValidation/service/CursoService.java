package com.duoc.LearningPlatformValidation.service;
import com.duoc.LearningPlatformValidation.dto.curso.*;
import com.duoc.LearningPlatformValidation.exception.ResourceNotFoundException;
import com.duoc.LearningPlatformValidation.mapper.CursoMapper;
import com.duoc.LearningPlatformValidation.model.CursoEntity;
import com.duoc.LearningPlatformValidation.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {
    @Autowired private CursoRepository repository;
    @Autowired private CursoMapper mapper;

    public List<CursoResponse> obtenerTodos() {
        // GET: Obtener todos los cursos y mapear a respuestas
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }
    // GET: Obtener un curso por ID, devuelve Optional.empty() si no existe
    public CursoResponse obtenerPorId(Long id) {
        CursoEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado: " + id));
        return mapper.toResponse(entity);
    }
    // POST: Crear un nuevo curso, devuelve el curso creado con ID
    public CursoResponse crear(CursoRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }
    // PUT: Actualizar un curso por ID, devuelve Optional.empty() si no existe
    public CursoResponse actualizar(Long id, CursoRequest request) {
        CursoEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado: " + id));
        entity.setNombre(request.getNombre());
        entity.setDescripcion(request.getDescripcion());
        entity.setProfesorId(request.getProfesorId());
        return mapper.toResponse(repository.save(entity));
    }
    // DELETE: Eliminar un curso por ID, devuelve true si se eliminó, false si no existe
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Curso no encontrado: " + id);
        }
        repository.deleteById(id);
    }
}