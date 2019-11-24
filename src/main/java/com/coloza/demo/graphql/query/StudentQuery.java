package com.coloza.demo.graphql.query;

import com.coloza.demo.graphql.model.entity.Student;
import com.coloza.demo.graphql.service.StudentService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentQuery implements GraphQLQueryResolver {

    @Autowired
    private StudentService service;

    public Optional<Student> getStudent(int id) {
        return this.service.findById(id);
    }

    public List<Student> getStudents(int limit) {
        return this.service.findAll(limit);
    }
}
