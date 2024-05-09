package com.neorisjob.juniorneorismicro.controller;

import com.neorisjob.juniorneorismicro.entity.Client;
import com.neorisjob.juniorneorismicro.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService clientService;

    // build create client REST API
    // http://localhost:8080/api/client/
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Client savedClient = clientService.createClient(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    // build get client by id REST API
    // http://localhost:8080/api/client/1
    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") String clientId){
        Client client = clientService.getClientByClientId(clientId);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    // build update client REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/client/1
    public ResponseEntity<Client> updateClient(@PathVariable("id") String clientId,
                                               @RequestBody Client client){
        client.setClientId(clientId);
        Client updatedClient = clientService.updateClient(client);
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }

    // build delete client REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") String clientId){
        clientService.deleteByClientId(clientId);
        return new ResponseEntity<>("Client successfully deleted!", HttpStatus.OK);
    }

}
