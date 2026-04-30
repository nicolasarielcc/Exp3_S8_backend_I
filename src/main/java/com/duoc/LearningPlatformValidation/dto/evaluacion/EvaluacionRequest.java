package com.duoc.LearningPlatformValidation.dto.evaluacion;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluacionRequest {
	private Long cursoId;

	private String nombre;

	private int puntajeMaximo;

	private Date fechaAplicacion;

}
