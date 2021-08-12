package com.family.buymaterials.domain.repository.h2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "departaments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departament_code")
    private long id;

    @Column(name = "departament_description", nullable = false, length = 200)
    private String description;

}
