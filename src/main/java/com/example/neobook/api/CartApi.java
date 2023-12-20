package com.example.neobook.api;

import com.example.neobook.dto.SimpleResponse;
import com.example.neobook.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartApi {
    private final CartService cartService;

    @GetMapping
    public int getSumOfPrice() {
        return cartService.getSumOfPrice();
    }
    @PostMapping("{productId}/add")
    public SimpleResponse addToCart(@PathVariable Long productId){
        return cartService.addToCart(productId);
    }

}
