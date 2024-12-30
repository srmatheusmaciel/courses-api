package com.matheusmaciel.api_cursos.modules.cursos.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheusmaciel.api_cursos.modules.cursos.CoursesEntity;

@Repository
public interface CoursesRepository extends JpaRepository<CoursesEntity, UUID> {
  List<CoursesEntity> findByNameContainingOrCategoryContaining(String name, String category);
}
