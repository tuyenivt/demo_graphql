package com.coloza.demo.graphql.service;

import com.coloza.demo.graphql.model.entity.Student;
import com.coloza.demo.graphql.model.entity.Vehicle;
import com.coloza.demo.graphql.model.repository.StudentRepository;
import com.coloza.demo.graphql.model.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    private VehicleRepository vehicleRepository;
    private StudentRepository studentRepository;

    public VehicleService(VehicleRepository vehicleRepository, StudentRepository studentRepository) {
        this.vehicleRepository = vehicleRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Vehicle create(String type, int studentId) {
        Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            vehicle.setStudent(student.get());
        }
        return this.vehicleRepository.save(vehicle);
    }

    @Transactional(readOnly = true)
    public List<Vehicle> findAll(int limit) {
        return this.vehicleRepository.findAll().stream().limit(limit).collect(Collectors.toList());
    }
}
