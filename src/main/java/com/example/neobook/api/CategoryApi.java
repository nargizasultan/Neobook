package com.example.neobook.api;


import com.example.neobook.dto.CategoryResponse;
import com.example.neobook.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryApi {
    private final CategoryService categoryService;
    @GetMapping
    public List<CategoryResponse> getAllCategory(){
        return categoryService.getAllCategory();
    }

}
