package com.sda.study.springbootpractice.controllers;

import com.sda.study.springbootpractice.exceptions.SchoolNotFoundException;
import com.sda.study.springbootpractice.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Sergei Oksanen
 * @Date 3/1/2023
 */

@Controller
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public String showSchoolListPage(Model model, @ModelAttribute("message") String message,
                                     @ModelAttribute("messageType") String messageType) {
        model.addAttribute("schools", schoolService.findAllSchools());
        return "school/list-school";
    }

    @GetMapping("/{id}")
    public String showSchoolViewPage(@PathVariable Long id, Model model) {
        try {
            model.addAttribute("school", schoolService.findSchoolById(id));
            return "school/view-school";
        } catch (SchoolNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteSchool(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try {
            schoolService.deleteSchoolById(id);
            redirectAttributes.addFlashAttribute("message",
                    String.format("School(id=%d) deleted successfully",id));
            redirectAttributes.addFlashAttribute("messageType","success");
            return "redirect:/school";
        } catch (SchoolNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

