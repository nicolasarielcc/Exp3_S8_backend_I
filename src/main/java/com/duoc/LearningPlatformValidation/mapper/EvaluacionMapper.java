package com.duoc.LearningPlatformValidation.mapper;
import com.duoc.LearningPlatformValidation.dto.evaluacion.*;
import com.duoc.LearningPlatformValidation.model.EvaluacionEntity;
import org.springframework.stereotype.Component;

@Component
public class EvaluacionMapper {
    public EvaluacionEntity toEntity(EvaluacionRequest dto) {
        return EvaluacionEntity.builder().cursoId(dto.getCursoId()).nombre(dto.getNombre()).puntajeMaximo(dto.getPuntajeMaximo()).fechaAplicacion(dto.getFechaAplicacion()).build();
    }
    public EvaluacionResponse toResponse(EvaluacionEntity entity) {
        return EvaluacionResponse.builder().id(entity.getId()).cursoId(entity.getCursoId()).nombre(entity.getNombre()).puntajeMaximo(entity.getPuntajeMaximo()).fechaAplicacion(entity.getFechaAplicacion()).build();
    }
}