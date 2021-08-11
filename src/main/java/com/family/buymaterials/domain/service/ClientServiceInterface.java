package com.family.buymaterials.domain.service;

import com.family.buymaterials.domain.service.model.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface ClientServiceInterface {

    List<ClientDTO> findAllClients();

    ClientDTO findClientById(Long id);

    ClientDTO saveClient(ClientDTO clientNew);

    String deleteClient(Long id);

    String updateClient(ClientDTO clientUpdate);

}
