package com.inventory.management.controller;

import com.inventory.management.model.Professor;
import com.inventory.management.service.IProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
@RequiredArgsConstructor
public class ProfessorController {

    private final IProfessorService professorService;

    @GetMapping("/")
    public ResponseEntity<List<Professor>> getProfessors() {
        return new ResponseEntity<>(professorService.getAllProfessors(), HttpStatus.FOUND);
    }

    @PostMapping("/")
    public Professor addProfessor(@RequestBody Professor professor) {
        return professorService.addProfessor(professor);
    }

    @PutMapping("/update/{id}")
    public Professor updateProfessor(@RequestBody Professor professor, @PathVariable Long id) {
        return professorService.updateProfessor(professor, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
    }

    @GetMapping("/professor/{id}")
    public Professor getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }

}
