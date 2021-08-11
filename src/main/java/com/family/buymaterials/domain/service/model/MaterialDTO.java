package com.family.buymaterials.domain.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDTO {

    private long id;
    private String description;
    private double price;
    private Set<ProductDetailDTO> productDetail;

}
