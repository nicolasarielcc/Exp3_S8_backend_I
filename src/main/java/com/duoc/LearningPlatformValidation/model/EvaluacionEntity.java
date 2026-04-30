

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "evaluaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cursoId; // Relacionado a Curso

    private String nombre;

    private int puntajeMaximo;

    @Temporal(TemporalType.DATE)
    private Date fechaAplicacion;
}
