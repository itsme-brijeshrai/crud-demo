package com.inspironlabs.service;

import com.inspironlabs.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentService {

    Student getStudentById(Long id);
    void addStudent(Student student);
    void deleteStudentById(Long id);
}
