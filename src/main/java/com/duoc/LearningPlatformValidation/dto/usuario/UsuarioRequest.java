package com.duoc.LearningPlatformValidation.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioRequest {
	private String nombre;

	private String correo;

	private String contrasena;

	private String rol;

}
