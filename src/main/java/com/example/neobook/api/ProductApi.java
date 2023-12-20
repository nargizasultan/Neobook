package com.example.neobook.api;

import com.example.neobook.dto.ProductResponse;
import com.example.neobook.dto.SingleProductResponse;
import com.example.neobook.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;


    @GetMapping("/{categoryId}/all")
    public List<ProductResponse>getAllProducts(@PathVariable Long categoryId){
        return productService.getAllProductById(categoryId);
    }
    @GetMapping("/search")
    public List<ProductResponse>getAllProductBySearching(@RequestParam(required = false) String productName){
        return productService.getAllProductBySearching(productName);
    }
    @GetMapping("/{productId}")
    public SingleProductResponse getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }



}
