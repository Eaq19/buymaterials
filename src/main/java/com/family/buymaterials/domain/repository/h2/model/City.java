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
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_code")
    private long id;

    @Column(name = "city_description", nullable = false, length = 200)
    private String description;

    @JoinColumn(name = "city_departament_code", nullable = false)
    @ManyToOne(optional = false)
    private Departament cityDepartament;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientCity", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Client> clients;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "headerCity", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<InvoiceHeader> invoiceHeaders;
}
