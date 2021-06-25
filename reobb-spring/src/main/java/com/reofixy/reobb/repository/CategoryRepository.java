package com.reofixy.reobb.repository;

import com.reofixy.reobb.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> getCategoryById(int id);
    Optional<Category> getCategoryByCategoryName(String categoryName);
    void deleteCategoryByCategoryName(String categoryName);
    @Query("update Category c set c.categoryName = :#{#category.categoryName} where c.id = ?1")
    void updateCategoryById(int id, @Param("category") Category category);
}
