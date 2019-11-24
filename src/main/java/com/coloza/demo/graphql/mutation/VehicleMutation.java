package com.coloza.demo.graphql.mutation;

import com.coloza.demo.graphql.model.entity.Vehicle;
import com.coloza.demo.graphql.service.VehicleService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleMutation implements GraphQLMutationResolver {

    @Autowired
    private VehicleService service;

    public Vehicle createVehicle(String type, int studentId) {
        return this.service.create(type, studentId);
    }
}
