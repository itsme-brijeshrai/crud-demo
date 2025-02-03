package com.inspironlabs.controller;

import com.inspironlabs.entity.Student;
import com.inspironlabs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudent/{id}")
    ResponseEntity<Student> getStudentByIdController(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/addStudent")
    ResponseEntity<Student> addStudentController(@RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    ResponseEntity<Void> deleteStudentController(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

}