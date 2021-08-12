package com.family.buymaterials.adapter.router.repository;

import com.family.buymaterials.domain.repository.h2.model.Client;
import com.family.buymaterials.domain.repository.h2.model.InvoiceHeader;
import com.family.buymaterials.domain.repository.h2.model.Product;
import com.family.buymaterials.domain.repository.h2.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeader, Long> {

    Set<InvoiceHeader> findByHeaderClient(Client client);
}
