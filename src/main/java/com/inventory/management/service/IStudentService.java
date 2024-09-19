package com.inventory.management.service;



import com.inventory.management.model.Student;

import java.util.List;

public interface IStudentService {

    public Student addStudent(Student student);

    public List<Student> getAllStudents();

    public Student updateStudent(Student student, Long id);

    public Student getStudentById(Long id);

    public void deleteStudent(Long id);

}
