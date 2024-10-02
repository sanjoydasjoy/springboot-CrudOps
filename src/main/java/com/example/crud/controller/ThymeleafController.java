package com.example.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf")
    public String showThymeleafPage() {
        return "thymeleaf"; // Refers to thymeleaf.html in the templates folder
    }
}
