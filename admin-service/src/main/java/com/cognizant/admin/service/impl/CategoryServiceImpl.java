package com.cognizant.admin.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.cognizant.admin.models.Category;
import com.cognizant.admin.repository.CategoryRepository;
import com.cognizant.admin.service.CategoryService;

import java.util.LinkedHashSet;
import java.util.Set;
@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

	public Category addCategory(Category category) {
		 return categoryRepository.save(category);
	}

	public Category updateCategory(Category category) {
		 return categoryRepository.save(category);
	}

	public Set<Category> getCategories() {
		 return new LinkedHashSet<Category>(categoryRepository.findAll());
	}

	public Category getCategory(Long categoryId) {
		return categoryRepository.findById(categoryId).get();
	}

	public void deleteCategory(Long categoryId) {
		categoryRepository.deleteById(categoryId);
		
	}
   
}
