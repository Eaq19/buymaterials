package com.family.buymaterials.domain.repository.h2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_item_consecutive")
    private long id;

    @ManyToOne
    @JoinColumn(name = "invoice_number", nullable = false, updatable = false)
    private InvoiceHeader invoiceHeader;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_code")
    private Product product;

    @Column(name = "product_cant", nullable = false)
    private int productCant;
 /*
    @Formula("(select SUM(o.creation_date) from Orders o where o.customer_id = id)")
    private BigDecimal productUnitValue;

    @Transient
    private BigDecimal invoiceProductTotal;

    @PostLoad
    private void onLoad() {
        this.invoiceProductTotal = productCant * productUnitValue;
    }

  */


}