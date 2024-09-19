package com.inventory.management.service;

import com.inventory.management.exception.EntityAlreadyExistsException;
import com.inventory.management.exception.EntityNotFoundException;
import com.inventory.management.model.Professor;
import com.inventory.management.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService implements IProfessorService {

    private final ProfessorRepository repository;

    @Override
    public List<Professor> getAllProfessors(){
        return repository.findAll();
    }

    @Override
    public Professor getProfessorById(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("This Professor could not be found"));
    }

    @Override
    public Professor addProfessor(Professor professor){
        if(professorAlreadyExists(professor.getEmail())){
            throw new EntityAlreadyExistsException("Professor with email " + professor.getEmail() + " is already cadastred");
        }
        return repository.save(professor);
    }

    @Override
    public Professor updateProfessor(Professor professor, Long id){
        return repository.findById(id).map(st -> {
            st.setName(professor.getName());
            st.setSubject(professor.getSubject());
            st.setEmail(professor.getEmail());
            st.setPhoneNumber(professor.getPhoneNumber());
            return repository.save(st);
        }).orElseThrow(() -> new EntityNotFoundException("Sorry, this professor could not be found"));
    }

    @Override
    public void deleteProfessor(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("This Professor could not be found");
        }
        repository.deleteById(id);
    }

    private boolean professorAlreadyExists(String email){
        return repository.findByEmail(email).isPresent();
    }

}
