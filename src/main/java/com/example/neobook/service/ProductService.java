package com.example.neobook.service;

import com.example.neobook.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
     List<ProductResponse> getAllProduct() ;

}
