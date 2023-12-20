package com.example.neobook.repository;

import com.example.neobook.dto.ProductResponse;
import com.example.neobook.dto.SingleProductResponse;
import com.example.neobook.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select new com.example.neobook.dto.ProductResponse(p.id,  p.image, p.name, p.price) from Product p ")
    List<ProductResponse> getAllProducts();

    @Query("select new com.example.neobook.dto.ProductResponse(p.id,  p.image, p.name, p.price) from Product p where p.category.id=:categoryId ")
    List<ProductResponse> getAllBySorting(Long categoryId);
    @Query("select new com.example.neobook.dto.ProductResponse(p.id, p.image, p.name, p.price) from Product p where p.name=:productName")
    List<ProductResponse> findByProductName(String productName);
    @Query("select new com.example.neobook.dto.SingleProductResponse(p.id,  p.image, p.name, p.price, p.description) from Product p where p.id=:productId ")
    SingleProductResponse getProductById(Long productId);
}
