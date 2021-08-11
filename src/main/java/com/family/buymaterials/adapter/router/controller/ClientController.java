package com.family.buymaterials.adapter.router.controller;

import com.family.buymaterials.domain.service.ClientServiceInterface;
import com.family.buymaterials.domain.service.model.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientServiceInterface clientServiceInterface;

    // http://localhost:8888/clients (GET)
    @GetMapping(produces = "application/json")
    public List<ClientDTO> getClients() {
        return clientServiceInterface.findAllClients();
    }

    // http://localhost:8888/clients/1 (GET)
    @GetMapping(value = "/{id}", produces = "application/json")
    public ClientDTO getClientById(@PathVariable Long id) {
        return clientServiceInterface.findClientById(id);
    }

    // http://localhost:8888/clients/add (ADD)
    @PostMapping(value = "/add", produces = "application/json")
    public ClientDTO addClient(ClientDTO customer) {
        return clientServiceInterface.saveClient(customer);
    }

    // http://localhost:8888/clients/delete/1 (GET)
    @GetMapping(value = "/delete/{id}", produces = "application/json")
    public String deleteClient(@PathVariable Long id) {
        return clientServiceInterface.deleteClient(id);
    }

    // http://localhost:8888/clients/update (PATCH)
    @PatchMapping(value = "/update", produces = "application/json")
    public String updateClient(ClientDTO customerNew) {
        return clientServiceInterface.updateClient(customerNew);
    }

    // http://localhost:8888/clients/status (GET)
    @GetMapping(value = "/status", produces = "application/json")
    public String status() {
        return "Status done";
    }

}