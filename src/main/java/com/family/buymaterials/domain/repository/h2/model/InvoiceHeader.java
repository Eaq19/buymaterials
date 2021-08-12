package com.family.buymaterials.domain.repository.h2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_number")
    private long id;

    @Column(name = "invoice_date", nullable = false)
    private Date date;

    @Column(name = "invoice_address", nullable = false, length = 50)
    private String address;

    @Column(name = "invoice_phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "invoice_total", nullable = false)
    private double total;

    @Column(name="invoice_type", nullable = false, length = 15)
    @Enumerated(value = EnumType.STRING)
    private Type status;

    @JoinColumn(name = "invoice_departament_code", nullable = false)
    @ManyToOne(optional = false)
    private Departament headerDepartament;

    @JoinColumn(name = "invoice_city_code", nullable = false)
    @ManyToOne(optional = false)
    private City headerCity;

    @JoinColumn(name = "invoice_client_code", nullable = false)
    @ManyToOne(optional = false)
    private Client headerClient;

    @OneToMany(mappedBy = "detailInvoiceHeader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<InvoiceDetail> invoiceDetails;

    /*
    @Transient
    private Double invoiceTotal;

    @PostLoad
    private void onLoad() {
        this.invoiceTotal = price * taxes;
    }

     */

}
