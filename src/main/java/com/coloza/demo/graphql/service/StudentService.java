package com.coloza.demo.graphql.service;

import com.coloza.demo.graphql.model.entity.Student;
import com.coloza.demo.graphql.model.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Student create(String name, String address, String dateOfBirth) {
        Student student = new Student();
        student.setName(name);
        student.setAddress(address);
        student.setDateOfBirth(LocalDate.parse(dateOfBirth));
        return this.repository.save(student);
    }

    @Transactional(readOnly = true)
    public Optional<Student> findById(int id) {
        return this.repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Student> findAll(int limit) {
        return this.repository.findAll().stream().limit(limit).collect(Collectors.toList());
    }
}
