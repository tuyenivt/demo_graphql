package com.coloza.demo.graphql.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coloza.demo.graphql.model.entity.Student;
import com.coloza.demo.graphql.service.StudentService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class StudentMutation implements GraphQLMutationResolver {

    @Autowired
    private StudentService service;

    public Student createStudent(String name, String address, String dateOfBirth) {
        return this.service.createStudent(name, address, dateOfBirth);
    }
}
