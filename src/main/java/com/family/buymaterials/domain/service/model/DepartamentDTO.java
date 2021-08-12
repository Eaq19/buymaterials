package com.family.buymaterials.domain.service.model;

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
public class DepartamentDTO {

    private long id;
    private String description;
    private List<CityDTO> citys;
    private List<ClientDTO> clients;
    private List<InvoiceHeaderDTO> invoiceHeaders;
}
