package com.family.buymaterials.adapter.router.controller;

import com.family.buymaterials.domain.service.InvoiceHeaderServiceInterface;
import com.family.buymaterials.domain.service.model.InvoiceHeaderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("invoiceheaders")
public class InvoiceHeaderController {

    @Autowired
    private InvoiceHeaderServiceInterface invoiceHeaderServiceInterface;

    // http://localhost:8888/invoiceheaders (GET)
    @GetMapping(produces = "application/json")
    public List<InvoiceHeaderDTO> getInvoiceHeaders() {
        return invoiceHeaderServiceInterface.findAllInvoiceHeaders();
    }

    // http://localhost:8888/invoiceheaders/1 (GET)
    @GetMapping(value = "/{id}", produces = "application/json")
    public InvoiceHeaderDTO getInvoiceHeaderById(@PathVariable Long id) {
        return invoiceHeaderServiceInterface.findInvoiceHeaderById(id);
    }

    // http://localhost:8888/invoiceheaders/add (ADD)
    @PostMapping(value = "/add", produces = "application/json")
    public InvoiceHeaderDTO addInvoiceHeader(@RequestBody InvoiceHeaderDTO object) {
        return invoiceHeaderServiceInterface.saveInvoiceHeader(object);
    }

    // http://localhost:8888/invoiceheaders/delete/1 (GET)
    @GetMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteInvoiceHeader(@PathVariable Long id) {
        if (invoiceHeaderServiceInterface.deleteInvoiceHeader(id).equals("1")) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // http://localhost:8888/invoiceheaders/update (PATCH)
    @PatchMapping(value = "/update", produces = "application/json")
    public ResponseEntity<Object> updateInvoiceHeader(@RequestBody InvoiceHeaderDTO object) {
        if (invoiceHeaderServiceInterface.updateInvoiceHeader(object).equals("1")) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // http://localhost:8888/invoiceheaders/status (GET)
    @GetMapping(value = "/status", produces = "application/json")
    public String status() {
        return "Status done";
    }

    // http://localhost:8888/invoiceheaders/byName/Edison (GET)
    @GetMapping(value = "/byName/{name}", produces = "application/json")
    public List<InvoiceHeaderDTO> likeNameInvoiceHeader(@PathVariable String name) {
        return invoiceHeaderServiceInterface.likeNameInvoiceHeader(name);
    }

    // http://localhost:8888/invoiceheaders/byFilter (GET)
    @PostMapping(value = "/byFilter", produces = "application/json")
    public List<InvoiceHeaderDTO> byFilter(@RequestBody HashMap<String, String> conditions) {
        return invoiceHeaderServiceInterface.byFilter(conditions);
    }

    // http://localhost:8888/invoiceheaders/validinvoice (GET)
    @GetMapping(value = "/validinvoice", produces = "application/json")
    public List<InvoiceHeaderDTO> validInvoice() {
        return invoiceHeaderServiceInterface.validInvoice();
    }

    // http://localhost:8888/invoiceheaders/invalidinvoice (POST)
    @GetMapping(value = "/invalidinvoice", produces = "application/json")
    public List<InvoiceHeaderDTO> invalidInvoice() {
        return invoiceHeaderServiceInterface.invalidInvoice();
    }

}