package com.duoc.LearningPlatformValidation.mapper;
import com.duoc.LearningPlatformValidation.dto.inscripcion.*;
import com.duoc.LearningPlatformValidation.model.InscripcionEntity;
import org.springframework.stereotype.Component;

@Component
public class InscripcionMapper {
    public InscripcionEntity toEntity(InscripcionRequest dto) {
        return InscripcionEntity.builder().cursoId(dto.getCursoId()).estudianteId(dto.getEstudianteId()).fechaInscripcion(dto.getFechaInscripcion()).build();
    }
    public InscripcionResponse toResponse(InscripcionEntity entity) {
        return InscripcionResponse.builder().id(entity.getId()).cursoId(entity.getCursoId()).estudianteId(entity.getEstudianteId()).fechaInscripcion(entity.getFechaInscripcion()).build();
    }
}