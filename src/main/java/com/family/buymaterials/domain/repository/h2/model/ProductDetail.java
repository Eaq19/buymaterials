package com.family.buymaterials.domain.repository.h2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_detail_code")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_code")
    private Product detailProduct;

    @ManyToOne(optional = false)
    @JoinColumn(name = "material_code")
    private Material detailMaterial;

    @Column(name = "material_cant", nullable = false)
    private int materialCant;

    @Column(name = "material_price", nullable = false)
    private double materialPrice;

}
