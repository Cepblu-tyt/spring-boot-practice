package com.sda.study.springbootpractice.services.implementations;

import com.sda.study.springbootpractice.exceptions.CourseNotFoundException;
import com.sda.study.springbootpractice.models.Course;
import com.sda.study.springbootpractice.services.CourseService;

import java.util.List;

/**
 * @author Sergei Oksanen
 * @Date 2/28/2023
 */
public class CourseServiceImpl implements CourseService {
    @Override
    public void createCourse(Course course) {

    }

    @Override
    public Course findCourseById(Long id) throws CourseNotFoundException {
        return null;
    }

    @Override
    public Course findCourseByName(String name) throws CourseNotFoundException {
        return null;
    }

    @Override
    public List<Course> findAllCourses() {
        return null;
    }

    @Override
    public void updateCourse(Course course) throws CourseNotFoundException {

    }

    @Override
    public void deleteCourseById(Long id) throws CourseNotFoundException {

    }

    @Override
    public void restoreCourseById(Long id) throws CourseNotFoundException {

    }
}
