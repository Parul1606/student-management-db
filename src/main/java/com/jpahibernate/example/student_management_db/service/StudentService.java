package com.jpahibernate.example.student_management_db.service;


import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service  //it contains business logic
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student){
        studentRepository.save(student);
        return "student saved successfully";
    }

    public Student getStudentById(int id){   //why we are using Student as a datatype? - We use Student as return type because this method returns a Student object if found
        Optional<Student> studentOptional = studentRepository.findById(id);    //optional is one of the data type here.. This value may or may not be present – used to avoid null-related issues
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }
}
