package com.family.buymaterials.domain.service.model;

import com.family.buymaterials.domain.repository.h2.model.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceHeaderDTO {

    private long id;
    private Date date;
    private String address;
    private String phone;
    private double total;
    private Type status;
    private DepartamentDTO departament;
    private CityDTO city;
    private ClientDTO client;
    private Set<InvoiceDetailDTO> invoiceDetails;

}
