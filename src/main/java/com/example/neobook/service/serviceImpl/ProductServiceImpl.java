package com.example.neobook.service.serviceImpl;

import com.example.neobook.dto.ProductResponse;
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
    public List<ProductResponse> getAllProduct() {
       return   productRepository.getAllProducts();
    }
}
