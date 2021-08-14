package com.family.buymaterials.domain.service;

import com.family.buymaterials.domain.service.model.InvoiceHeaderDTO;

import java.util.HashMap;
import java.util.List;

public interface InvoiceHeaderServiceInterface {

    List<InvoiceHeaderDTO> findAllInvoiceHeaders();

    List<InvoiceHeaderDTO> likeNameInvoiceHeader(String name);

    InvoiceHeaderDTO findInvoiceHeaderById(Long id);

    InvoiceHeaderDTO saveInvoiceHeader(InvoiceHeaderDTO object);

    String deleteInvoiceHeader(Long id);

    String updateInvoiceHeader(InvoiceHeaderDTO object);

    List<InvoiceHeaderDTO> byFilter(HashMap<String, String> conditions);

    List<InvoiceHeaderDTO> validInvoice();

    List<InvoiceHeaderDTO> invalidInvoice();

}
