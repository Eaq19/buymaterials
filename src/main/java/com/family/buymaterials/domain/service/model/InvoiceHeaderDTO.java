package com.family.buymaterials.domain.service.model;

import com.family.buymaterials.domain.repository.h2.model.Type;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoiceHeaderDTO {

    private long id;
    private Date date;
    private String address;
    private String phone;
    private double total;
    private Type invoiceType;
    private DepartamentDTO headerDepartament;
    private CityDTO headerCity;
    private ClientDTO headerClient;
    private Set<InvoiceDetailDTO> invoiceDetails;

}
