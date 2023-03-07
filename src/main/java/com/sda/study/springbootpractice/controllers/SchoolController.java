package com.sda.study.springbootpractice.controllers;

import com.sda.study.springbootpractice.exceptions.SchoolNotFoundException;
import com.sda.study.springbootpractice.models.School;
import com.sda.study.springbootpractice.services.SchoolService;

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
 * @Date 3/1/2023
 */
@RestController
@Controller
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public List<School> findAllSchools() {
        return schoolService.findAllSchools();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findSchoolById(@PathVariable Long id) throws SchoolNotFoundException {
            School school = schoolService.findSchoolById(id);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            httpHeaders.setDate(new Date().toInstant());

            return new ResponseEntity<>(school, httpHeaders, HttpStatus.OK);
        }


    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteSchool(@PathVariable Long id) throws SchoolNotFoundException {
        schoolService.deleteSchoolById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }


    //To show the create school form page
    @PostMapping
    public ResponseEntity<?> createSchool(@RequestBody School school) {
        try {
            School searchSchool = schoolService.findSchoolByName(school.getName());
            throw new RuntimeException("School already exist! Cannot create this school!");
        } catch (SchoolNotFoundException e) {
            schoolService.createSchool(school);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateSchool(@RequestBody School school) throws SchoolNotFoundException {
        schoolService.updateSchool(school);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreSchool(@PathVariable Long id) throws SchoolNotFoundException {
        schoolService.restoreSchoolById(id);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setDate(new Date().toInstant());

        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }

}