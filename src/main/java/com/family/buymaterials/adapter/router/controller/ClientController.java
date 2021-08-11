package com.family.buymaterials.adapter.router.controller;

import com.family.buymaterials.domain.service.model.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    private List<ClientDTO> clients = new ArrayList<>();

    public ClientController() {
        clients.add(new ClientDTO(1L, "admin"));
        clients.add(new ClientDTO(2L, "supervisor"));
        clients.add(new ClientDTO(3L, "cajero"));
    }

    @GetMapping(value = "clients")
    public ResponseEntity<List<ClientDTO>> findAll(){
        return ResponseEntity.ok(clients);
    }


    @PutMapping(value = "clients")
    public ResponseEntity<ClientDTO> update(ClientDTO request){
        ClientDTO user = clients.stream()
                .filter(currentUser -> currentUser.getId() == request.getId())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No existe el cliente"));
        user.setName(request.getName());
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "clients")
    public ResponseEntity<ClientDTO> create(ClientDTO request){
        clients.add(request);
        return ResponseEntity.ok(request);
    }

    @DeleteMapping(value = "clients/{clientId}")
    public ResponseEntity<?> delete( @PathVariable("clientId") long userId ) {
        ClientDTO user = clients.stream()
                .filter(currentUser -> currentUser.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No existe el cliente"));
        clients.remove(user);
        return ResponseEntity.ok().build();

    }

}