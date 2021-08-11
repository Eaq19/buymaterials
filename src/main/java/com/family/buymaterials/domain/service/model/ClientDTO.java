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
public class ClientDTO {

    private long id;
    private String documentNumber;
    private String documentType;
    private String name;
    private DepartamentDTO departament;
    private CityDTO city;
    private String address;
    private String phoneNumber;
    private String picture;
    private Set<InvoiceHeaderDTO> invoices;
}
