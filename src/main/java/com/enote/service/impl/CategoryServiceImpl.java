package com.enote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.enote.entity.Category;
import com.enote.repository.CategoryRepo;
import com.enote.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepository;

    @Override
    public boolean saveCategory(Category category) {
        category.setDeleted(false);
        category.setCreatedBy(1);
        category.setUpdatedBy(1);
        // category.setActive(true);
        Category savedCategory = this.categoryRepository.save(category);
        if (ObjectUtils.isEmpty(savedCategory)) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        if (CollectionUtils.isEmpty(categories)) {
            return null;
        } else {
            return categories;
        }
    }

}
