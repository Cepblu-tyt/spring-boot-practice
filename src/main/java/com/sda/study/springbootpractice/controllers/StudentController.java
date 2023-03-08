package com.sda.study.springbootpractice.controllers;

import com.sda.study.springbootpractice.exceptions.StudentNotFoundException;
import com.sda.study.springbootpractice.models.Student;
import com.sda.study.springbootpractice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Sergei Oksanen
 * @Date 3/7/2023
 */
@RestController
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findStudentByName(@PathVariable String name) throws StudentNotFoundException {
        Student student = studentService.findStudentByName(name);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setDate(new Date().toInstant());

        return new ResponseEntity<>(student, httpHeaders, HttpStatus.OK);
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) throws StudentNotFoundException {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //To show the create student form page
    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student) throws StudentNotFoundException {
        try {
            Student searchStudent = studentService.findStudentByName(student.getName());
            throw new RuntimeException("Student already exist! Cannot create this student!");
        } catch (StudentNotFoundException e) {
            studentService.createStudent(student);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) throws StudentNotFoundException {
        studentService.updateStudent(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreStudent(@PathVariable Long id) throws StudentNotFoundException {
        studentService.restoreStudentById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setDate(new Date().toInstant());

        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }

}