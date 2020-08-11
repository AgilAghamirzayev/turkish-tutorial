package com.example.datajpa.controller;

import com.example.datajpa.dto.PersonDTO;
import com.example.datajpa.entity.Person;
import com.example.datajpa.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDTO> save(@RequestBody PersonDTO person){
        return ResponseEntity.ok(personService.save(person));
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getPersons(){
        return ResponseEntity.ok(personService.getAll());
    }

}
