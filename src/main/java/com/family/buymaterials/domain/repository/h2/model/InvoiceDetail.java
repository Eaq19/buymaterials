package com.family.buymaterials.domain.repository.h2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "invoicedetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_item_consecutive")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "invoice_number", nullable = false, updatable = false)
    private InvoiceHeader detailInvoiceHeader;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_code", nullable = false)
    private Product invoiceDetailProduct;

    @Column(name = "product_cant", nullable = false)
    private int productCant;

    @Formula("(select SUM(m.material_price) " +
            "from PRODUCT p " +
            "LEFT JOIN PRODUCTDETAIL pd ON p.detailProduct = pd.product_detail_code " +
            "LEFT JOIN MATERIAL pd ON pd.material_code = m.material_code " +
            "where p.product_code = product_code)")
    private BigDecimal productUnitValue;
/*
    @Transient
    private BigDecimal invoiceProductTotal;

    @PostLoad
    private void onLoad() {
        this.invoiceProductTotal = productCant * productUnitValue;
    }

  */


}
