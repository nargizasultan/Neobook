package com.example.neobook.repository;

import com.example.neobook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByEmail(String email);

    boolean existsByEmail(String email);
//    @Query("select p from  Product p join User u on u.id=:userId ")
//    int getSumOfPrice(Long userId);
}
