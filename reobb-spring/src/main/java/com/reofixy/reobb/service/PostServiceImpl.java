package com.reofixy.reobb.service;

import com.reofixy.reobb.core.exception.ApiRequestException;
import com.reofixy.reobb.core.exception.ExceptionMessage;
import com.reofixy.reobb.model.Post;
import com.reofixy.reobb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    public PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void updatePost(int id, Post post) {
        postRepository.updatePostById(id, post);
    }

    @Override
    public void deletePost(int id) {
        postRepository.deleteById(id);
    }
}
