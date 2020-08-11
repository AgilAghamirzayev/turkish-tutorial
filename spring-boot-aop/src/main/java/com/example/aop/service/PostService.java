package com.example.aop.service;

import org.springframework.stereotype.Service;

@Service
public class PostService {

    public void getMessage(String post) {
        System.out.println("Method responded: " + post);
    }

}
