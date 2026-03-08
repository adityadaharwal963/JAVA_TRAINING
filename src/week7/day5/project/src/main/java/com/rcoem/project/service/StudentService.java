package com.rcoem.project.service;

import com.rcoem.project.ProjectApplication;
import com.rcoem.project.entity.Student;
import java.sql.Date;
import java.util.List;

public class StudentService {
    ProjectApplication application = new ProjectApplication();
    public boolean addStudent(Student student){
        // Logic to check null values in student
         application.studentRepository.save(student);
         return true;
    }
    public Student findById(Long id) {
        return application.studentRepository.findById(id).orElse(null);
    }
    public List<Student> findByName(String name){
        return application.studentRepository.findByName(name);
    }
    public List<Student> findAll(){
        return application.studentRepository.findAll();
    }
    public Student update(Student student){
        if(student.getId()==null) return null;
        if(!application.studentRepository.findById(student.getId()).isPresent()) return null;
        Student student1 = this.findById(student.getId());
        student1.setName(student.getName());
        student1.setCourse(student.getCourse());
        student1.setDepartment(student.getDepartment());
        student1.setDoj(student.getDoj());
        student1.setFees(student.getFees());
        student1.setGender(student.getGender());
        return application.studentRepository.save(student1);
    }
    public void delete(Student student){
        application.studentRepository.delete(student);
    }

    public List<Student> findAllByName(String name){
        return application.studentRepository.findByName(name);
    }
    public List<Student> findAllByGender(String gender){
        return application.studentRepository.findByGender(gender);
    }

    public List<Student> findAllByCourse(String course){
        return application.studentRepository.findByCourse(course);
    }
    public List<Student> findAllByDoj(Date doj){
        return application.studentRepository.findByDoj(doj);
    }

    public void deleteById(Long id){
        application.studentRepository.deleteById(id);
    }

    public void deleteByName(String name){
        application.studentRepository.deleteByName(name);
    }
}
