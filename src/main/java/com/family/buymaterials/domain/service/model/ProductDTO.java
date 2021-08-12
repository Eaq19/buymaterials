package com.family.buymaterials.domain.service.model;

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
public class ProductDTO {

    private long id;
    private String description;
    private Date createDate;
    private double tax;
    private Set<ProductDetailDTO> productDetail;
    private Set<InvoiceDetailDTO> invoiceDetail;

}
