package com.family.buymaterials.domain.service.impl;

import com.family.buymaterials.adapter.router.repository.ClientRepository;
import com.family.buymaterials.adapter.router.repository.InvoiceHeaderRepository;
import com.family.buymaterials.domain.repository.h2.model.Client;
import com.family.buymaterials.domain.repository.h2.model.InvoiceHeader;
import com.family.buymaterials.domain.service.ClientServiceInterface;
import com.family.buymaterials.domain.service.model.ClientDTO;
import com.family.buymaterials.domain.service.model.InvoiceHeaderDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientServiceInterface {

    private ClientRepository clientRepository;
    private ObjectMapper objectMapper;
    private InvoiceHeaderRepository invoiceHeaderRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ObjectMapper objectMapper, InvoiceHeaderRepository invoiceHeaderRepository) {
        this.clientRepository = clientRepository;
        this.objectMapper = objectMapper;
        this.invoiceHeaderRepository = invoiceHeaderRepository;
    }

    @Override
    public List<ClientDTO> findAllClients() {
        List<ClientDTO> list = new ArrayList<>();
        List<Client> listClient = clientRepository.findAll();
        if (!listClient.isEmpty()) {
            list = objectMapper.convertValue(listClient,
                    new TypeReference<List<ClientDTO>>() {
                    });
        }
        return list;
    }

    @Override
    public ClientDTO findClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        ClientDTO clientDTO = null;
        if (client.isPresent()) {
            clientDTO = objectMapper.convertValue(client.get(), new TypeReference<ClientDTO>() {
            });
            /*
            Set<InvoiceHeader> list = invoiceHeaderRepository.findByHeaderClient(client.get());
            if (!list.isEmpty()) {
                clientDTO.setInvoices(objectMapper.convertValue(list, new TypeReference<Set<InvoiceHeaderDTO>>() {
                }));
            }
             */
        }
        return clientDTO;
    }

    @Override
    public ClientDTO saveClient(ClientDTO clientNew) {
        ClientDTO response = null;
        if (clientNew != null) {
            Client client = objectMapper.convertValue(clientNew, new TypeReference<Client>() {
            });
            response = objectMapper.convertValue(clientRepository.save(client), new TypeReference<ClientDTO>() {
            });
        }
        return response;
    }

    @Override
    public String deleteClient(Long id) {
        if (clientRepository.findById(id).isPresent()) {
            clientRepository.deleteById(id);
            return "Cliente eliminado correctamente.";
        }
        return "Error! El Cliente no existe";
    }

    @Override
    public String updateClient(ClientDTO clientUpdate) {
        Long num = clientUpdate.getId();
        if (clientRepository.findById(num).isPresent()) {
            Client client = objectMapper.convertValue(clientUpdate, new TypeReference<Client>() {
            });
            clientRepository.save(client);
            return "Cliente modificado";
        }
        return "Error al modificar el Cliente";
    }
}
