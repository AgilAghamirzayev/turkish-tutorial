package com.example.datajpa.dto;

import lombok.Data;

import java.util.List;

@Data
public class PersonDTO {
    private Long id;
    private String name;
    private String lastName;
    private List<String> addresses;
}
