package com.example.neobook.service;

import com.example.neobook.dto.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<CategoryResponse> getAllCategory();
}
