package com.sayak.demo.controller;

import com.sayak.demo.entity.Student;
import com.sayak.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/all")
    public String showAll(Model model){
        List<Student>students=studentService.findAll();
        model.addAttribute("student",students);
        return "student_list";
    }
    @GetMapping("/add")
    public String addStudent(Model model){

        Student student=new Student();
        model.addAttribute("student",student);
        return "new_student";
    }
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student){

        studentService.save(student);
        return "redirect:/student/all";

    }
    @GetMapping("/update")
    public String update(@RequestParam("id")Integer id,Model model){
        Student student=studentService.findById(id);
        model.addAttribute("student",student);
        return "new_student";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id")Integer id,Model model){
        Student student=studentService.findById(id);
        studentService.delete(student);
        return "redirect:/student/all";
    }

}
