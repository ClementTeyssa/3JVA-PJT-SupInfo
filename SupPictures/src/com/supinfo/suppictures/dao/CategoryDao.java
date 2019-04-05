package com.supinfo.suppictures.dao;

import java.util.List;

import com.supinfo.suppictures.entity.Category;

public interface CategoryDao {
    void addCategory(Category category);
    Category findCategoryById(Long id);
    List<Category> getAllCategories();
    void updateCategory(Category category);
    void removeCategory(Category category);
    Category getCategoryByIdWithPicture(Long id);
}
