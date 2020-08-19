package com.example.graphql.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String modelCode;
    private String brandName;
    private Date launchDate;

    public Vehicle(String type, String modelCode, String brandName, Date date) {
        this.type = type;
        this.modelCode = modelCode;
        this.brandName = brandName;
        this.launchDate = date;
    }
}
