package com.sda.study.springbootpractice.repositories;

import com.sda.study.springbootpractice.models.Course;

import com.sda.study.springbootpractice.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Sergei Oksanen
 * @Date 2/22/2023
 */

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    Optional<Course> findByName(String name);
    List<Course> findAllBySchool(School school);
 }
