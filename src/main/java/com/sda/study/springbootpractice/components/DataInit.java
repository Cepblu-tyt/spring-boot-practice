package com.sda.study.springbootpractice.components;

import com.sda.study.springbootpractice.exceptions.SchoolNotFoundException;
import com.sda.study.springbootpractice.exceptions.StudentNotFoundException;
import com.sda.study.springbootpractice.models.School;
import com.sda.study.springbootpractice.models.Student;
import com.sda.study.springbootpractice.services.SchoolService;
import com.sda.study.springbootpractice.services.StudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Oksanen
 * @Date 2/28/2023
 */
@Component
public class DataInit {
    @Autowired
    private SchoolService schoolService;
    private StudentService studentService;

    @PostConstruct
    public void init() {
        initSchool();
    }

    // PRIVATE METHODS //
    private void initSchool() {
        System.out.println("Starting School initialization...");
        School school = new School();
        school.setName("Tartu University");
        school.setAddress("Ulikooli 18, Tartu.");
        school.setPhone("+372589632147");

        try {
            School searchSchool = schoolService.findSchoolByName(school.getName());
            System.out.println("Cannot pre-initialize school: " + school.getName());
        } catch (SchoolNotFoundException e) {
            schoolService.createSchool(school);
        }
    }

    private void initStudent() {
        System.out.println("Starting Student initialization...");
        Student student = new Student();
        student.setName(student.getName());
        student.setAge(student.getAge());
        student.setId(student.getId());

        try {
            Student searchStudent = studentService.findStudentByName(student.getName());
            System.out.println("Cannot pre-initialize student: " + student.getName());
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
