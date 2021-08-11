package com.family.buymaterials.domain.repository.h2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "departament_code")
    private long id;

    @Column(name = "departament_description", nullable = false, length = 200)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departament")
    private List<City> citys;
}
