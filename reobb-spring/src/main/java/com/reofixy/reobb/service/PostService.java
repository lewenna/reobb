package com.reofixy.reobb.service;

import com.reofixy.reobb.model.Post;

public interface PostService {
    void createPost(Post post);
    void updatePost(int id, Post post);
    void deletePost(int id);
}
