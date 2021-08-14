package com.family.buymaterials.domain.service.impl;

import com.family.buymaterials.adapter.router.repository.InvoiceHeaderRepository;
import com.family.buymaterials.domain.repository.h2.model.InvoiceHeader;
import com.family.buymaterials.domain.service.InvoiceHeaderServiceInterface;
import com.family.buymaterials.domain.service.model.InvoiceHeaderDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Service
public class InvoiceHeaderImpl implements InvoiceHeaderServiceInterface {

    private InvoiceHeaderRepository invoiceHeaderRepository;
    private ObjectMapper objectMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public InvoiceHeaderImpl(InvoiceHeaderRepository invoiceHeaderRepository, ObjectMapper objectMapper) {
        this.invoiceHeaderRepository = invoiceHeaderRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<InvoiceHeaderDTO> findAllInvoiceHeaders() {
        List<InvoiceHeaderDTO> list = new ArrayList<>();
        List<InvoiceHeader> listInvoiceHeader = invoiceHeaderRepository.findAll();
        if (!listInvoiceHeader.isEmpty()) {
            list = objectMapper.convertValue(listInvoiceHeader,
                    new TypeReference<List<InvoiceHeaderDTO>>() {
                    });
        }
        return list;
    }

    @Override
    public List<InvoiceHeaderDTO> likeNameInvoiceHeader(String name) {
        List<InvoiceHeaderDTO> list = new ArrayList<>();
        List<InvoiceHeader> listInvoiceHeader = new ArrayList<>();
        if (!listInvoiceHeader.isEmpty()) {
            list = objectMapper.convertValue(listInvoiceHeader,
                    new TypeReference<List<InvoiceHeaderDTO>>() {
                    });
        }
        return list;
    }

    @Override
    public InvoiceHeaderDTO findInvoiceHeaderById(Long id) {
        Optional<InvoiceHeader> invoiceHeader = invoiceHeaderRepository.findById(id);
        InvoiceHeaderDTO invoiceHeaderDTO = null;
        if (invoiceHeader.isPresent()) {
            invoiceHeaderDTO = objectMapper.convertValue(invoiceHeader.get(), new TypeReference<InvoiceHeaderDTO>() {
            });
        }
        return invoiceHeaderDTO;
    }

    @Override
    public InvoiceHeaderDTO saveInvoiceHeader(InvoiceHeaderDTO invoiceHeaderNew) {
        InvoiceHeaderDTO response = null;
        if (invoiceHeaderNew != null) {
            InvoiceHeader invoiceHeader = objectMapper.convertValue(invoiceHeaderNew, new TypeReference<InvoiceHeader>() {
            });
            response = objectMapper.convertValue(invoiceHeaderRepository.save(invoiceHeader), new TypeReference<InvoiceHeaderDTO>() {
            });
        }
        return response;
    }

    @Override
    public String deleteInvoiceHeader(Long id) {
        if (invoiceHeaderRepository.findById(id).isPresent()) {
            invoiceHeaderRepository.deleteById(id);
            return "Ciudad eliminado correctamente.";
        }
        return "Error! El Ciudad no existe";
    }

    @Override
    public String updateInvoiceHeader(InvoiceHeaderDTO invoiceHeaderUpdate) {
        Long num = invoiceHeaderUpdate.getId();
        if (invoiceHeaderRepository.findById(num).isPresent()) {
            InvoiceHeader invoiceHeader = objectMapper.convertValue(invoiceHeaderUpdate, new TypeReference<InvoiceHeader>() {
            });
            invoiceHeaderRepository.save(invoiceHeader);
            return "1";
        }
        return "0";
    }

    @Override
    public List<InvoiceHeaderDTO> byFilter(final HashMap<String, String> conditions) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<InvoiceHeader> query = cb.createQuery(InvoiceHeader.class);
        Root<InvoiceHeader> root = query.from(InvoiceHeader.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field, value) ->
        {
            switch (field) {
                case "id":
                    predicates.add(cb.equal(root.get(field), Integer.valueOf(value)));
                    break;
                case "headerClient":
                    predicates.add(cb.equal(root.get(field).get("id"), Integer.valueOf(value)));
                    break;
                case "headerClient.name":
                    predicates.add(cb.like(root.get("headerClient").get("name"), "%" + (String) value + "%"));
                    break;
                case "headerDepartament":
                    predicates.add(cb.equal(root.get(field).get("id"), Integer.valueOf(value)));
                    break;
                case "headerCity":
                    predicates.add(cb.equal(root.get(field).get("id"), Integer.valueOf(value)));
                    break;
                case "startDate":
                    String dateCondition = (String) conditions.get("dateConditionstartDate");
                    Date date = null;
                    try {
                        date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS").parse(value + " 00:00:00:000");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    switch (dateCondition)
                    {
                        case "GREATER_THAN":
                            predicates.add(cb.greaterThan(root.<Date>get("date"),date));
                            break;
                        case "LESS_THAN":
                            predicates.add(cb.lessThan(root.<Date>get("date"),date));
                            break;
                        case "EQUAL":
                            predicates.add(cb.equal(root.<Date>get("date"),date));
                            break;
                    }
                    break;
                case "endDate":
                    Date date2 = null;
                    try {
                        date2 = new SimpleDateFormat("yyyy/MM/dd").parse(value);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    switch ((String) conditions.get("dateConditionendDate"))
                    {
                        case "GREATER_THAN":
                            predicates.add(cb.greaterThan(root.<Date>get("date"),date2));
                            break;
                        case "LESS_THAN":
                            predicates.add(cb.lessThan(root.<Date>get("date"),date2));
                            break;
                        case "EQUAL":
                            predicates.add(cb.equal(root.<Date>get("date"),date2));
                            break;
                    }
                    break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        List<InvoiceHeader> listInvoiceHeader = entityManager.createQuery(query).getResultList();
        entityManager.close();
        List<InvoiceHeaderDTO> list = new ArrayList<>();
        if (!listInvoiceHeader.isEmpty()) {
            list = objectMapper.convertValue(listInvoiceHeader,
                    new TypeReference<List<InvoiceHeaderDTO>>() {
                    });
        }
        return list;
    }

    @Override
    public List<InvoiceHeaderDTO> validInvoice() {
        String query = "SELECT i.* FROM invoiceheaders AS i WHERE (i.invoice_total >= '50000' and i.invoice_total < '200000' and i.invoice_type = 'Operacional') or (i.invoice_total >= '200000' and i.invoice_type = 'Venta_directa')";
        List<InvoiceHeader> listInvoiceHeader = entityManager.createNativeQuery(query, InvoiceHeader.class).getResultList();
        entityManager.close();
        List<InvoiceHeaderDTO> list = new ArrayList<>();
        if (!listInvoiceHeader.isEmpty()) {
            list = objectMapper.convertValue(listInvoiceHeader,
                    new TypeReference<List<InvoiceHeaderDTO>>() {
                    });
        }
        return list;
    }

    @Override
    public List<InvoiceHeaderDTO> invalidInvoice() {
        String query = "SELECT i.* FROM invoiceheaders AS i WHERE (i.invoice_date >= '2021-01-01 00:00:00' and i.invoice_date < '2021-03-01 00:00:00' and (i.invoice_total = '500000' or i.invoice_total = '600000')) or (i.invoice_date >= '2020-12-01 00:00:00' and i.invoice_date < '2021-01-01 00:00:00' and i.invoice_total = '200000')";
        List<InvoiceHeader> listInvoiceHeader = entityManager.createNativeQuery(query, InvoiceHeader.class).getResultList();
        entityManager.close();
        List<InvoiceHeaderDTO> list = new ArrayList<>();
        if (!listInvoiceHeader.isEmpty()) {
            list = objectMapper.convertValue(listInvoiceHeader,
                    new TypeReference<List<InvoiceHeaderDTO>>() {
                    });
        }
        return list;
    }
}
