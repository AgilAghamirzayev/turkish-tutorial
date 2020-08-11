package com.example.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "My Pet entity", description = "My Pet")
public class Pet {

    @ApiModelProperty(value = "Id of Pet")
    private String id;
    @ApiModelProperty(value = "Name of Pet")
    private String name;
    @ApiModelProperty(value = "Date of Pet")
    private Date date;

    public Pet(String name, Date date) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.date = date;
    }
}
