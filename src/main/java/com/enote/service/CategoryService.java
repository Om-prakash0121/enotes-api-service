package com.enote.service;

import java.util.List;

import com.enote.entity.Category;

public interface CategoryService {
    
    public boolean saveCategory(Category category);

    public List<Category> getAllCategories();

}
