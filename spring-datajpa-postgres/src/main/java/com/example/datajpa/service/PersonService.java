package com.example.datajpa.service;

import com.example.datajpa.dto.PersonDTO;
import com.example.datajpa.entity.Person;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface PersonService {
    PersonDTO save(PersonDTO personDTO);
    void delete(Long id);
    List<PersonDTO> getAll();
    Page<PersonDTO> getAll(Pageable pageable);
}
