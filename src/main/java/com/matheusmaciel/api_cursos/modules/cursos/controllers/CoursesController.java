package com.matheusmaciel.api_cursos.modules.cursos.controllers;

import com.matheusmaciel.api_cursos.modules.cursos.CoursesEntity;
import com.matheusmaciel.api_cursos.modules.cursos.enums.StatusCourse;
import com.matheusmaciel.api_cursos.modules.cursos.repositories.CoursesRepository;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CoursesRepository coursesRepository;


    @PostMapping("/")
    public ResponseEntity<CoursesEntity> createCourse(@Valid @RequestBody CoursesEntity curso) {
        coursesRepository.save(curso);
        return ResponseEntity.ok(curso);
    }

    @GetMapping
    public ResponseEntity<List<CoursesEntity>> getAllCourses(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "category", required = false) String category) {

        List<CoursesEntity> courses;
        if (name != null || category != null) {
            courses = coursesRepository.findByNameContainingOrCategoryContaining(name, category);
        } else {
            courses = coursesRepository.findAll();
        }
        return ResponseEntity.ok(courses);
    }

    @PutMapping("/{id}")        
    public ResponseEntity<CoursesEntity> updateCourses(
        @PathVariable(value = "id") UUID id,
        @Valid @RequestBody CoursesEntity updatedCourse)
    {
        Optional<CoursesEntity> optionalCourse = coursesRepository.findById(id);
        if(optionalCourse.isPresent()){
            CoursesEntity existingCourse = optionalCourse.get();
            if(updatedCourse.getName() != null){
                existingCourse.setName(updatedCourse.getName());
        }

        if(updatedCourse.getCategory()!= null){
            existingCourse.setCategory(updatedCourse.getCategory());
        }
        coursesRepository.save(existingCourse);
        return ResponseEntity.ok(existingCourse);
    }else{
        return ResponseEntity.notFound().build();
    }
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable(value = "id") UUID id){
        Optional<CoursesEntity> optionalCourse = coursesRepository.findById(id);
        if(optionalCourse.isPresent()){
            CoursesEntity existingCourse = optionalCourse.get();
            coursesRepository.delete(existingCourse);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<CoursesEntity> toggleActiveStatus(
            @PathVariable UUID id,
            @RequestBody @Valid StatusCourse status) {
    
    
        Optional<CoursesEntity> optionalCourse = coursesRepository.findById(id);
    
        if (optionalCourse.isPresent()) {
            CoursesEntity existingCourse = optionalCourse.get();
            existingCourse.setStatus(status);
            coursesRepository.save(existingCourse);

            return ResponseEntity.ok(existingCourse);

        } else {
            return ResponseEntity.notFound().build();
        }
    }
    


}
