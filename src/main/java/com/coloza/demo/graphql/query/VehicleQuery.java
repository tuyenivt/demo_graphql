package com.coloza.demo.graphql.query;

import com.coloza.demo.graphql.model.entity.Vehicle;
import com.coloza.demo.graphql.service.VehicleService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleQuery implements GraphQLQueryResolver {

    @Autowired
    private VehicleService service;

    public List<Vehicle> getVehicles(int limit) {
        return this.service.findAll(limit);
    }
}
