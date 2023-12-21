package com.example.neobook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Literal;

import java.util.List;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_gen")
    @SequenceGenerator(name = "product_gen", sequenceName = "product_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String image;
    private int price;
    private String description;
    @ManyToOne
    private Category category;


    @ManyToMany
    private List<User> usersCart;

    public void addUser(User user){
        this.usersCart.add(user);
    }
    public void removeUser(User user){
        this.usersCart.remove(user);
    }





}
