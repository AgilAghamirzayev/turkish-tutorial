package com.example.graphql.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.entity.Vehicle;
import com.example.graphql.repo.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleQueryResolver implements GraphQLMutationResolver {

    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(String type){
        return vehicleRepository.getByTypeLike(type);
    }

    public Optional<Vehicle> getById(Long id){
        return vehicleRepository.findById(id);
    }
}
