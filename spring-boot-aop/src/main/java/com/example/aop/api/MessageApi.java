package com.example.aop.api;

import com.example.aop.service.MessageService;
import com.example.aop.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageApi {

    private final MessageService messageService;
    private final PostService postService;

    public MessageApi(MessageService messageService, PostService postService) {
        this.messageService = messageService;
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<String> getMessage(@RequestBody String message){
        postService.getMessage(message);
        return ResponseEntity.ok(messageService.getMessage(message));
    }
}
