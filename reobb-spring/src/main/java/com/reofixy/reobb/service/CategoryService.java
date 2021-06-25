package com.reofixy.reobb.service;

import com.reofixy.reobb.model.Category;

public interface CategoryService {
    Category getCategoryById(int id);
    Category getCategoryByName(String categoryName);
    void updateCategory(int id, Category category);
    void addCategory(Category category);
    void deleteCategoryById(int id);
    void deleteCategoryByName(String categoryName);
    boolean isCategoryExists(Category category);
}
