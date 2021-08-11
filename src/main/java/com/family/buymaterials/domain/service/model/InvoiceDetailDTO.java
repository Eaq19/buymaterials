package com.family.buymaterials.domain.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDetailDTO {

    private long id;
    private InvoiceHeaderDTO invoiceHeader;
    private ProductDTO product;
    private int productCant;

}
