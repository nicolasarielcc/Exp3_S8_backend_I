package com.duoc.LearningPlatformValidation.mapper;
import com.duoc.LearningPlatformValidation.dto.curso.*;
import com.duoc.LearningPlatformValidation.model.CursoEntity;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {
    public CursoEntity toEntity(CursoRequest dto) {
        return CursoEntity.builder().nombre(dto.getNombre()).descripcion(dto.getDescripcion()).profesorId(dto.getProfesorId()).build();
    }
    public CursoResponse toResponse(CursoEntity entity) {
        return CursoResponse.builder().id(entity.getId()).nombre(entity.getNombre()).descripcion(entity.getDescripcion()).profesorId(entity.getProfesorId()).build();
    }
}