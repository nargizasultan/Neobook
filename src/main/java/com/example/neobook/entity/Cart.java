//package com.example.neobook.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//@Entity
//@Table(name = "carts")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Cart {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_gen")
//    @SequenceGenerator(name = "cart_gen", sequenceName = "cart_seq", allocationSize = 1)
//    private Long id;
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Product> product;
//    private int price;
//
//}
