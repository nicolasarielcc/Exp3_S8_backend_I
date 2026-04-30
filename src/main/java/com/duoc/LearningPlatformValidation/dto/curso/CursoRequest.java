package com.duoc.LearningPlatformValidation.dto.curso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoRequest {
	private String nombre;

	private String descripcion;

	private Long profesorId;

}
