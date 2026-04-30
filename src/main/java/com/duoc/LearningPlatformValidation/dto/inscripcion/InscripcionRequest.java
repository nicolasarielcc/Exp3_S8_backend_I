package com.duoc.LearningPlatformValidation.dto.inscripcion;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscripcionRequest {
	private Long cursoId;

	private Long estudianteId;

	private Date fechaInscripcion;

}
