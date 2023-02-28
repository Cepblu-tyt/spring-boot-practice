package com.sda.study.springbootpractice.services;

import com.sda.study.springbootpractice.exceptions.StudentNotFoundException;
import com.sda.study.springbootpractice.models.School;
import com.sda.study.springbootpractice.models.Student;

import java.util.List;

/**
 * @author Sergei Oksanen
 * @Date 2/28/2023
 */
public interface StudentService {
    /**
     * To create a new student
     *
     * @param student Student
     */

    void createStudent(Student student) throws StudentNotFoundException;

    /**
     * To find a student by ID
     *
     * @param id Student ID
     * @return Student
     */

    Student findStudentById(Long id) throws StudentNotFoundException;

    /**
     * To find a school by name
     *
     * @param name School name
     * @return School
     */
    Student findStudentByName(String name) throws StudentNotFoundException;

    /**
     * To find all students
     *
     * @return a list of Students
     */
    List<Student> findAllStudents();

    /**
     * To update an existing Student
     *
     * @param student Student
     */

    void updateStudent(Student student) throws StudentNotFoundException;

    /**
     * To delete a Student by ID
     *
     * @param id Student ID
     */
    void deleteStudentById(Long id) throws StudentNotFoundException;

    /**
     * To restore a Student by ID
     *
     * @param id Student ID
     */

    void restoreStudentById(Long id) throws StudentNotFoundException;


}
