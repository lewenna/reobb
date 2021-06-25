package com.reofixy.reobb.repository;

import com.reofixy.reobb.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
