package com.reofixy.reobb.repository;

import com.reofixy.reobb.model.ContentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<ContentLike, Integer> {
}
