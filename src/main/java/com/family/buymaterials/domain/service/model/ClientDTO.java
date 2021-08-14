package com.family.buymaterials.domain.service.model;

import com.family.buymaterials.domain.repository.h2.model.City;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO {

    private long id;
    private String documentNumber;
    private String documentType;
    private String name;
    private DepartamentDTO clientDepartament;
    private CityDTO clientCity;
    private String address;
    private String phoneNumber;
    private String picture;
    private Set<InvoiceHeaderDTO> invoices;
}
