package com.example.swagger.controller;

import com.example.swagger.entity.Pet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "My Pet API documentation")
public class PetController {

    private final List<Pet> petList = new ArrayList<>();

    @PostConstruct
    public void init(){
        petList.add(new Pet("Tom",new Date()));
    }

    @PostMapping
    @ApiOperation(value = "Add new Pet", notes = "Be careful using the method")
    public ResponseEntity<Pet> save(@RequestBody @ApiParam(value = "animal") Pet pet){
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "Get All Pets", notes = "This method gets all pets")
    public ResponseEntity<List<Pet>> getAll() {
        return ResponseEntity.ok(petList);
    }
}
