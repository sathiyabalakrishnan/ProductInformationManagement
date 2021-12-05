package com.mercado.pmi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Long SKU;

    private String title;

    private String description;

    private String price;

    private String quantity;
}
