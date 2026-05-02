package com.duoc.LearningPlatformValidation.repository;
import com.duoc.LearningPlatformValidation.model.EvaluacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EvaluacionRepository extends JpaRepository<EvaluacionEntity, Long> {
    List<EvaluacionEntity> findByCursoId(Long cursoId); // Requerido para el endpoint específico
}