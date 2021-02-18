package com.haydikodlayalim.apiversioning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductV2 {

    private String name;
    private BigDecimal price;

}