package com.duoc.LearningPlatformValidation.mapper;
import com.duoc.LearningPlatformValidation.dto.usuario.*;
import com.duoc.LearningPlatformValidation.model.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioEntity toEntity(UsuarioRequest dto) {
        return UsuarioEntity.builder().nombre(dto.getNombre()).correo(dto.getCorreo()).contrasena(dto.getContrasena()).rol(dto.getRol()).build();
    }
    public UsuarioResponse toResponse(UsuarioEntity entity) {
        return UsuarioResponse.builder().id(entity.getId()).nombre(entity.getNombre()).correo(entity.getCorreo()).contrasena(entity.getContrasena()).rol(entity.getRol()).build();
    }
}