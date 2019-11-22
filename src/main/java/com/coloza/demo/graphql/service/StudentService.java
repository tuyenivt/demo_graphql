package com.coloza.demo.graphql.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coloza.demo.graphql.model.entity.Student;
import com.coloza.demo.graphql.model.repository.StudentRepository;

@Service
public class StudentService {
    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Student createStudent(String name, String address, String dateOfBirth) {
        Student student = new Student();
        student.setName(name);
        student.setAddress(address);
        student.setDateOfBirth(LocalDate.parse(dateOfBirth));
        return this.repository.save(student);
    }

    @Transactional(readOnly = true)
    public Optional<Student> getStudent(int id) {
        return this.repository.findById(id);
    }

    public List<Student> getAllStudent(int limit) {
        return this.repository.findAll().stream().limit(limit).collect(Collectors.toList());
    }
}
