package com.coloza.demo.graphql.query;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coloza.demo.graphql.model.entity.Student;
import com.coloza.demo.graphql.service.StudentService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class StudentQuery implements GraphQLQueryResolver {

    @Autowired
    private StudentService service;

    public Optional<Student> getStudent(int id) {
        return this.service.getStudent(id);
    }

    public List<Student> getStudents(int limit) {
        return this.service.getAllStudent(limit);
    }
}
