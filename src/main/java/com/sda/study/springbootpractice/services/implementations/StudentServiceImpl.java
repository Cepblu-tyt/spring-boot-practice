package com.sda.study.springbootpractice.services.implementations;

import com.sda.study.springbootpractice.exceptions.StudentNotFoundException;
import com.sda.study.springbootpractice.models.Student;
import com.sda.study.springbootpractice.repositories.StudentRepository;
import com.sda.study.springbootpractice.services.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Sergei Oksanen
 * @Date 2/28/2023
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void createStudent(Student student) {
        student.setActive(true);
        studentRepository.save(student);
    }

    @Override
    public Student findStudentById(Long id) throws StudentNotFoundException {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(studentOptional.isEmpty()) {
            throw new StudentNotFoundException(id);
        }

        return studentOptional.get();
    }

    @Override
    public Student findStudentByName(String name) throws StudentNotFoundException {
        Optional<Student> studentOptional = studentRepository.findByName(name);

        if(studentOptional.isEmpty()) {
            throw new StudentNotFoundException(name);
        }

        return studentOptional.get();
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void updateStudent(Student Student) throws StudentNotFoundException {
        if(findStudentById(Student.getId()) != null) {
            studentRepository.saveAndFlush(Student);
        }
    }

    @Override
    public void deleteStudentById(Long id) throws StudentNotFoundException {
        Student student = findStudentById(id);
        // StudentRepository.delete(Student); // To delete the record completely from the repo
        student.setActive(false);
        studentRepository.saveAndFlush(student);
    }

    @Override
    public void restoreStudentById(Long id) throws StudentNotFoundException {
        Student student = findStudentById(id);
        student.setActive(true);
        studentRepository.saveAndFlush(student);
    }
}

