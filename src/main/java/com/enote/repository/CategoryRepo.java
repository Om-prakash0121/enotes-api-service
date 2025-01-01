package com.enote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enote.entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
    
}
