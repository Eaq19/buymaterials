package com.family.buymaterials.domain.service.model;

import com.family.buymaterials.domain.repository.h2.model.Departament;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityDTO {

    private long id;
    private String description;
    private Departament cityDepartament;
    private List<ClientDTO> clients;
    private List<InvoiceHeaderDTO> invoiceHeaders;
}
