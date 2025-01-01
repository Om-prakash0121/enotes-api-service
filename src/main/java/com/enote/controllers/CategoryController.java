package com.enote.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enote.entity.Category;
import com.enote.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        // category.setIsActive(isActive);
        boolean saveCategory = this.categoryServiceImpl.saveCategory(category);
        System.out.println(saveCategory);
        System.out.println(category);
        if (saveCategory) {
            return new ResponseEntity<>(saveCategory, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(saveCategory, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllCategories() {
        List<Category> allCategories = this.categoryServiceImpl.getAllCategories();
        if (CollectionUtils.isEmpty(allCategories)) {
            return new ResponseEntity<>(allCategories, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allCategories, HttpStatus.OK);
        }
    }

}
