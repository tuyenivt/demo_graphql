package com.coloza.demo.graphql.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coloza.demo.graphql.model.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
