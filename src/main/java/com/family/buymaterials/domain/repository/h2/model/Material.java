package com.family.buymaterials.domain.repository.h2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "materials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_code")
    private long id;

    @Column(name = "material_description", nullable = false, length = 150)
    private String description;

    @Column(name = "material_price", nullable = false)
    private double price;

    @OneToMany(mappedBy = "detailMaterial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProductDetail> productDetail;

}
