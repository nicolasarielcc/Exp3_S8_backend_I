package com.duoc.LearningPlatformValidation.repository;
import com.duoc.LearningPlatformValidation.model.InscripcionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InscripcionRepository extends JpaRepository<InscripcionEntity, Long> {
    List<InscripcionEntity> findByCursoId(Long cursoId); // Requerido para el endpoint específico
}