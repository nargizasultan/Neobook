package com.example.neobook.service;

import com.example.neobook.dto.ProductResponse;
import com.example.neobook.dto.SingleProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
     List<ProductResponse> getAllProductById(Long categoryId);

     List<ProductResponse> getAllProductBySearching(String productName);

     SingleProductResponse getProductById(Long productId);

}
