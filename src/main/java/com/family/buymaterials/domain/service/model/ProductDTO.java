package com.family.buymaterials.domain.service.model;

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
public class ProductDTO {

    private long id;
    private String description;
    private Date createDate;
    private double tax;
    private Set<ProductDetailDTO> productDetail;
    private Set<InvoiceDetailDTO> invoiceDetail;

}
