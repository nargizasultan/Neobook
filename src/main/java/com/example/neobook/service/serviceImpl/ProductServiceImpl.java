package com.example.neobook.service.serviceImpl;

import com.example.neobook.dto.ProductResponse;
import com.example.neobook.dto.SingleProductResponse;
import com.example.neobook.repository.ProductRepository;
import com.example.neobook.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;



    @Override
    public List<ProductResponse> getAllProductById(Long categoryId) {
       if(categoryId ==null){
          return productRepository.getAllProducts();
       }
        return productRepository.getAllBySorting(categoryId);


    }

    @Override
    public List<ProductResponse> getAllProductBySearching(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public SingleProductResponse getProductById(Long productId) {
        return productRepository.getProductById(productId);
    }
}
