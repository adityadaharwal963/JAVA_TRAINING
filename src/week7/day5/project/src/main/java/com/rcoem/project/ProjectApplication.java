package com.rcoem.project;

import com.rcoem.project.entity.Student;
import com.rcoem.project.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProjectApplication {
    public static StudentRepository studentRepository;
    public static void main(String[] args) {

        ApplicationContext app = SpringApplication.run(ProjectApplication.class, args);
        studentRepository = app.getBean(StudentRepository.class);

    }

}
