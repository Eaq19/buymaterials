package com.family.buymaterials.domain.repository.h2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "material_code")
    private long id;

    @Column(name = "material_description", nullable = false, length = 150)
    private String description;

    @Column(name = "material_price", nullable = false)
    private double price;

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
    private Set<ProductDetail> productDetail;

}
