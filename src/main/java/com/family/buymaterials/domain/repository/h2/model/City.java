package com.family.buymaterials.domain.repository.h2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "citys")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_code")
    private long id;

    @Column(name = "city_description", nullable = false, length = 200)
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_departament_code", nullable = false)
    private Departament cityDepartament;
}
