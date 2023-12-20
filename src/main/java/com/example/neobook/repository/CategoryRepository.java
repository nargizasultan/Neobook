package com.example.neobook.repository;

import com.example.neobook.dto.CategoryResponse;
import com.example.neobook.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select new com.example.neobook.dto.CategoryResponse(c.id, c.image, c.categoryName)  from Category c")
    List<CategoryResponse>getAllCategories();
}
