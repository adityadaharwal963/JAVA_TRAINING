package com.rcoem.project.repository;

import com.rcoem.project.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByName(String name);
    public List<Student> findByGender(String gender);
    public List<Student> findByCourse(String course);
    public List<Student> findByDoj(Date doj);
    @Transactional
    public void deleteByName(String name);
}
