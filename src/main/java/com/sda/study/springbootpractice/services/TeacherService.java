package com.sda.study.springbootpractice.services;

import com.sda.study.springbootpractice.exceptions.TeacherNotFoundException;
import com.sda.study.springbootpractice.models.Teacher;

import java.util.List;

/**
 * @author Sergei Oksanen
 * @Date 2/28/2023
 */
public interface TeacherService {
    /**
     * To create a new Teacher
     *
     * @param teacher Teacher
     */

    void createTeacher(Teacher teacher) throws TeacherNotFoundException;

    /**
     * To find a teacher by ID
     *
     * @param id Teacher ID
     * @return Teacher
     */

    Teacher findTeacherById(Long id) throws  TeacherNotFoundException;

    /**
     * To find a school by name
     *
     * @param name School name
     * @return School
     */
    Teacher findTeacherByName(String name) throws TeacherNotFoundException;

    /**
     * To find all Teachers
     *
     * @return a list of Teachers
     */
    List<Teacher> findAllTeachers();

    /**
     * To update an existing Teacher
     *
     * @param Teacher Teacher
     */

    void updateTeacher(Teacher Teacher) throws TeacherNotFoundException;

    /**
     * To delete a Teacher by ID
     *
     * @param id Teacher ID
     */
    void deleteTeacherById(Long id) throws TeacherNotFoundException;

    /**
     * To restore a Teacher by ID
     *
     * @param id Teacher ID
     */

    void restoreTeacherById(Long id) throws TeacherNotFoundException;


}
