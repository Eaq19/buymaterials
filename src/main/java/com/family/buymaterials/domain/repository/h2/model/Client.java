package com.family.buymaterials.domain.repository.h2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_code")
    private long id;

    @Column(name = "client_identification_number", nullable = false, length = 20)
    private String documentNumber;

    @Column(name = "client_identification_type", nullable = false, length = 5)
    private String documentType;

    @Column(name = "client_name", nullable = false, length = 50)
    private String name;

    @JoinColumn(name = "client_departament_code", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Departament departament;

    @JoinColumn(name = "client_city_code", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private City city;

    @Column(name = "client_address", nullable = false, length = 70)
    private String address;

    @Column(name = "client_phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "client_picture", nullable = false)
    private String picture;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<InvoiceHeader> invoices;
}
