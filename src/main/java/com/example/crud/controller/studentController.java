package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crud.model.Student;
import com.example.crud.repository.studentRepository;

@Controller // Changed from @RestController to @Controller
public class studentController {

    @Autowired
    studentRepository repo;

    // Display all students in the Thymeleaf HTML view
    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> students = repo.findAll();
        model.addAttribute("students", students); // Pass student data to the view
        return "thymeleaf"; // Thymeleaf view name (thymeleaf.html in the templates folder)
    }

    // Add a new student via Thymeleaf form
    @PostMapping("/students/add")
    public String createStudent(@RequestParam int regNo, @RequestParam String name, 
                                @RequestParam String department, @RequestParam float percentage) {
        Student student = new Student(regNo, name, department, percentage);
        repo.save(student);
        return "redirect:/students"; // Redirect to the main student list page
    }

    // Delete a student and redirect to the student list
    @GetMapping("/students/delete/{id}")
    public String removeStudent(@PathVariable int id) {
        Student student = repo.findById(id).get();
        repo.delete(student);
        return "redirect:/students"; // Redirect to the main student list page
    }

    // Update a student (basic update example)
    @GetMapping("/students/update/{id}")
    public String updateStudent(@PathVariable int id) {
        Student student = repo.findById(id).get();
        student.setName("Updated Name"); // Example for updating student name
        repo.save(student);
        return "redirect:/students"; // Redirect to the main student list page
    }
}
