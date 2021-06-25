package com.reofixy.reobb.service;

import com.reofixy.reobb.core.exception.ApiRequestException;
import com.reofixy.reobb.core.exception.ExceptionMessage;
import com.reofixy.reobb.model.Category;
import com.reofixy.reobb.repository.CategoryRepository;

public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.getCategoryById(id).orElseThrow(() -> new ApiRequestException(ExceptionMessage.NOT_FOUND));
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryRepository.getCategoryByCategoryName(categoryName).orElseThrow(() -> new ApiRequestException(ExceptionMessage.NOT_FOUND));
    }

    @Override
    public void updateCategory(int id, Category category) {
        categoryRepository.updateCategoryById(id, category);
    }

    @Override
    public void addCategory(Category category) {
        if (!isCategoryExists(category)){
            categoryRepository.save(category);
        }
        else {
            throw new ApiRequestException(ExceptionMessage.CANT_SAVABLE);
        }
    }

    @Override
    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteCategoryByName(String categoryName) {
        categoryRepository.deleteCategoryByCategoryName(categoryName);
    }

    @Override
    public boolean isCategoryExists(Category category) {
        return categoryRepository.getCategoryByCategoryName(category.getCategoryName()).isPresent() || categoryRepository.getCategoryById(category.getId()).isPresent();
    }
}
