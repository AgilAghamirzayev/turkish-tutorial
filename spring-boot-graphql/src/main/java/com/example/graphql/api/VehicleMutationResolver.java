package com.example.graphql.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.dto.VehicleDto;
import com.example.graphql.entity.Vehicle;
import com.example.graphql.repo.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleRepository vehicleRepository;

    public Vehicle createVehicle(VehicleDto vehicleDto) {
        return vehicleRepository.save(dtoToVehicle(vehicleDto));
    }

    private Vehicle dtoToVehicle(VehicleDto vehicleDto) {
        return new Vehicle(vehicleDto.getType(), vehicleDto.getModelCode(), vehicleDto.getBrandName(), new Date());
    }
}
