package com.inventory.management.service;

import com.inventory.management.model.Person;
import com.inventory.management.model.Professor;

import java.util.List;

public interface IProfessorService {

    public Professor addProfessor(Professor professor);

    public List<Professor> getAllProfessors();

    public Professor getProfessorById(Long id);

    public Professor updateProfessor(Professor professor, Long id);

    public void deleteProfessor(Long id);

}
