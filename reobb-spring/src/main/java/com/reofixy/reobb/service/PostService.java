package com.reofixy.reobb.service;

import com.reofixy.reobb.model.Post;
import com.reofixy.reobb.model.dto.PostDto;

public interface PostService {
    void createPost(PostDto postDto);
    void updatePost(int id, Post post);
    void deletePost(int id);
}
