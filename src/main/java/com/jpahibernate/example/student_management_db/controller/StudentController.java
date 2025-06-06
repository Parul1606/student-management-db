package com.jpahibernate.example.student_management_db.controller;


import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    // contoller <-> service <-> repository  - flow of spring application

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student student){
        System.out.println(student.getEmail());
        String response = studentService.addStudent(student);
        return response;
    }

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        return student;
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudents(){
        List<Student> studentList = studentService.getAllStudents();
        return studentList;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id){
        String response = studentService.deleteStudentById(id);
        return response;
    }

    @GetMapping ("/count")
    public String countStudents(){
        String response = studentService.countStudents();
        return response;
    }

    @PutMapping("/updatePut/{id}")
    public String updateStudentByPut(@PathVariable int id, @RequestBody Student student){
        String response = studentService.updateStudentByPut(id, student);
        return response;
    }

    //Requestparam - only requesting that particular parameter
    @PatchMapping("/updatePatch/{id}")
    public String updateStudentByPatch(@PathVariable int id, @RequestParam String email){
        String response = studentService.updateStudentEmailUsingPatch(id, email);
        return response;
    }


}
