package com.matheusmaciel.api_cursos.modules.cursos;


import com.matheusmaciel.api_cursos.modules.cursos.enums.StatusCourse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name="courses")
@Data
public class CoursesEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        @NotBlank(message = "O campo [name] deve ser preenchido")
        private String name;
        @NotBlank(message = "O campo [categoria] deve ser preenchido")
        private String category;
        private StatusCourse status = StatusCourse.INACTIVE;

        @CreationTimestamp
        private LocalDateTime createdAt;
        @UpdateTimestamp
        private LocalDateTime updatedAt;


}
