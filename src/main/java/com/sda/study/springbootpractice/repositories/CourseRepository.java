package com.sda.study.springbootpractice.repositories;

import com.sda.study.springbootpractice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sergei Oksanen
 * @Date 2/22/2023
 */

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}