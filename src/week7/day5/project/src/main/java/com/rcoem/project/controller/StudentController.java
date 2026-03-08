package com.rcoem.project.controller;

import com.rcoem.project.entity.Student;
import com.rcoem.project.repository.EmployeeRepository;
import com.rcoem.project.repository.StudentRepository;
import com.rcoem.project.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class StudentController{
    static StudentService studentService = new StudentService();

    @PostMapping("/add")
    public boolean addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @GetMapping("/getAll")
    public List<Student> findAll(){
        return studentService.findAll();
    }
    @PostMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.update(student);
    }

    @PostMapping("/findByName")
    public List<Student> findAllByName(@RequestParam String name){
        return studentService.findAllByName(name);
    }

    @PostMapping("/id")
    public Student findById(@RequestParam Long id){
        return studentService.findById(id);
    }

    @PostMapping("/course")
    public List<Student> findStudentEnrolledInCourse(@RequestParam String course){
        return studentService.findAllByCourse(course);
    }

    @PostMapping("/joining")
    public List<Student> findStudentByDoj(@RequestParam Date doj){
        return studentService.findAllByDoj(doj);
    }
}
