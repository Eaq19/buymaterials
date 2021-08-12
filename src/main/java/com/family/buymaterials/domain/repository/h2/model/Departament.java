package com.family.buymaterials.domain.repository.h2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departament_code")
    private long id;

    @Column(name = "departament_description", nullable = false, length = 200)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityDepartament", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<City> citys;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientDepartament", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Client> clients;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "headerDepartament", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<InvoiceHeader> invoiceHeaders;

}
