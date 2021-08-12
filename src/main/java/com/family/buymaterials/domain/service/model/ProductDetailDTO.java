package com.family.buymaterials.domain.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDetailDTO {

    private long id;
    private ProductDTO detailProduct;
    private MaterialDTO detailMaterial;
    private int materialCant;
    private double materialPrice;

}
