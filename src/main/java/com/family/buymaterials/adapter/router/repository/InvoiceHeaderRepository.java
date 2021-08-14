package com.family.buymaterials.adapter.router.repository;

import com.family.buymaterials.domain.repository.h2.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeader, Long> {

    Set<InvoiceHeader> findByHeaderClient(Client client);

    @Query(
            value = "SELECT * FROM invoiceheaders u " +
                    "INNER JOIN clients c ON u.invoice_client_code = c.client_code WHERE u.invoice_client_code = ?1",
            nativeQuery = true)
    List<InvoiceHeader> findAllActiveUsersNative(String codeClient);
}
