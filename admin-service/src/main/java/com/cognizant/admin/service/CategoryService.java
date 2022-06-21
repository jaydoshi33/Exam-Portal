package com.cognizant.admin.service;
import org.springframework.stereotype.Service;

import com.cognizant.admin.models.Category;

import java.util.Set;
@Service
public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Set<Category> getCategories();
    public Category getCategory(Long categoryId);
    public void deleteCategory(Long categoryId);
}
