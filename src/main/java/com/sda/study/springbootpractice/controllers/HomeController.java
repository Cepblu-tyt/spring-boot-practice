package com.sda.study.springbootpractice.controllers;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sergei Oksanen
 * @Date 3/1/2023
 */

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String showHomePage() {
        return "home";
    }

}