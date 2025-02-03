package com.inspironlabs.service;

import com.inspironlabs.entity.Student;
import com.inspironlabs.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo studentRepo;


    /**
     * @param id
     * @return
     */
    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optional = studentRepo.findById(id);
        return optional.orElse(null);
    }

    /**
     * @param student
     */
    @Override
    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    /**
     * @param id
     */
    @Override
    public void deleteStudentById(Long id) {
        Optional<Student> optional = studentRepo.findById(id);
        optional.ifPresent(studentRepo::delete);
    }
}
