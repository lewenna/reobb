package com.reofixy.reobb.service;

import com.reofixy.reobb.core.Utils;
import com.reofixy.reobb.model.Category;
import com.reofixy.reobb.model.Post;
import com.reofixy.reobb.model.User;
import com.reofixy.reobb.model.dto.PostDto;
import com.reofixy.reobb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    public PostRepository postRepository;
    public UserService userService;
    public CategoryService categoryService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserService userService){
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto postDto) {
        Post post = Utils.getModelMapper().map(postDto, Post.class);
        User user = userService.getUserByUsername(postDto.getUsername());
        Category category = categoryService.getCategoryByName(postDto.getCategoryName());
        post.setAuthor(user);
        post.setCategory(category);
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
