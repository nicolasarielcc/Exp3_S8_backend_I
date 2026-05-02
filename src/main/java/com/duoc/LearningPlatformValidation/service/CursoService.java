package com.duoc.LearningPlatformValidation.service;
import com.duoc.LearningPlatformValidation.dto.curso.*;
import com.duoc.LearningPlatformValidation.mapper.CursoMapper;
import com.duoc.LearningPlatformValidation.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
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
    public Optional<CursoResponse> obtenerPorId(Long id) {
        return repository.findById(id).map(mapper::toResponse);
    }
    // POST: Crear un nuevo curso, devuelve el curso creado con ID
    public CursoResponse crear(CursoRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }
    // PUT: Actualizar un curso por ID, devuelve Optional.empty() si no existe
    public Optional<CursoResponse> actualizar(Long id, CursoRequest request) {
        return repository.findById(id).map(c -> {
            c.setNombre(request.getNombre());
            c.setDescripcion(request.getDescripcion());
            c.setProfesorId(request.getProfesorId());
            return mapper.toResponse(repository.save(c));
        });
    }
    // DELETE: Eliminar un curso por ID, devuelve true si se eliminó, false si no existe
    public boolean eliminar(Long id) {
        if (repository.existsById(id)) { repository.deleteById(id); return true; }
        return false;
    }
}