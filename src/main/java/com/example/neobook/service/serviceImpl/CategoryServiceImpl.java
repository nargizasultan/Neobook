package com.example.neobook.service.serviceImpl;

import com.example.neobook.dto.CategoryResponse;
import com.example.neobook.repository.CategoryRepository;
import com.example.neobook.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<CategoryResponse> getAllCategory() {
        return categoryRepository.getAllCategories();
    }
}
