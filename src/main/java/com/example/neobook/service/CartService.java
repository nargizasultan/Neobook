package com.example.neobook.service;

import com.example.neobook.dto.SimpleResponse;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
     int getSumOfPrice();

     SimpleResponse addToCart(Long productId);

     SimpleResponse removeFromCart(Long productId);
}
