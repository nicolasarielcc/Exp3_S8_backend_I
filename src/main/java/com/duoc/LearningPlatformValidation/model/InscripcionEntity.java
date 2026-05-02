package com.duoc.LearningPlatformValidation.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "inscripciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscripcionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cursoId; // Relacionado a Curso

    private Long estudianteId; // Relacionado a Usuario

    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;
}
