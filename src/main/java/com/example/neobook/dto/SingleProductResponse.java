package com.example.neobook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SingleProductResponse {

    private Long id;
    private String image;
    private String name;
    private int price;
    private String description;


}
