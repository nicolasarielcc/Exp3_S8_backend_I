package com.duoc.LearningPlatformValidation.repository;
import com.duoc.LearningPlatformValidation.model.CursoEntity;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Long> {

ArrayList<CursoEntity> findByActivo(boolean activo);

	ArrayList<CursoEntity> findByCategoriaIgnoreCase(String categoria);

	ArrayList<CursoEntity> findByProfesorIgnoreCase(String profesor);

	java.util.Optional<CursoEntity> findByIndiceIgnoreCase(String indice);

	ArrayList<CursoEntity> findByCategoriaAndActivo(String categoria, boolean activo);


}
