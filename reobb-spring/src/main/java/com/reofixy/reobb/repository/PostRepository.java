package com.reofixy.reobb.repository;

import com.reofixy.reobb.model.Category;
import com.reofixy.reobb.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Optional<Post> getPostById(int id);
    @Query("update Post p set p.content = :#{#post.content} where p.id = ?1")
    void updatePostById(int id, @Param("post") Post post);
}
