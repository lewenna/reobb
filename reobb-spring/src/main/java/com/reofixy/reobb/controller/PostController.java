package com.reofixy.reobb.controller;

import com.reofixy.reobb.core.Utils;
import com.reofixy.reobb.model.Post;
import com.reofixy.reobb.model.dto.PostRequest;
import com.reofixy.reobb.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts/")
public class PostController {
    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("/create")
    private ResponseEntity<?> createPost(@RequestBody PostRequest postRequest){
        return new ResponseEntity(HttpStatus.OK);
    }
}
