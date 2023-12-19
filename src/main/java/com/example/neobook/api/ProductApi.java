//package com.example.neobook.api;
//
//import com.example.neobook.dto.ProductResponse;
//import com.example.neobook.service.ProductService;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/product")
//@RequiredArgsConstructor
//public class ProductApi {
//
//    private final ProductService productService;
//
//    @GetMapping
//    public List<ProductResponse> getAllProducts(){
//        return productService.getAllProduct();
//    }
//
//
//}
