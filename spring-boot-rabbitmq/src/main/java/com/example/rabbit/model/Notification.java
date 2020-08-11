package com.example.rabbit.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Notification implements Serializable {

    private String id;
    private Date createdAt;
    private Boolean seen;
    private String message;
}
