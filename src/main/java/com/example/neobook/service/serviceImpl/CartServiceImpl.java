package com.example.neobook.service.serviceImpl;

import com.example.neobook.dto.SimpleResponse;
import com.example.neobook.entity.Product;
import com.example.neobook.entity.User;
import com.example.neobook.exceptions.BadCredentialException;
import com.example.neobook.repository.ProductRepository;
import com.example.neobook.repository.UserRepository;
import com.example.neobook.service.CartService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    @Override
    public int getSumOfPrice() {
      return currentUser().getSumOfProducts();
    }

    @Override
    @Transactional
    public SimpleResponse addToCart(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("product with id " + productId + " doesn't exists"));
        User user = currentUser();
        user.addToCart(product);
        userRepository.save(user);
        product.setUser(user);
        return new SimpleResponse(HttpStatus.OK, "product successfully added to card");
    }

    private User currentUser() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.getUserByEmail((currentUser.getName()))
                .orElseThrow(() -> new BadCredentialException("Forbidden for non-registered users"));
    }
}
