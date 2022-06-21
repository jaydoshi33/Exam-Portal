package com.cognizant.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.admin.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
