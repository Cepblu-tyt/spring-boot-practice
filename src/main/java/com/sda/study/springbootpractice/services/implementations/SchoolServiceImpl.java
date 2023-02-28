package com.sda.study.springbootpractice.services.implementations;

import com.sda.study.springbootpractice.exceptions.SchoolNotFoundException;
import com.sda.study.springbootpractice.models.School;
import com.sda.study.springbootpractice.repositories.SchoolRepository;
import com.sda.study.springbootpractice.services.SchoolService;
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
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public void createSchool(School school) {
        school.setActive(true);
        schoolRepository.save(school);
    }

    @Override
    public School findSchoolById(Long id) throws SchoolNotFoundException {
        Optional<School> schoolOptional = schoolRepository.findById(id);

        if(schoolOptional.isEmpty()) {
            throw new SchoolNotFoundException(id);
        }

        return schoolOptional.get();
    }

    @Override
    public School findSchoolByName(String name) throws SchoolNotFoundException {
        Optional<School> schoolOptional = schoolRepository.findByName(name);

        if(schoolOptional.isEmpty()) {
            throw new SchoolNotFoundException(name);
        }

        return schoolOptional.get();
    }

    @Override
    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public void updateSchool(School school) throws SchoolNotFoundException {
        if(findSchoolById(school.getId()) != null) {
            schoolRepository.saveAndFlush(school);
        }
    }

    @Override
    public void deleteSchoolById(Long id) throws SchoolNotFoundException {
        School school = findSchoolById(id);
        // schoolRepository.delete(school); // To delete the record completely from the repo
        school.setActive(false);
        schoolRepository.saveAndFlush(school);
    }

    @Override
    public void restoreSchoolById(Long id) throws SchoolNotFoundException {
        School school = findSchoolById(id);
        school.setActive(true);
        schoolRepository.saveAndFlush(school);
    }
}

