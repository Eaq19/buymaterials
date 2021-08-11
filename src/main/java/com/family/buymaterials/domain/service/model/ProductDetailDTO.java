package com.family.buymaterials.domain.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDTO {

    private long id;
    private ProductDTO product;
    private MaterialDTO material;
    private int materialCant;
    private double materialPrice;

}
